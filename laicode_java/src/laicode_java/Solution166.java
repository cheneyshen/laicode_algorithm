package laicode_java;

import java.util.*;

//Rotate List by K places
//Given a list, rotate the list to the right by k places, where k is non-negative.
//
//Input: 1->2->3->4->5->NULL, k = 2
//
//Output: 4->5->1->2->3->NULL
public class Solution166 {
	static class ListNode {
		public int value;
		public ListNode next;
		public ListNode(int value) {
			this.value=value;
			next=null;
		}
	}
	
	public ListNode rotateKplace(ListNode head, int k) {
		if(head==null || k==0) {
			return head;
		}
		int leng=1;
		ListNode cur=head;
		while(cur.next!=null) {
			cur = cur.next;
			leng++;
		}
		k = leng - k%leng;
		cur.next = head;
		while(k-->0) {
			cur = cur.next;
		}
		head = cur.next;
		cur.next = null;
		return head;
 	}
	
	public static void main(String[] args) {
		Solution166 ss = new Solution166();
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		l1.next=l2;
		l2.next=l3;
		l3.next=l4;
		l4.next=l5;
		l1 = ss.rotateKplace(l1, 2);
		System.out.println(l1.value);
	}
}
