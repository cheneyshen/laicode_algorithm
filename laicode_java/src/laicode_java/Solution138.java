package laicode_java;

import java.util.*;

//    Maximum Path Sum Binary Tree I
//    Given a binary tree in which each node contains an integer number. Find the maximum possible sum from one leaf node to another leaf node. If there is no such path available, return Integer.MIN_VALUE(Java)/INT_MIN (C++).
//
//    Examples
//
//    -15
//
//    /    \
//
//    2      11
//
//         /    \
//
//         6     14
//
//    The maximum path sum is 6 + 11 + 14 = 31.

public class Solution138 {
	static class TreeNode {
		public int key;
		public TreeNode left;
		public TreeNode right;
		public TreeNode(int key) {
			this.key = key;
		}
	}
	
	public int maxPathSum(TreeNode root) {
		if(root==null) {
			return 0;
		}
		int[] max = new int[]{Integer.MIN_VALUE};
		helper(root, max);
		return max[0];
	}
	
	private int helper(TreeNode root, int[] sum) {
		if(root==null) {
			return 0;	
		}
		int leftsum = helper(root.left, sum);
		int rightsum = helper(root.right, sum);
		if(root.left!=null && root.right!=null) {
			sum[0] = Math.max(sum[0], leftsum+rightsum+root.key);
			return Math.max(leftsum, rightsum)+root.key;
		}
		return root.left==null ? rightsum+root.key : leftsum+root.key;
	}
	
	public static void main(String[] args) {
		Solution138 ss = new Solution138();
		TreeNode t1 = new TreeNode(-15);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(11);
		TreeNode t4 = new TreeNode(6);
		TreeNode t5 = new TreeNode(14);
		t1.left = t2;
		t1.right = t3;
		t3.left = t4;
		t3.right = t5;
		System.out.println(ss.maxPathSum(t1));
	}
}
