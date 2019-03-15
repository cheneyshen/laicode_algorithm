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
	class ListNode {
		public int value;
		public ListNode next;
		public ListNode(int value) {
			this.value=value;
			next=null;
		}
	}
	ListNode insert(ListNode head, int value) {
		if(head==null) {
			return new ListNode(value);
		}
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode cur = head, pre = dummy;
		while(cur!=null && cur.value<=value) {
			pre = cur;
			cur = cur.next;
		}
		ListNode newnode = new ListNode(value);
		newnode.next = pre.next;
		pre.next = newnode;
		return dummy.next;
	}
	
	public static void main(String[] args) {


	}
}
