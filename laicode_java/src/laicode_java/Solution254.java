package laicode_java;

import java.util.*;

//Binary Tree Level Order Traversal II
//Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
//
//Example:
//Given the below binary tree
//      5
//  /        \
//  3          8
///    \           \
//
//1       4         11
//return its bottom-up level order traversal as:
//
//[
//[1, 4, 11],
//[3, 8],
//[5]
//]
public class Solution254 {

	static class TreeNode {
	 	int val;
	 	TreeNode left;
	 	TreeNode right;
	 	TreeNode(int x) { val = x; }
	}
	 
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		dfsHelper(root, 0, result);
		return result;
	}
	
	private void dfsHelper(TreeNode root, int level, List<List<Integer>> result) {
		if(root==null) {
			return; // The level does not exist in output
		}
		if(level == result.size()) {
			result.add(new ArrayList<Integer>());// Create a new level
		}
		result.get(level).add(root.val); // Add the current value to its level
		dfsHelper(root.left, level+1, result); // Go to the next level
		dfsHelper(root.right, level+1, result);
	}
	
	public static void main(String[] args) {


	}
}
