package laicode_java;

import java.util.*;

//Remove Duplicates from Sorted List
//Given a sorted linked list, delete all duplicates such that each element appear only once.
//
//Input: 1->1->2
//
//Output: 1->2
public class Solution153 {
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
		ListNode prev=new ListNode(-1);
		prev.next = head;
		ListNode slow=head, fast1=head, fast2=head;
		while(fast2!=null) {
			while(fast2!=null && fast2.value==fast1.value) {
				fast2=fast2.next;
			}
			slow.value=fast1.value;
			prev = slow;
			slow = slow.next;
			fast1 = fast2;
		}
		prev.next = null;
		return head;
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
		Solution153 ss = new Solution153();
		l1 = ss.removeDup(l1);
	}
}
