package laicode_java;

import java.util.*;
//Insert In Sorted Linked List
//Insert a value in a sorted linked list.
//
//Examples
//
//L = null, insert 1, return 1 -> null
//L = 1 -> 3 -> 5 -> null, insert 2, return 1 -> 2 -> 3 -> 5 -> null
//L = 1 -> 3 -> 5 -> null, insert 3, return 1 -> 3 -> 3 -> 5 -> null
//L = 2 -> 3 -> null, insert 1, return 1 -> 2 -> 3 -> null

import laicode_java.Solution029.ListNode;

public class Solution039 {
	static class ListNode {
		public int value;
		public ListNode next;
		public ListNode(int value) {
			this.value=value;
			next=null;
		}
	}
	ListNode insert(ListNode head, int value) {
		ListNode node=new ListNode(value);
		if(head==null || head.value>=value) {
			node.next=head;
			head=node;
			return head;
		}
		ListNode prev=head;
		while(prev.next!=null && prev.next.value<value) {
			prev=prev.next;
		}
		node.next=prev.next;
		prev.next=node;
		return head;
	}
	
	public static void main(String[] args) {


	}
}
