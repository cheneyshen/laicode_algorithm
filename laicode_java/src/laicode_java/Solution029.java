package laicode_java;

import java.util.*;

//    Merge Sort Linked List
//    Given a singly-linked list, where each node contains an integer value, sort it in ascending order. The merge sort algorithm should be used to solve this problem.
//
//    Examples
//
//    null, is sorted to null
//    1 -> null, is sorted to 1 -> null
//    1 -> 2 -> 3 -> null, is sorted to 1 -> 2 -> 3 -> null
//    4 -> 2 -> 6 -> -3 -> 5 -> null, is sorted to -3 -> 2 -> 4 -> 5 -> 6
public class Solution029 {
	static class ListNode {
		public int value;
		public ListNode next;
		public ListNode(int value) {
			this.value=value;
			this.next=null;
		}
	}
	
	public ListNode mergeSort(ListNode a) {
		if(a==null || a.next==null) {
			return a;
		}
		ListNode left=a;
		ListNode right=getMiddle(a);
		ListNode prev=right;
		right=right.next;
		prev.next=null;
		
		left=mergeSort(left);
		right=mergeSort(right);
		return merge(left, right);
	}
	
	private ListNode getMiddle(ListNode head) {
		if(head==null || head.next==null) {
			return head;
		}
		ListNode slow=head, fast=head;
		//这里需要用fast.next && fast.next.next，意思是凑不齐2个就不走
		while(fast.next!=null && fast.next.next!=null) {
			slow=slow.next;
			fast=fast.next.next;
		}
		return slow;
	}
	
	private ListNode merge(ListNode left, ListNode right) {
		if(left==null) {
			return right;
		}
		if(right==null) {
			return left;
		}
		ListNode dummy = new ListNode(-1);
		ListNode cur = dummy;
		while(left !=null && right !=null) {
			if(left.value<=right.value) {
				cur.next=left;
				left=left.next;
				cur=cur.next;
			} else {
				cur.next=right;
				right=right.next;
				cur=cur.next;
			}
		}
		if (left!=null) {
			cur.next=left;
		}
		if (right!=null) {
			cur.next=right;
		}
		return dummy.next;
	}
	
	public static void main(String[] args) {


	}
}
