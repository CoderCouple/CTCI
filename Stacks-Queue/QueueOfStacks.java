package StacksAndQueues;

import java.util.Stack;

public class QueueOfStacks {

	private Stack<Integer> s1;
	private Stack<Integer> s2;
	private Stack<Integer> curr;
	private boolean was_last_operation_push;

	public QueueOfStacks() {
		s1 = new Stack<Integer>();
		s2 = new Stack<Integer>();
		was_last_operation_push = true;
		curr = s1;
	}

	public void push(int data) {
		if (was_last_operation_push)
			curr.push(data);
		else {
			switchStack();
			curr.push(data);
		}
		was_last_operation_push=true;
	}

	public int pop() throws Exception {

		if (was_last_operation_push) {
			switchStack();
			if (!curr.isEmpty())
				return curr.pop();
			was_last_operation_push=false;

		} else {

			if (!curr.isEmpty())
				return curr.pop();
			was_last_operation_push=false;
		}

		throw new Exception("No element to pop ...!!!");
	}

	public int peek() throws Exception {

		if (was_last_operation_push) {
			switchStack();
			if (!curr.isEmpty())
				return curr.peek();
			was_last_operation_push=false;

		} else {

			if (!curr.isEmpty())
				return curr.peek();
			was_last_operation_push=false;
		}
		throw new Exception("No element to peek ...!!!");
	}

	public int size() {
		return curr.size();
	}

	public boolean isEmpty() {
		return curr.isEmpty();
	}

	public void switchStack() {
		Stack<Integer> from;
		Stack<Integer> to;

		from = s1.isEmpty() ? s2 : s1;
		to = s1.isEmpty() ? s1 : s2;

		while (!from.isEmpty()) {
			to.push(from.pop());
		}

		curr = to;

	}

	public String toString() {

		if (was_last_operation_push) {
			switchStack();
			String s= curr.toString();
			switchStack();
			return s;
		}

		return curr.toString();
	}

	public static void main(String[] args) throws Exception {
		QueueOfStacks q = new QueueOfStacks();
		q.push(1);
		q.push(2);
		q.push(3);
		q.push(4);
		System.out.println(q);
		q.pop();
		System.out.println(q);

	}

}
