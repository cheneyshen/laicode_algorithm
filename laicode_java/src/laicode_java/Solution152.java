package laicode_java;

import java.util.*;

//Remove Extra Duplicates from Sorted List
//	Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

//	Input:  1->2->3->3->4->4->5
//	Output : 1->2->5
//	Input : 1->1->1

//	Output : NULL
public class Solution152 {
	static class ListNode {
		public int value;
		public ListNode next;
		public ListNode(int value) {
			this.value=value;
			next=null;
		}
	}
	
	public ListNode removeDup(ListNode head) {
		if(head==null || head.next==null) {
			return head;
		}
		ListNode fake = new ListNode(-1);
		fake.next = head;
		ListNode prev = fake;
		ListNode slow = head;
		ListNode fast1 = head, fast2 = head;
		int dist = 0;
		while(fast2!=null) {
			while(fast2!=null && fast2.value == fast1.value) {
				fast2 = fast2.next;
				dist++;
			}
			if(dist==1) {
				slow.value = fast1.value;
				prev = slow;
				slow = slow.next;
				fast1 = fast2;
				dist=0;
			} else {
				fast1 = fast2;
				dist = 0;
			}
		}
		prev.next = null;
		return fake.next;
	}
	
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(3);
		ListNode l5 = new ListNode(4);
		ListNode l6 = new ListNode(4);
		ListNode l7 = new ListNode(5);
		l1.next=l2;
		l2.next=l3;
		l3.next=l4;
		l4.next=l5;
		l5.next=l6;
		l6.next=l7;
		Solution152 ss = new Solution152();
		l1  = ss.removeDup(l1);
		System.out.println(l1.next.next.value);
		l1 = new ListNode(1);
		l2 = new ListNode(1);
		l3 = new ListNode(1);
		l4 = new ListNode(1);
		l1.next=l2;
		l2.next=l3;
		l3.next=l4;
		l1 = ss.removeDup(l1);
		System.out.println(l1==null);
	}
}
