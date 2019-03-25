package laicode_java;

import java.util.*;

//Add Two Numbers
//You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
//
//Example
//
//Input: (2 -> 4 -> 5) + (5 -> 6 -> 4)
//
//Output: 7 -> 0 -> 0 -> 1
public class Solution223 {
	static class ListNode {
		public int key;
		public ListNode next;
		public ListNode(int key) {
			this.key=key;
			this.next=null;
		}
	}
	public ListNode addTwo(ListNode l1, ListNode l2) {
		//标准带dummy做法
		ListNode dummy=new ListNode(-1);
		ListNode curr=dummy;
		int carry=0;	//进位符
		while(l1!=null && l2!=null) {
			carry+=l1.key;
			carry+=l2.key;
			curr.next=new ListNode(carry%10);
			carry=carry/10;
			curr=curr.next;
			l1=l1.next;
			l2=l2.next;
		}
		while(l1!=null) {
			carry+=l1.key;
			curr.next=new ListNode(carry%10);
			carry=carry/10;
			curr=curr.next;
			l1=l1.next;
		}
		while(l2!=null) {
			carry+=l2.key;
			curr.next=new ListNode(carry%10);
			carry=carry/10;
			curr=curr.next;
			l2=l2.next;
		}
		if(carry!=0) {
			curr.next=new ListNode(carry);
		}
		return dummy.next;
	}
	public static void main(String[] args) {
		ListNode l1=new ListNode(2);
		ListNode l2=new ListNode(4);
		ListNode l3=new ListNode(5);
		ListNode l4=new ListNode(1);
		l1.next=l2;
		l2.next=l3;
		l3.next=l4;
		ListNode r1=new ListNode(5);
		ListNode r2=new ListNode(6);
		ListNode r3=new ListNode(4);
		r1.next=r2;
		r2.next=r3;
		Solution223 ss = new Solution223();
		ListNode result = ss.addTwo(l1, r1);
		System.out.println(result.key);
		System.out.println(result.next.key);
		System.out.println(result.next.next.key);
		System.out.println(result.next.next.next.key);
	}
}
