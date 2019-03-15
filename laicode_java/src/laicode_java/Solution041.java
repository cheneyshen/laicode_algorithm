package laicode_java;

import java.util.*;
//ReOrder Linked List
//Reorder the given singly-linked list N1 -> N2 -> N3 -> N4 -> 鈥� -> Nn -> null to be N1- > Nn -> N2 -> Nn-1 -> N3 -> Nn-2 -> 鈥� -> null
//
//Examples
//
//L = null, is reordered to null
//L = 1 -> null, is reordered to 1 -> null
//L = 1 -> 2 -> 3 -> 4 -> null, is reordered to 1 -> 4 -> 2 -> 3 -> null
//L = 1 -> 2 -> 3 -> null, is reordred to 1 -> 3 -> 2 -> null

public class Solution041 {
	class ListNode {
		public int value;
		public ListNode next;
		public ListNode(int value) {
			this.value=value;
			next=null;
		}
	}
	ListNode reorderHelper(ListNode first, ListNode second) {
		ListNode dummy = new ListNode(-1);
		ListNode cur = dummy;
		int count = 0;
		while(first!=null && second != null) {
			if(count%2==0) {
				cur.next = first;
				first = first.next;
			} else {
				cur.next = second;
				second = second.next;
			}
			cur = cur.next;
			count++;
		}
		if(first!=null) {
			cur.next = first;
		}
		if(second!=null) {
			cur.next = second;
		}
		return dummy.next;
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
	
	private ListNode getMiddle(ListNode head) {
		if(head==null || head.next==null) {
			return head;
		}
		ListNode slow = head, fast = head;
		while(fast.next!=null && fast.next.next!=null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
	
	public ListNode reorder(ListNode head) {
		if(head==null || head.next==null) {
			return head;
		}
		ListNode mid = getMiddle(head);
		ListNode second = mid.next;
		mid.next = null;
		second=reverse(second);
		ListNode result=reorderHelper(head, second);
		return result;
	}
	
	public static void main(String[] args) {


	}
}
