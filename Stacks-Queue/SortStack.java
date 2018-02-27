package StacksAndQueues;

import java.util.Collections;
import java.util.Stack;

public class SortStack {

	public static Stack<Integer> sortStack(Stack<Integer> s) {
		Stack<Integer> st = new Stack<Integer>();

		while (!s.isEmpty()) {
			int data = s.pop();
			

			while (!st.isEmpty() && st.peek() <= data) {
				s.push(st.pop());
			}
			st.push(data);
		}
	
		return st;
		
	}

	public static void main(String[] args) {

		Stack<Integer> stk = new Stack<Integer>();
		stk.push(1);
		stk.push(9);
		stk.push(5);
		stk.push(2);
		stk.push(7);
		System.out.println(stk);
		System.out.println(sortStack(stk));
		
	}

}
