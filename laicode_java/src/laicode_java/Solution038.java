package laicode_java;

import java.util.*;
//Cycle Node In Linked List
//Check if a given linked list has a cycle. Return the node where the cycle starts. Return null if there is no cycle.

public class Solution038 {
	ListNode cycleNode(ListNode head) {
		ListNode fast=head;
		ListNode slow=head;
		while(fast!=null) {
			fast=fast.next;
			slow=slow.next;
			if(fast!=null) {
				fast=fast.next;
			}
			else {
				return null;
			}
			if(fast==slow) {
				fast=head;
				while(fast!=null && slow!=null && fast!=slow) {
					fast=fast.next;
					slow=slow.next;
				}
				return fast;
			}
		}
		return null;
	}
	public static void main(String[] args) {


	}
}
