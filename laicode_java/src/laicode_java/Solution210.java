package laicode_java;

import java.util.*;

//Reconstruct Binary Search Tree With Preorder Traversal
//Given the preorder traversal sequence of a binary search tree, reconstruct the original tree
public class Solution210 {
	static class TreeNode {
		public int key;
		public TreeNode left;
		public TreeNode right;
		public TreeNode(int key) {
			this.key = key;
			this.left = null;
			this.right = null;
		}
	}
	
	public TreeNode reconstruct(int[] pre) {
		return helper(pre, 0, pre.length-1);
	}
	
	private TreeNode helper(int[] pre, int left, int right) {
		if(left>right) {
			return null;
		}
		else if(left==right) {
			TreeNode root = new TreeNode(pre[left]);
			return root;
		}
		TreeNode root= new TreeNode(pre[left]);
		int i=left;
		for(i=left+1; i<=right; i++) {
			if(pre[i]>pre[left]) {
				break;
			}
		}
		root.left = helper(pre, left+1, i-1);
		root.right = helper(pre, i, right);
		return root;
	}
	
	public static void main(String[] args) {


	}
}
