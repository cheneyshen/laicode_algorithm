package laicode_java;

import java.util.*;

//    Maximum Path Sum Binary Tree II
//    Given a binary tree in which each node contains an integer number. Find the maximum possible sum from any node to any node (the start node and the end node can be the same).
//
//    Assumptions
//
//    ​The root of the given binary tree is not null
//    Examples
//
//    -1
//
//    /    \
//
//    2      11
//
//    /    \
//
//    6    -14
//
//    one example of paths could be -14 -> 11 -> -1 -> 2
//
//    another example could be the node 11 itself
//
//    The maximum path sum in the above binary tree is 6 + 11 + (-1) + 2 = 18
public class Solution139 {
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
		helper(root, result);
		return result[0];
	}
	
	private int helper(TreeNode root, int[] result) {
		if(root==null) {
			return 0;
		}
		int lefts = helper(root.left, result);
		int rights = helper(root.right, result);
		lefts = Math.max(lefts, 0);
		rights = Math.max(rights, 0);
		result[0] = Math.max(result[0], lefts + rights + root.key);
		return Math.max(lefts, rights) + root.key;
	}
	
	public static void main(String[] args) {
		Solution139 ss = new Solution139();
		TreeNode t1 = new TreeNode(-1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(11);
		TreeNode t4 = new TreeNode(6);
		TreeNode t5 = new TreeNode(-14);
		t1.left = t2;
		t1.right = t3;
		t3.left = t4;
		t3.right = t5;
		System.out.println(ss.maxPathSum(t1));
	}
}
