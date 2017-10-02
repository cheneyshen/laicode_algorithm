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
		if(levelorder==null || inorder==null) {
			return null;
		}
		if(levelorder.size() != inorder.size()) {
			return null;
		}
		if(levelorder.size()==1 || inorder.size()==1) {
			return new TreeNode(levelorder.get(0));
		}
		int li=0, lj=levelorder.size()-1;
		int ii=0, ij=inorder.size()-1;
		TreeNode root = new TreeNode(levelorder.get(li));
		List<Integer> leftl = new ArrayList<>();
		List<Integer> rightl = new ArrayList<>();
		List<Integer> lefti = new ArrayList<>();
		List<Integer> righti = new ArrayList<>();
		for(int i=0; i<=ij; i++) {
			if(levelorder.get(i) < levelorder.get(li)) {
				leftl.add(levelorder.get(i));
			}
			else if(levelorder.get(i) > levelorder.get(li)) {
				rightl.add(levelorder.get(i));
			}
			if(inorder.get(i) < levelorder.get(li)) {
				lefti.add(inorder.get(i));
			}
			else if(inorder.get(i) > levelorder.get(li)) {
				righti.add(inorder.get(i));
			}
		}
		root.left = recontruct(leftl, lefti);
		root.right = recontruct(rightl, righti);
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
