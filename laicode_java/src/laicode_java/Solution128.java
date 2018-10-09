package laicode_java;

import java.util.*;

//    Lowest Common Ancestor III
//    Given two nodes in a binary tree, find their lowest common ancestor (the given two nodes are not guaranteed to be in the binary tree).
//
//    Return null If any of the nodes is not in the tree.
//
//    Assumptions
//
//    There is no parent pointer for the nodes in the binary tree
//
//        The given two nodes are not guaranteed to be in the binary tree
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
//
//        The lowest common ancestor of 2 and 8 is null (8 is not in the tree)
public class Solution128 {
	class TreeNode {
		public int key;
		public TreeNode left;
		public TreeNode right;
		public TreeNode(int key) {
			this.key=key;
		}
	}
	
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode one, TreeNode two) {
		if(findNode(root, one)==false || findNode(root, two)==false) {
			return null;
		}
		return LCAHelper(root, one, two);
	}
	
	private boolean findNode(TreeNode root, TreeNode two) {
		if(root==null || two==null) {
			return false;
		}
		else if(two==root) {
			return true;
		}
		return findNode(root.left, two) || findNode(root.right, two);
	}
	
	public TreeNode LCAHelper(TreeNode root, TreeNode one, TreeNode two) {
		if(root==null || root==one || root==two) {
			return root;
		}
		TreeNode left=LCAHelper(root.left, one, two);
		TreeNode right=LCAHelper(root.right, one, two);
		if(left!=null && right!=null) {
			return root;
		}
		return left==null ? right : left;
	}
	
	public static void main(String[] args) {


	}
}
