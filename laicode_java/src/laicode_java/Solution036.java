package laicode_java;

import java.util.*;

import laicode_java.Solution029.ListNode;

public class Solution036 {

//  Middle Node Of Linked List
//  Find the middle node of a given linked list.
//  
//  Examples
//  
//  L = null, return null
//  L = 1 -> null, return 1
//  L = 1 -> 2 -> null, return 1
//  L = 1 -> 2 -> 3 -> null, return 2
//  L = 1 -> 2 -> 3 -> 4 -> null, return 2
	class ListNode {
		public int value;
		public ListNode next;
		public ListNode(int value) {
			this.value=value;
			next=null;
		}
	}
	ListNode middleNode(ListNode head) {
		if(head==null || head.next==null) {
			return head;
		}
		ListNode fast=head;
		ListNode slow=head;
		while(fast.next!=null && fast.next.next!=null) {
			slow=slow.next;
			fast=fast.next.next;
		}
		return slow;
	}
	
	public static void main(String[] args) {


	}
}
