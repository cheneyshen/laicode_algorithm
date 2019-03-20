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
		int count = 0;
		ListNode cur = head;
		while(cur!=null) {
			cur = cur.next;
			count++;
			if(count==2) {
				break;
			}
		}
		if(count==2) {
			cur = reverseInPairsI(cur);
			while(count>0) {
				ListNode next = head.next;
				head.next = cur;
				cur = head;
				head = next;
				count--;
			}
		}
		return cur;
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
		l6.next = new ListNode(7);
		l1 = reverseInPairsI(l1);
		while(l1!=null) {
			System.out.println(l1.value);
			l1=l1.next;
		}
	}
}
