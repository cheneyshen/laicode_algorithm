package laicode_java;

import java.util.*;
//Cycle Node In Linked List
//Check if a given linked list has a cycle. Return the node where the cycle starts. Return null if there is no cycle.

import laicode_java.Solution029.ListNode;

public class Solution038 {
	static class ListNode {
		public int value;
		public ListNode next;
		public ListNode(int value) {
			this.value=value;
			next=null;
		}
	}
	/*
	 *	             fs
	 *	  1->2->3->4->5->6
	 *	        |        |
	 *	        <---------
	 */
	static ListNode cycleNode(ListNode head) {
		if(head == null || head.next == null) {
			return null;
		}
		ListNode fast=head, slow=head;
		while(fast!=null && fast.next!=null) {
			slow=slow.next;
			fast=fast.next.next;
			//当两个相遇时，有环
			if(fast == slow) {
				//从头开始，步长一致找到环开始的地方
				ListNode cur = head;
				while(cur != slow) {
					cur = cur.next;
					slow = slow.next;
				}
				//重新利用fast,找环内的长度
				fast = head;
				int outer = 0, inner = 0;
				while(fast != cur) {
					fast = fast.next;
					outer++;
				}
				//重新利用fast,找环外的长度
				fast = fast.next;
				inner++;
				while(fast != cur) {
					fast = fast.next;
					inner++;
				}
				System.out.println(outer + " " + inner);
				return cur;
			}
		}
		return null;
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
		l6.next = l3;
		System.out.println(cycleNode(l1).value);
	}
}
