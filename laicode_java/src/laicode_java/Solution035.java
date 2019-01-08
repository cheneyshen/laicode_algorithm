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
	
	/*
	 * 0->1->2->3->4->5->6->nl
	 * c  n  nn
	 *    1<-2<-
	 * 
	 */
	
	static ListNode reverseInPairsI(ListNode head) {
		if(head==null || head.next==null) {
			return head;
		}
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode cur = dummy;
		while(cur.next!=null && cur.next.next!=null) {
			ListNode next = cur.next.next;
			cur.next.next = next.next;
			next.next = cur.next;
			cur.next = next;
			cur = cur.next.next;
		}
		return dummy.next;
	}
	
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		ListNode l6 = new ListNode(6);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		l5.next = l6;
		l1 = reverseInPairsI(l1);
	}
}
