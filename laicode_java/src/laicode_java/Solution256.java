package laicode_java;

import java.util.*;

//Sorted List to Binary Search Tree
//Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
//
//Example:
//Given ascending order list: 1→3→4→5→8→11
//
//return Binary Search Tree is
//
//4
//
///        \
//
//1          8
//
//\      /     \
//
//3    5     11
public class Solution256 {
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			this.val = x;
			this.left = null;
			this.right = null;
		}
	}
	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			this.val = x;
			this.next = null;
		}
	}
	public TreeNode sortedListToBST(ListNode head) {
		if(head==null) {
			return null;
		}
		if(head.next==null) {
			return new TreeNode(head.val);
		}
		ListNode fast = head.next.next;
		if(fast==null) {
			TreeNode root = new TreeNode(head.next.val);
			root.left = new TreeNode(head.val);
			root.right = null;
			return root;
		}
		ListNode slow = head;
		while(fast!=null && fast.next!=null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		TreeNode root = new TreeNode(slow.next.val);
		//right part
		root.right = sortedListToBST(slow.next);
		//cut off
		slow.next = null;
		//left part
		root.left = sortedListToBST(head);
		return root;
	}
	
	public static void main(String[] args) {


	}
}
