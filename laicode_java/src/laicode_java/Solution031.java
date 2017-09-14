package laicode_java;

import java.util.*;
//Queue By Two Stacks
//Java: Implement a queue by using two stacks. The queue should provide size(), isEmpty(), offer(), poll() and peek() operations. When the queue is empty, poll() and peek() should return null.
//
//C++: Implement a queue by using two stacks. The queue should provide size(), isEmpty(), push(), front() and pop() operations. When the queue is empty, front() should return -1.
//
//Assumptions
//
//The elements in the queue are all Integers.
//size() should return the number of elements buffered in the queue.
//isEmpty() should return true if there is no element buffered in the queue, false otherwise.

public class Solution031 {
	private Stack<Integer> stack1;
	private Stack<Integer> stack2;
	
	public boolean isEmpty() {
		return stack1.empty() && stack2.empty();
	}
	
	public void offer(int e) {
		stack1.push(e);
	}
	
	public int poll() {
		if(!stack2.empty()) {
			return stack2.pop();
		}
		else if(!stack1.empty()) {
			while(!stack1.empty()) {
				stack2.push(stack1.pop());
			}
			return stack2.pop();
		}
		else {
			return -1;
		}
	}
	
	public int peek() {
		if(!stack2.empty()) {
			return stack2.peek();
		}
		else if(!stack1.empty()) {
			while(!stack1.empty()) {
				stack2.push(stack1.pop());
			}
			return stack2.peek();
		}
		else {
			return -1;
		}
	}
	
	public int size() {
		return stack1.size()+stack2.size();
	}
	
	public static void main(String[] args) {


	}
}
