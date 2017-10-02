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
	
	public TreeNode recontruct(List<Integer> preorder, List<Integer> inorder) {
		if(preorder==null || inorder==null) {
			return null;
		}
		if(preorder.size() != inorder.size()) {
			return null;
		}
		if(preorder.size()==1 || inorder.size()==1) {
			return new TreeNode(preorder.get(0));
		}
		int pi=0, pj=preorder.size()-1;
		int ii=0, ij=inorder.size()-1;
		TreeNode root = new TreeNode(preorder.get(pi));
		List<Integer> leftp = new ArrayList<>();
		List<Integer> rightp = new ArrayList<>();
		List<Integer> lefti = new ArrayList<>();
		List<Integer> righti = new ArrayList<>();
		for(int i=0; i<=ij; i++) {
			if(preorder.get(i) < preorder.get(pi)) {
				leftp.add(preorder.get(i));
			}
			else if(preorder.get(i) > preorder.get(pi)) {
				rightp.add(preorder.get(i));
			}
			if(inorder.get(i) < preorder.get(pi)) {
				lefti.add(inorder.get(i));
			}
			else if(inorder.get(i) > preorder.get(pi)) {
				righti.add(inorder.get(i));
			}
		}
		root.left = recontruct(leftp, lefti);
		root.right = recontruct(rightp, righti);
		return root;
	}
	
	public static void main(String[] args) {
		Solution213 ss = new Solution213();
		List<Integer> a = new ArrayList<Integer>();
		a.add(5);a.add(3);a.add(2);a.add(4);a.add(6);
		List<Integer> b = new ArrayList<Integer>();
		b.add(2);b.add(3);b.add(4);b.add(5);b.add(6);
		TreeNode result = ss.recontruct(a, b);
		System.out.println(result.left.left.key);
	}

}
