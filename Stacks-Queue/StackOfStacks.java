package StacksAndQueues;

import java.util.Stack;

public class StackOfStacks {

	Stack<Integer> s;
	Stack<Stack> sos;
	int threshold;
	
	public StackOfStacks(){
		s = new Stack<Integer>();
		sos = new Stack<Stack>();
		threshold =3;
	}
	
	public StackOfStacks(int limit){
		s = new Stack<Integer>();
		sos = new Stack<Stack>();
		threshold =limit;
	}
	
	public void push(int item){
		s.push(item);
		if(s.size()>=threshold){
			sos.push(s);
			s = new Stack<Integer>();
			
		}
	}
	
	public int pop() throws Exception{
		if(!s.isEmpty())
		return s.pop();
		
		if(!sos.isEmpty()){
		s= sos.pop();
		return s.pop();}
		
		throw new Exception("No Element to pop ");
	}
	
	public int peek() throws Exception{
		if(!s.isEmpty())
			return s.peek();
			
			if(!sos.isEmpty()){
			Stack<Integer> temp= sos.peek();
			return temp.peek();}
			
			throw new Exception("No Element to peek ");
	}
	
	public String toString(){
		return sos.toString();
	}
	
	public static void main(String[] args) throws Exception {
		StackOfStacks sos = new StackOfStacks();
		sos.push(1);
		sos.push(2);
		sos.push(3);
		sos.push(4);
		sos.push(5);
		sos.push(6);
		System.out.println(sos.toString());
		System.out.println(sos.peek());
		System.out.println(sos.pop());
		sos.push(6);
		sos.push(7);
		System.out.println(sos.pop());
		System.out.println(sos.pop());
		
	}

}
