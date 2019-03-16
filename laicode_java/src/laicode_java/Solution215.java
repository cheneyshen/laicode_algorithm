package laicode_java;

import java.util.*;

//Reconstruct Binary Tree With Levelorder And Inorder
//Given the levelorder and inorder traversal sequence of a binary tree, reconstruct the original tree.
//
//Assumptions
//
//The given sequences are not null and they have the same length
//There are no duplicate keys in the binary tree
public class Solution215 {
/*
       5
     3    6
   2   4
   53624  5 324 6
   23456  234 5 6
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
	
	public TreeNode recontruct(List<Integer> levelorder, List<Integer> inorder) {
		Map<Integer, Integer> inmap = new HashMap<>();
		for(int i=0; i<inorder.size(); i++) {
			inmap.put(inorder.get(i), i);
		}
		return helper(levelorder, inmap);
	}
	
	private TreeNode helper(List<Integer> level, Map<Integer, Integer> inmap) {
		if(level.isEmpty()) {
			return null;
		}
		TreeNode root = new TreeNode(level.remove(0));
		List<Integer> left = new ArrayList<>();
		List<Integer> right = new ArrayList<>();
		for(int num:level) {
			if(inmap.get(num) < inmap.get(root.key)) {
				left.add(num);
			} else {
				right.add(num);
			}
		}
		root.left = helper(left, inmap);
		root.right = helper(right, inmap);
		return root;
	}
	
	public static void main(String[] args) {
		Solution215 ss = new Solution215();
		List<Integer> a = new ArrayList<Integer>();
		a.add(5);a.add(3);a.add(6);a.add(2);a.add(4);
		List<Integer> b = new ArrayList<Integer>();
		b.add(2);b.add(3);b.add(4);b.add(5);b.add(6);
		TreeNode result = ss.recontruct(a, b);
		System.out.println(result.left.left.key);
	}
}
