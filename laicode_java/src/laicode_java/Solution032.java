package laicode_java;

import java.util.*;

//Stack With min()
//Enhance the stack implementation to support min() operation. min() should return the current minimum value in the stack. If the stack is empty, min() should return -1.
//
//pop() - remove and return the top element, if the stack is empty, return -1
//push(int element) - push the element to top
//top() - return the top element without remove it, if the stack is empty, return -1
//min() - return the current min value in the stack.
class StackMinNode {
	public int value;
	public int min;
	public StackMinNode next;
	public StackMinNode(int v) {
		value=v;
		next=null;
	}
}

public class Solution032 {
	private StackMinNode head;
	
	public Solution032() {
		head=null;
	}
	
	public void push(int x) {
		StackMinNode temp = new StackMinNode(x);
		temp.next=head;
		if(head==null) {
			temp.min=x;
		}
		else {
			temp.min=Math.min(temp.min, x);
		}
		head=temp;
	}
	
	public int top() {
		if(head==null) {
			return -1;
		}
		return head.value;
	}
	
	public int min() {
		if(head==null) {
			return -1;
		}
		return head.min;
	}
	
	public static void main(String[] args) {


	}
}
