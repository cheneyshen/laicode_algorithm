package laicode_java;

import java.util.*;

//Remove Nth Node From End of List
//Given a linked list, remove the nth node from the end of list and return its head.
//
//Assumptions
//If n is not valid, you do not need to do anything to the original list.
//  Try to do this in one pass.
//      
//      Examples
//      
//      Given linked list: 1->2->3->4->5, and n = 2.
//      
//      After removing the second node from the end, the linked list becomes 1->2->3->5.
public class Solution243 {
	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			this.val=x;
			this.next=null;
		}
	}
	
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if(n<1 || head==null) {
			return head;
		}
		ListNode curr = head;
		ListNode prev = null;
		int leng=0;
		while(curr!=null) {
			leng++;
			curr = curr.next;
		}
		if(n>leng) {
			return head;
		}
		curr = head;
		leng = leng-n;
		if(leng>0) {
			while(leng>0) {
				prev = curr;
				curr = curr.next;
				leng--;
			}
			prev.next = curr.next;
			return head;
		} else {
			return head.next;
		}
	}
	
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		Solution243 ss = new Solution243();
		ListNode result=null;
		result = ss.removeNthFromEnd(l1, 0);
		while(result!=null) {
			System.out.print(result.val);
			result = result.next;
		}
		System.out.println("");
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		result = ss.removeNthFromEnd(l1, 1);
		while(result!=null) {
			System.out.print(result.val);
			result = result.next;
		}
		System.out.println("");
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		result = ss.removeNthFromEnd(l1, 2);
		while(result!=null) {
			System.out.print(result.val);
			result = result.next;
		}
		System.out.println("");
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		result = ss.removeNthFromEnd(l1, 3);
		while(result!=null) {
			System.out.print(result.val);
			result = result.next;
		}
		System.out.println("");
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		result = ss.removeNthFromEnd(l1, 4);
		while(result!=null) {
			System.out.print(result.val);
			result = result.next;
		}
		System.out.println("");
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		result = ss.removeNthFromEnd(l1, 5);
		while(result!=null) {
			System.out.print(result.val);
			result = result.next;
		}
		System.out.println("");
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		result = ss.removeNthFromEnd(l1, 6);
		while(result!=null) {
			System.out.print(result.val);
			result = result.next;
		}
		System.out.println("");
	}
}
