package laicode_java;

import java.util.*;
//Partition Linked List
//Given a linked list and a target value T, partition it such that all nodes less than T are listed before the nodes larger than or equal to target value T. The original relative order of the nodes in each of the two partitions should be preserved.
//
//Examples
//
//L = 2 -> 4 -> 3 -> 5 -> 1 -> null, T = 3, is partitioned to 2 -> 1 -> 4 -> 3 -> 5 -> null

public class Solution042 {
	ListNode partition(ListNode head, int target) {
		if(head==null) {
			return null;
		}
		ListNode fakeSmall=new ListNode(-1);
		ListNode fakeLarge=new ListNode(-1);
		ListNode currSmall=fakeSmall;
		ListNode currLarge=fakeLarge;
		while(head!=null) {
			if(head.value<target) {
				currSmall.next=head;
				currSmall=currSmall.next;
				head=head.next;
			}
			else {
				currLarge.next=head;
				currLarge=currLarge.next;
				head=head.next;
			}
		}
		currSmall.next=fakeLarge.next;
		currLarge.next=null;
		return fakeSmall.next;
	}
	
	public static void main(String[] args) {


	}
}
