package StacksAndQueues;

import java.util.Stack;

public class ReverseStack {

	public static void reverseStack(Stack<Integer> s) {

		if (s.isEmpty())
			return;

		int data = s.pop();
		reverseStack(s);
		insertAtBottom(s, data);
	}

	public static void insertAtBottom(Stack<Integer> s, int data) {

		if (s.empty()) {
			s.push(data);
			return;
		}

		int element = s.pop();
		insertAtBottom(s, data);
		s.push(element);

	}

	public static void main(String[] args) {
		Stack<Integer> s = new Stack<Integer>();

		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		s.push(5);
		System.out.println(s);
		reverseStack(s);
		System.out.println(s);

	}

}
