package laicode_java;

import java.util.*;

//    Selection Sort Linked List
//    Given a singly-linked list, where each node contains an integer value, sort it in ascending order. The selectoin sort algorithm should be used to solve this problem.
//
//    Examples
//    null, is sorted to null
//    1 -> null, is sorted to 1 -> null
//    1 -> 2 -> 3 -> null, is sorted to 1 -> 2 -> 3 -> null
//    4 -> 2 -> 6 -> -3 -> 5 -> null, is sorted to 2 -> 3 -> 4 -> 5 -> 6
public class Solution028 {
	static class ListNode {
		public int value;
		public ListNode next;
		public ListNode(int value) {
			this.value=value;
			next=null;
		}
	}
	/*
	 * 选择排序，每次选取最小那个元素，然后交换值就好了
	 * 头是当前node,尾是null
	 */
	public ListNode selectionSort(ListNode a) {
		for(ListNode node1=a; node1!=null; node1=node1.next) {
			ListNode min=node1;
			for(ListNode node2=node1; node2!=null; node2=node2.next) {
				if(min.value>node2.value) {
					min=node2;
				}
			}
			swap(node1, min);
		}
		return a;
	}
	
	private void swap(ListNode a, ListNode b) {
		int temp=a.value;
		a.value=b.value;
		b.value=temp;
	}
	
	public static void main(String[] args) {


	}
}
