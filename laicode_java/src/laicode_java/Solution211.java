package laicode_java;

import java.util.*;

//Reconstruct Binary Search Tree With Postorder Traversal
//Given the postorder traversal sequence of a binary search tree, reconstruct the original tree.
//Assumptions
//The given sequence is not null
//There are no duplicate keys in the binary search tree
public class Solution211 {

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
	
	public TreeNode reconstruct(int[] post) {
		if(post.length==0) {
			return null;
		}
		else if(post.length==1) {
			TreeNode root = new TreeNode(post[0]);
			return root;
		}
		return helper(post, 0, post.length-1);
	}
	
	private TreeNode helper(int[] post, int left, int right) {
		if(left>right) {
			return null;
		}
		TreeNode root = new TreeNode(post[right]);
		int i=left;
		while(i<right && post[i]<post[right]) {
			i++;
		}
		root.left = helper(post, left, i-1);
		root.right = helper(post, i, right-1);
		return root;
	}
	
	public static void main(String[] args) {


	}
}
