package StacksAndQueues;

import java.util.Stack;

public class StackMin {
	Stack<Integer> s;
	Stack<Integer> minStack;
	int min;

	public StackMin() {
		s = new Stack<Integer>();
		minStack = new Stack<Integer>();
		min = 0;
	}

	public void push(int element) {
		if (s.isEmpty()) {
			minStack.push(element);
			min = element;
		} else {
			if (element <= min) {
				minStack.push(element);
				min = element;
			}
		}
		s.push(element);

	}

	public int pop() {

		if (s.peek() == minStack.peek()) {
			minStack.pop();
			min = minStack.peek();
		}

		return s.pop();
	}

	public int min() {

		return minStack.peek();
	}

	public int peek() {
		return s.peek();
	}

	public boolean isEmpty() {

		return s.isEmpty();
	}

	public int size() {

		return s.size();
	}

	public static void main(String[] args) {
		StackMin ms = new StackMin();
		ms.push(1);
		ms.push(2);
		System.out.println(ms.min());
		ms.push(3);
		ms.push(-1);
		System.out.println(ms.min());
		ms.push(4);
		ms.push(-1);
		ms.push(-3);
		System.out.println(ms.min());
		ms.pop();
		System.out.println(ms.min());
		ms.pop();
		System.out.println(ms.min());
	}

}
