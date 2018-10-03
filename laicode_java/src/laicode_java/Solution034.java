package laicode_java;

import java.util.*;

import laicode_java.Solution029.ListNode;

//Reverse Linked List
//Reverse a singly-linked list.
//
//Examples
//
//L = null, return null
//L = 1 -> null, return 1 -> null
//L = 1 -> 2 -> 3 -> null, return 3 -> 2 -> 1 -> null
public class Solution034 {

	static class ListNode {
		public int value;
		public ListNode next;
		public ListNode(int value) {
			this.value=value;
			next=null;
		}
	}
	ListNode reverse(ListNode head) {
		if(head==null || head.next==null) {
			return head;
		}
		ListNode prev=null;
		ListNode curr=head;
		ListNode next=null;
		while(curr!=null) {
			next=curr.next;
			curr.next=prev;
			prev=curr;
			curr=next;
		}
		return prev;
	}
	ListNode reverse1(ListNode head) {
		if(head==null || head.next==null) {
			return head;
		}
		ListNode newNode=head.next;
		ListNode newHead=reverse1(newNode);
		newNode.next=head;
		head.next=null;
		return newHead;
	}
	
	public static void main(String[] args) {


	}
}
