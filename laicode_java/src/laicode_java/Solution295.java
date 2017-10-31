package laicode_java;

import java.util.*;

//Cousins In Binary Tree
//	Given a binary Tree and the two keys, determine whether the two nodes are cousins of each other or not.Two nodes are cousins of each other if they are at the same level and have different parents.
//	Assumptions:
//It is not guranteed the two keys are all in the binary tree.
//	There are no duplicate keys in the binary tree.
//	Examples :
//	     6
//	    / \
//	  3     5
//	 / \   / \
//	7   8 1   3
//	7 and 1, result is true.
//	3 and 5, result is false.
//	7 and 5, result is false.
public class Solution295 {
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int val) {
			this.val = val;
			this.left = null;
			this.right = null;
		}
	}
	
	private int level(TreeNode root, TreeNode ptr, int level) {
		if (root==null) return 0;
		if (root==ptr) return level;
		int l = level(root.left, ptr, level+1);
		if (l!=0) return 1;
		return level(root.right, ptr, level+1);
	}
	
	private boolean isSibling(TreeNode root, TreeNode a, TreeNode b) {
		if (root==null)	return false;
		boolean result = (root.left==a && root.right==b);
		result |= (root.left==b && root.right==a);
		result |= isSibling(root.left, a, b);
		result |= isSibling(root.right, a, b);
		return result;
	}
	
	public int isCousin(TreeNode root, TreeNode a, TreeNode b) {
		if(level(root, a, 1) == level(root, b, 1) && !isSibling(root, a, b)) {
			return 1;
		}
		return 0;
	}
	
	public static void main(String[] args) {


	}
}
