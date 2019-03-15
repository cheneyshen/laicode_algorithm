package laicode_java;

import java.util.*;

//Stack With min()
//Enhance the stack implementation to support min() operation. min() should return the current minimum value in the stack. If the stack is empty, min() should return -1.
//
//pop() - remove and return the top element, if the stack is empty, return -1
//push(int element) - push the element to top
//top() - return the top element without remove it, if the stack is empty, return -1
//min() - return the current min value in the stack.

public class Solution032 {
	private Deque<Integer> stack;
	private Deque<Integer> minstack;
	public Solution032() {
		stack = new LinkedList<Integer>();
		minstack = new LinkedList<Integer>();
	}
	public int pop() {
		if(stack.isEmpty()) {
			return -1;
		}
		int cur = stack.peekFirst();
		if(minstack.peekFirst()==cur) {
			minstack.pollFirst();
		}
		return stack.pollFirst();
	}
	
	public void push(int x) {
		stack.offerFirst(x);
		if(minstack.isEmpty() || minstack.peekFirst()>=x) {
			minstack.offerFirst(x);
		}
	}
	
	public int top() {
		if(stack.isEmpty()) {
			return -1;
		}
		return stack.peek();
	}
	
	public int min() {
		if(minstack.isEmpty()) {
			return -1;
		}
		return minstack.peekFirst();
	}
	
	public static void main(String[] args) {


	}
}
