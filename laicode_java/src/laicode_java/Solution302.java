package laicode_java;

import java.util.*;

//Transform Binary Search Tree To Greater Sum Tree
//Given a BST, change each node’s value, such that its value is equal to the sum of all nodes greater than itself.
//
//Examples:
//  11
// /  \
//2     29
///  \  /  \
//1   7 15  40
//   /
//  35
//is transformed to
//   119
//   /  \
//137    75
///  \    /  \
//139 130 104  0
///
//40
public class Solution302 {
	static class TreeNode {
		int data;
		TreeNode left, right;
		TreeNode(int item) {
			this.data = item;
			this.left = null;
			this.right = null;
		}
	}
	
	TreeNode transformTree(TreeNode root) {
		int[] sum = new int[1];
		helper(root, sum);
		return root;
	}
	
	void helper(TreeNode root, int[] sum) {
		if(root==null) {
			return;
		}
		helper(root.right, sum);
		sum[0] = sum[0] + root.data;
		root.data = sum[0] - root.data;
		helper(root.left, sum);
	}
	
	public static void main(String[] args) {


	}
}
