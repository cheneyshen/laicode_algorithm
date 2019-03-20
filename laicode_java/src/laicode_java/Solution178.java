package laicode_java;

import java.util.*;

//Reverse Binary Tree Upside Down
//Given a binary tree where all the right nodes are leaf nodes, flip it upside down and turn it into a tree with left leaf nodes as the root.
//
//Examples
//
//1
///    \
//2        5
///   \
//3      4
//
//is reversed to
//
//3
///    \
//2        4
///   \
//1      5
public class Solution178 {
	static class TreeNode {
		public int key;
		public TreeNode left;
		public TreeNode right;
		public TreeNode(int key) {
			this.key=key;
		}
	}
	
	public TreeNode reverse(TreeNode root) {
		if (root==null || (root.left==null && root.right==null)) {
			return root;
		}
		// subtree will be 3
		TreeNode subtree = reverse(root.left);
		// 2.left = 1
		root.left.left = root;
		// 2.right = 5
		root.left.right = root.right;
		// 1.left = null, 1.right = null
		root.left = null;
		root.right = null;
		return subtree;
	}
	
	public static void main(String[] args) {


	}
}
