package laicode_java;

import java.util.*;

//    Closest Number In Binary Search Tree
//    In a binary search tree, find the node containing the closest number to the given target number.
//
//Assumptions:
//
//    The given root is not null.
//    There are no duplicate keys in the binary search tree.
//Examples:
//
//    5
//
//    /    \
//
//    2      11
//
//    /    \
//
//    6     14
//
//    closest number to 4 is 5
//
//    closest number to 10 is 11
//
//    closest number to 6 is 6
public class Solution135 {
	static class TreeNode {
		public int key;
		public TreeNode left;
		public TreeNode right;
		public TreeNode(int key) {
			this.key = key;
		}
	}
	
	public int closest(TreeNode root, int target) {
		int result = root.key;
		while(root!=null) {
			if(root.key == target) {
				return target;
			}
			else if (root.key < target) {
				root = root.right;
			}
			else {
				root = root.left;
			}
			if (root!=null && (Math.abs(root.key - target) < Math.abs(result - target))) {
				result = root.key;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		Solution135 ss = new Solution135();
		TreeNode t5 = new TreeNode(5);
		TreeNode t2 = new TreeNode(2);
		TreeNode t11 = new TreeNode(11);
		TreeNode t6 = new TreeNode(6);
		TreeNode t14 = new TreeNode(14);
		t5.left = t2;
		t5.right = t11;
		t11.left = t6;
		t11.right = t14;
		int result = ss.closest(t5, 10);
		System.out.println(result);
		result = ss.closest(t5, 6);
		System.out.println(result);
		result = ss.closest(t5, 4);
		System.out.println(result);
	}
}
