package laicode_java;

import java.util.*;

//Minimum Depth of Binary Tree
//Given a binary tree, find its minimum depth. The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
//
//Example:
//Given the below binary tree
//5
///       \
//3         8
//\
//4
//minimum depth is 2,path is 5→8.
public class Solution257 {
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			this.val = x;
			this.left = null;
			this.right = null;
		}
	}
	public int minDepth(TreeNode root) {
		if(root==null) {
			return 0;
		}
		int left=minDepth(root.left);
		int right=minDepth(root.right);
		if (left==0 || right==0) {
			//have to work through the valid tree
			return Math.max(left, right)+1;
		} else {
			return Math.min(left, right)+1;
		}
	}
	
	public static void main(String[] args) {


	}
}
