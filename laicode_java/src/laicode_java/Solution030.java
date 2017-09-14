package laicode_java;

import java.util.*;

//    Quick Sort Linked List
//    Given a singly-linked list, where each node contains an integer value, sort it in ascending order. The quick sort algorithm should be used to solve this problem.
//
//    Examples
//
//    null, is sorted to null
//    1 -> null, is sorted to 1 -> null
//    1 -> 2 -> 3 -> null, is sorted to 1 -> 2 -> 3 -> null
//    4 -> 2 -> 6 -> -3 -> 5 -> null, is sorted to -3 -> 2 -> 4 -> 5 -> 6

class ListNode {
	public int value;
	public ListNode next;
	public ListNode(int value) {
		this.value=value;
		next=null;
	}
}

public class Solution030 {
	public ListNode quickSort(ListNode a) {
		if(a==null || a.next==null) {
			return a;
		}
		ListNode head=a;
		ListNode result=quickSortHelper(head, null);
		return result;
	}
	
	private ListNode quickSortHelper(ListNode head, ListNode tail) {
		if(head==null || head==tail) {
			return head;
		}
		ListNode pivot=partition(head, tail);
		quickSortHelper(head, pivot);
		quickSortHelper(pivot.next, tail);
		return head;
	}
	
	private ListNode partition(ListNode head, ListNode tail) {
		int pivot=head.value;
		ListNode i=head, j=head.next;
		while(j!=tail) {
			if(j.value<=pivot) {
				i=i.next;
				int temp=i.value;
				i.value=j.value;
				j.value=temp;
			}
			j=j.next;
		}
		head.value=i.value;
		i.value=pivot;
		return i;
	}
	
	public static void main(String[] args) {

		ListNode l1=new ListNode(2);
		ListNode l2=new ListNode(1);
		ListNode l3=new ListNode(4);
		ListNode l4=new ListNode(3);
		ListNode l5=new ListNode(6);
		ListNode l6=new ListNode(5);
		l1.next=l2;
		l2.next=l3;
		l3.next=l4;
		l4.next=l5;
		l5.next=l6;
		Solution030 ss = new Solution030();
		l1 = ss.quickSort(l1);
		while(l1!=null) {
			System.out.println(l1.value);
			l1=l1.next;
		}
	}
}
