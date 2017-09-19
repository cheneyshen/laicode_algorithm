package laicode_java;

import java.util.*;

import laicode_java.Solution028.ListNode;

//Linked List Insert At Index
//Insert a new element at a specific index in the given linked list. The index is 0 based, and if the index is out of the list's scope, you do not need to do anything.
//
//Examples:
//
//1 -> 2 -> 3 -> null, insert 4 at index 3, --> 1 -> 2 -> 3 -> 4 -> null
//
//1 -> 2 -> null, insert 4 at index 0, --> 4 -> 1 -> 2 -> null
//

public class Solution366 {
	static class ListNode {
		public int value;
		public ListNode next;
		public ListNode(int value) {
			this.value=value;
			next=null;
		}
	}

	public ListNode insert(ListNode head, int index, int value) {
	    // Write your solution here.
		return head;
	}
	
	public static void main(String[] args) {


	}
}
