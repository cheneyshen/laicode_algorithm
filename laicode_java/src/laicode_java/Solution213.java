package laicode_java;

import java.util.*;

//Reconstruct Binary Tree With Preorder And Inorder
//Given the preorder and inorder traversal sequence of a binary tree, reconstruct the original tree.
//
//Assumptions
//
//The given sequences are not null and they have the same length
//There are no duplicate keys in the binary tree
public class Solution213 {
/*
    5
  3    6
2   4
53246
23456
*/
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
	
	public TreeNode recontruct(int[] inorder, int[] preorder) {
		if(inorder==null || inorder.length<1 || preorder==null || preorder.length<1) {
			return null;
		}
		int len = inorder.length;
		Map<Integer, Integer> inmap = getMap(inorder);
		
		return helper(inmap, 0, len-1, preorder, 0, len-1);
	}
	
	private Map<Integer, Integer> getMap(int[] inorder) {
		Map<Integer, Integer> res = new HashMap<>();
		for(int i=0; i<inorder.length; i++) {
			res.put(inorder[i], i);
		}
		return res;
	}
	
	private TreeNode helper(Map<Integer, Integer> inmap, int inleft, int inright, int[] preOrder, int preleft, int preright) {
		if(inleft>inright) {
			return null;
		}
		TreeNode root = new TreeNode(preOrder[preleft]);
		int inmid = inmap.get(preOrder[preleft]);
		root.left = helper(inmap, inleft, inmid-1, preOrder, preleft+1, preleft+inmid-inleft);
		root.right = helper(inmap, inmid+1, inright, preOrder, preright+inmid-inright+1, preright);
		return root;
	}
	public static void main(String[] args) {
		Solution213 ss = new Solution213();
		int[] a = new int[] {5,3,2,4,6};
		int[] b = new int[] {2,3,4,5,6};
		TreeNode result = ss.recontruct(a, b);
		System.out.println(result.left.left.key);
	}

}
