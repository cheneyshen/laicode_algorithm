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
	private LinkedList<Integer> in = new LinkedList<>();
	private LinkedList<Integer> out = new LinkedList<>();
	
	public boolean isEmpty() {
		return in.isEmpty() && out.isEmpty();
	}
	
	public void offer(int e) {
		in.offerFirst(e);
	}
	
	public int poll() {
		if(out.isEmpty()==false) {
			return out.pop();
		} else if(!in.isEmpty()) {
			while(!in.isEmpty()) {
				out.push(in.pop());
			}
			return out.pop();
		} else {
			return -1;
		}
	}
	
	public int peek() {
		if(!out.isEmpty()) {
			return out.peek();
		} else if(!in.isEmpty()) {
			while(!in.isEmpty()) {
				out.push(in.pop());
			}
			return out.peek();
		} else {
			return -1;
		}
	}
	
	public int size() {
		return in.size()+out.size();
	}
	
	public static void main(String[] args) {


	}
}
