package laicode_java;

import java.util.*;

import laicode_java.Solution029.ListNode;

public class Solution037 {
//  Check If Linked List Has A Cycle
//  Check if a given linked list has a cycle. Return true if it does, otherwise return false.
	class ListNode {
		public int value;
		public ListNode next;
		public ListNode(int value) {
			this.value=value;
			next=null;
		}
	}
	boolean hasCycle(ListNode head) {
		if(head==null || head.next==null) {
			return false;
		}
		ListNode fast=head, slow=head;
		while(fast!=null && fast.next!=null) {
			slow=slow.next;
			fast=fast.next.next;
			
			if(slow==fast) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		Solution037 ss=new Solution037();
	}
}
