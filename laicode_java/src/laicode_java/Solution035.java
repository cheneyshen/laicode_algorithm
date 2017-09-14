package laicode_java;

import java.util.*;
//    Reverse Linked List In Pairs
//    Reverse pairs of elements in a singly-linked list.
//
//    Examples
//
//    L = null, after reverse is null
//    L = 1 -> null, after reverse is 1 -> null
//    L = 1 -> 2 -> null, after reverse is 2 -> 1 -> null
//    L = 1 -> 2 -> 3 -> null, after reverse is 2 -> 1 -> 3 -> null

public class Solution035 {
	ListNode reverseInPairs(ListNode head) {
		if(head==null || head.next==null) {
			return head;
		}
		ListNode next=head.next;
		head.next=reverseInPairs(next.next);
		next.next=head;
		return next;
	}
	
	public static void main(String[] args) {


	}
}
