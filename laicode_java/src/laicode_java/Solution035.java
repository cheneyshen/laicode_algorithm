package laicode_java;

import java.util.*;
//    Reverse Linked List In Pairs
//    Reverse pairs of elements in a singly-linked list.
//
//    Examples
//
//    L = null, after reverse is null
//    L = 1 -> null, after reverse is 1 -> null
//    L = 1 -> 2 -> null, after reverse is 2 -> 1 -> null
//    L = 1 -> 2 -> 3 -> null, after reverse is 2 -> 1 -> 3 -> null

import laicode_java.Solution029.ListNode;

public class Solution035 {

	static class ListNode {
		public int value;
		public ListNode next;
		public ListNode(int value) {
			this.value=value;
			next=null;
		}
	}
	ListNode reverseInPairs(ListNode head) {
		if(head==null || head.next==null) {
			return head;
		}
		ListNode nextNode = head.next;
		head.next=reverseInPairs(nextNode.next);
		nextNode.next=head;
		return nextNode;
	}
	
	public static void main(String[] args) {


	}
}
