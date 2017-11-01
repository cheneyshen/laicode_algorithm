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
		char data;
		ListNode next;
		ListNode(char d) {
			data = d;
			next = null;
		}
	}
	ListNode head;
	ListNode slow, fast, second;
	boolean isPalindrome(ListNode head) {
		slow = head;
		fast = head;
		ListNode prev = null;
		ListNode midd = null;
		boolean result = true;
		
		if(head!=null && head.next!=null) {
			while(fast!=null && fast.next!=null) {
				fast = fast.next.next;
				prev = slow;
				slow = slow.next;
			}
			
			if(fast!=null) {
				midd = slow;
				slow = slow.next;
			}
			
			second = slow;
			prev.next = null;
			reverse();
			result = compareHelper(head, second);
			reverse();
			if(midd!=null) {
				prev.next = midd;
				midd.next = second;
			} else {
				prev.next = second;
			}
		}
		return result;
	}
	
	void reverse() {
		ListNode prev = null;
		ListNode curr = second;
		ListNode next;
		while(curr!=null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		second = prev;
	}
	
	boolean compareHelper(ListNode head1, ListNode head2) {
		ListNode temp1 = head1;
		ListNode temp2 = head2;
		while (temp1 !=null && temp2 !=null) {
			if(temp1.data == temp2.data) {
				temp1 = temp1.next;
				temp2 = temp2.next;
			} else {
				return false;
			}
		}
		if(temp1==null && temp2==null) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {


	}
}
