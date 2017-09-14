package laicode;

import java.util.*;

public class Solution036 {

//  Middle Node Of Linked List
//  Find the middle node of a given linked list.
//  
//  Examples
//  
//  L = null, return null
//  L = 1 -> null, return 1
//  L = 1 -> 2 -> null, return 1
//  L = 1 -> 2 -> 3 -> null, return 2
//  L = 1 -> 2 -> 3 -> 4 -> null, return 2
	ListNode middleNode(ListNode head) {
		if(head==null || head.next==null) {
			return head;
		}
		ListNode fast=head;
		ListNode slow=head;
		while(fast.next!=null && fast.next.next!=null) {
			fast=fast.next;
			slow=slow.next;
			if(fast!=null) {
				fast=fast.next;
			}
		}
		return slow;
	}
	
	public static void main(String[] args) {


	}
}
