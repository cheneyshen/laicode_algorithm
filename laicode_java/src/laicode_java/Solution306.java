package laicode_java;

import java.util.*;

//Check If Linked List Is Palindrome
//Given a linked list, check whether it is a palindrome.
//
//Examples:
//
//Input:   1 -> 2 -> 3 -> 2 -> 1 -> null
//
//output: true.
//
//Input:   1 -> 2 -> 3 -> null
//
//output: false.
//
//Requirements:
//
//Space complexity must be O(1)
public class Solution306 {
	static class ListNode {
		public int value;
		public ListNode next;
		public ListNode(int value) {
			this.value = value;
			this.next = null;
		}
	}
	
	public boolean isPalindrome(ListNode head) {
		if(head==null || head.next==null) {
			return true;
		}

		ListNode slow = head, fast = head;
		//先拆2半
		while(fast.next!=null && fast.next.next!=null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		ListNode secondHead = slow.next;
		slow.next = null;
		//反转第二部分
		secondHead = reverse(secondHead);
		ListNode p = head, q = secondHead;
		//逐个比较
		while(p!=null && q!=null) {
			if(p.value != q.value) {
				return false;
			}
			p = p.next;
			q = q.next;
		}
		return true;
	}
	
	ListNode reverse(ListNode head) {
		if(head==null || head.next==null) {
			return null;
		}
		ListNode prev=null, curr = head, next = null;
		while(curr!=null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}
	
	public static void main(String[] args) {
		// 1 -> 2 -> 3 -> 2 -> 1
		ListNode n1 = new ListNode('1');
		ListNode n2 = new ListNode('2');
		ListNode n3 = new ListNode('3');
		ListNode n4 = new ListNode('4');
		ListNode n5 = new ListNode('5');
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		Solution306 solution = new Solution306();
		ListNode result = solution.reverse(n1);
		System.out.println(result.value);
	}
}
