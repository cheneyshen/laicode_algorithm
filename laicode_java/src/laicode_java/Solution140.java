package laicode_java;

import java.util.*;

import laicode_java.Solution139.TreeNode;

//    Maximum Path Sum Binary Tree III
//    Given a binary tree in which each node contains an integer number. 
//	  Find the maximum possible subpath sum(both the starting and ending node of the subpath should be on the same path from root to one of the leaf nodes, and the subpath is allowed to contain only one node).
//    Assumptions
//
//    The root of given binary tree is not null
//    Examples
//
//     -5
//
//    /    \
//
//    2      11
//
//    /        \
//
//    6        14
//
//             /
//
//            -3
//
//    The maximum path sum is 11 + 14 = 25
public class Solution140 {

	static class TreeNode {
		public int key;
		public TreeNode left;
		public TreeNode right;
		public TreeNode(int key) {
			this.key = key;
		}
	}
	
	public int maxPathSum(TreeNode root) {
		int[] result = new int[]{Integer.MIN_VALUE};
		helper(root, 0, result);
		return result[0];
	}
	
	private void helper(TreeNode root, int pre, int[] result) {
		if(root==null) {
			return;
		}
		if(pre<=0) {
			pre = root.key;
		}
		else {
			pre += root.key;
		}
		result[0] = Math.max(result[0], pre);
		helper(root.left, pre, result);
		helper(root.right, pre, result);
	}
	
 	public static void main(String[] args) {
 		Solution140 ss = new Solution140();
		TreeNode t1 = new TreeNode(-5);
		TreeNode t2 = new TreeNode(2);
		TreeNode t31 = new TreeNode(11);
		TreeNode t3 = new TreeNode(6);
		TreeNode t4 = new TreeNode(14);
		TreeNode t5 = new TreeNode(-3);
		t1.left = t2;
		t1.right = t31;
		t2.left = t3;
		t31.right = t4;
		t4.left = t5;
		System.out.println(ss.maxPathSum(t1));
	}
}
