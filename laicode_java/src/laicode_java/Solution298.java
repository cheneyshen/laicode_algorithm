package laicode_java;

import java.util.*;

//Vertical List Of Binary Tree
//	Given a binary tree, get the vertically representation of it as a list of lists.
//	The columns should be from left to right, and for each column the nodes should be placed from top to bottom, from left to right.
//	The following example illustrates vertical order traversal.Input:
//		1
//	   / \
//	  2     3
//	 / \    / \
//	4   5, 6   7
//	     \     \
//	      8     9
//	Output:
//[[4],         // left most column
//	[2],         // 2nd left-most column
//	[1, 5, 6], // 3rd left-most column, top->bottom, left->right
//	[3, 8],
//	[7],
//	[9]]
public class Solution298 {

	static class TreeNode {
		int val;
		TreeNode left, right;
		TreeNode(int val) {
			this.val = val;
			this.left = null;
			this.right = null;
		}
	}
	
	class Values {
		int max, min;
	}
	
	public void verticalOrder(TreeNode node) {
		Values val = new Values();
		findMinMax(node, val, val, 0);
		for (int line_no = val.min; line_no<=val.max; line_no++) {
			printVerticalLine(node, line_no, 0);
			System.out.println("");
		}
	}
	
	private void printVerticalLine(TreeNode node, int line_no, int hd) {
		if (node==null)	return;
		if (hd==line_no)
			System.out.println(node.val + " ");
		printVerticalLine(node.left, line_no, hd-1);
		printVerticalLine(node.right, line_no, hd+1);
	}
	
	private void findMinMax(TreeNode node, Values min, Values max, int hd) {
		if (node==null) {
			return;
		}
		if (hd<min.min) {
			min.min = hd;
		}
		if (hd>max.max) {
			max.max = hd;
		}
		findMinMax(node.left, min, max, hd-1);
		findMinMax(node.right, min, max, hd+1);
	}
	
	private int maxLength = 0;
	public int longestConsecutive(TreeNode root) {
		dfs(root, null, 0);
		return maxLength;
	}
	
	private void dfs(TreeNode root, TreeNode prev, int length) {
		if(root==null) {
			return;
		}
		if(prev!=null && prev.val == root.val - 1) {
			length = length+1;
		} else {
			length = 1;
		}
		maxLength = Math.max(maxLength, length);
		dfs(root.left, root, length);
		dfs(root.right, root, length);
	}
	
	public static void main(String[] args) {


	}
}
