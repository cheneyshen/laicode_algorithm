package laicode_java;

import java.util.*;

//    Lowest Common Ancestor I
//    Given two nodes in a binary tree, find their lowest common ancestor.
//
//    Assumptions
//
//    There is no parent pointer for the nodes in the binary tree
//
//        The given two nodes are guaranteed to be in the binary tree
//
//        Examples
//
//        5
//
//        /   \
//
//        9     12
//
//        /  \      \
//
//        2    3      14
//
//        The lowest common ancestor of 2 and 14 is 5
//
//        The lowest common ancestor of 2 and 9 is 9

public class Solution126 {
	class TreeNode {
		public int key;
		public TreeNode left;
		public TreeNode right;
		public TreeNode(int key) {
			this.key=key;
		}
	}
	
	public TreeNode solve(TreeNode root, TreeNode one, TreeNode two) {
		if(root==null || root==one || root==two) {
			return root;
		}
		TreeNode left=solve(root.left, one, two);
		TreeNode right=solve(root.right, one, two);
		if(left!=null && right!=null) {
			return root;
		}
		return left==null ? right : null;
	}
	
	public static void main(String[] args) {


	}
}
