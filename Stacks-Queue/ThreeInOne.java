package StacksAndQueues;

import java.util.Arrays;

public class ThreeInOne {

	public int array[];
	int numberOfStacks, capacity;
	int tops[];
	int sizes[];

	public ThreeInOne() {
		capacity = 5;
		numberOfStacks = 3;
		array = new int[capacity * numberOfStacks];
		tops = new int[numberOfStacks];
		sizes = new int[numberOfStacks];
	}

	public ThreeInOne(int num) {
		capacity = 5;
		numberOfStacks = num;
		array = new int[capacity * numberOfStacks];
		tops = new int[numberOfStacks];
		sizes = new int[numberOfStacks];
	}

	public ThreeInOne(int num, int capacity) {
		this.capacity = capacity;
		numberOfStacks = num;
		array = new int[capacity * numberOfStacks];
		tops = new int[numberOfStacks];
		sizes = new int[numberOfStacks];
	}

	public void push(int stackId, int data) throws Exception {

		if (sizes[stackId - 1] >= capacity)
			throw new Exception("Stack is Full...!!!");

		array[getTop(stackId)] = data;
		sizes[stackId - 1] = sizes[stackId - 1] + 1;
		tops[stackId - 1] = tops[stackId - 1] + 1;
	}

	public int pop(int stackId) throws Exception {

		if (sizes[stackId - 1] <= 0)
			throw new Exception("Stack is Empty...!!!");

		int data = array[getTop(stackId)-1];
		array[getTop(stackId)-1]=0;
		sizes[stackId - 1] = sizes[stackId - 1] - 1;
		tops[stackId - 1] = tops[stackId - 1] - 1;
		return data;
	}

	public int peek(int stackId) throws Exception {

		if (sizes[stackId - 1] <= 0)
			throw new Exception("Stack is Empty...!!!");

		int data = array[getTop(stackId)-1];
		return data;
	}

	public boolean isEmpty(int stackId) {
		return sizes[stackId - 1]==0;
	}

	public int size(int stackId) {
		return sizes[stackId - 1];
	}

	public int getTop(int stackId) {
		return (stackId-1)*capacity+sizes[stackId - 1];
	}

	public String toString() {
		return Arrays.toString(array);
	}
	
	public static void main(String[] args) throws Exception {
	
		ThreeInOne s = new ThreeInOne();
		s.push(1, 1);
		s.push(2, 2);
		s.push(3, 3);
		System.out.println(s.toString());
		s.push(1, 4);
		s.push(2, 5);
		s.push(3, 6);
		System.out.println(s.toString());
		s.push(1, 7);
		s.push(2, 8);
		s.push(3, 9);
		System.out.println(s.toString());
		
		s.pop(2);
		System.out.println(s.toString());
		System.out.println(s.peek(2));
		System.out.println(s.isEmpty(2));
		System.out.println(s.size(2));
		
	}

}
