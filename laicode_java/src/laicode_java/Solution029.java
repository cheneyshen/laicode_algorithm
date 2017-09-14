package laicode;

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
	class ListNode {
		public int value;
		public ListNode next;
		public ListNode(int value) {
			this.value=value;
			next=null;
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
		if(prev!=null) {
			prev.next=null;
		}
		left=mergeSort(left);
		right=mergeSort(right);
		a=merge(left, right);
		return a;
	}
	
	private ListNode getMiddle(ListNode head) {
		if(head==null || head.next==null) {
			return head;
		}
		ListNode slow=head, fast=head;
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
		else if(right==null) {
			return left;
		}
		else {
			ListNode result, index;
			if(left.value<=right.value) {
				result=left;
				left=left.next;
			}
			else {
				result=right;
				right=right.next;
			}
			index=result;
			while(left !=null && right !=null) {
				if(left.value<=right.value) {
					index.next=left;
					left=left.next;
					index=index.next;
				}
				else {
					index.next=right;
					right=right.next;
					index=index.next;
				}
			}
			if (left!=null) {
				index.next=left;
			}
			if (right!=null) {
				index.next=right;
			}
			return result;
		}
	}
	
	public static void main(String[] args) {


	}
}
