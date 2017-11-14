package laicode_java;

import java.util.*;

//Count Univalue Subtrees
//Given a binary tree, count the number of uni-value subtrees.
//
//A Uni-value subtree means all nodes of the subtree have the same value.
//
//For example:
//Given binary tree,
//
//              5
//             / \
//            1   5
//           / \   \
//          5   5   5
//return 4.
//

public class Solution481 {
	class TreeNode {
		int data;
		TreeNode left, right;
		TreeNode(int item) {
			data = item;
			left=right=null;
		}
	}
	
	private boolean b = true;
	
	private int result = 0;
	
	public int countUnivalSubtrees(TreeNode root) {
		return isUnival(root, b);
		
	}
	public int countUnival(TreeNode root) {
		univalHelper(root, -1, result);
		return result;
	}
	
	private boolean univalHelper(TreeNode root, int value, int result) {
		if (root==null)
			return true;
		if (!univalHelper(root.left, root.data, result) || !univalHelper(root.right, root.data, result)) {
			return false;
		}
		result++;
		return root.data == value;
	}
	
	private int isUnival(TreeNode root, boolean b) {
		if(root==null)
			return 0;
		boolean l=true, r=true;
		int res = isUnival(root.left, l) + isUnival(root.right, r);
		b = l && r && (root.left == null ? root.data == root.left.data : true) && (root.right == null ? root.data == root.right.data : true); 
		if (b==true)
			return res + 1;
		else
			return res + 0;
	}
	
	public static void main(String[] args) {


	}
}
