package laicode_java;

import java.util.*;

//Reconstruct Binary Tree With Postorder And Inorder
//Given the postorder and inorder traversal sequence of a binary tree, reconstruct the original tree.
//
//Assumptions
//
//The given sequences are not null and they have the same length
//There are no duplicate keys in the binary tree
public class Solution214 {
/*
       5
     3    6
   2   4
   24365
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
	
	public TreeNode recontruct(List<Integer> postorder, List<Integer> inorder) {
		if(postorder==null || inorder==null) {
			return null;
		}
		if(postorder.size() != inorder.size()) {
			return null;
		}
		if(postorder.size()==1 || inorder.size()==1) {
			return new TreeNode(postorder.get(0));
		}
		int pi=0, pj=postorder.size()-1;
		int ii=0, ij=inorder.size()-1;
		TreeNode root = new TreeNode(postorder.get(pj));
		List<Integer> leftp = new ArrayList<>();
		List<Integer> rightp = new ArrayList<>();
		List<Integer> lefti = new ArrayList<>();
		List<Integer> righti = new ArrayList<>();
		for(int i=0; i<=ij; i++) {
			if(postorder.get(i) < postorder.get(pj)) {
				leftp.add(postorder.get(i));
			}
			else if(postorder.get(i) > postorder.get(pj)) {
				rightp.add(postorder.get(i));
			}
			if(inorder.get(i) < postorder.get(pj)) {
				lefti.add(inorder.get(i));
			}
			else if(inorder.get(i) > postorder.get(pj)) {
				righti.add(inorder.get(i));
			}
		}
		root.left = recontruct(leftp, lefti);
		root.right = recontruct(rightp, righti);
		return root;
	}
	
	public static void main(String[] args) {
		Solution214 ss = new Solution214();
		List<Integer> a = new ArrayList<Integer>();
		a.add(2);a.add(4);a.add(3);a.add(6);a.add(5);
		List<Integer> b = new ArrayList<Integer>();
		b.add(2);b.add(3);b.add(4);b.add(5);b.add(6);
		TreeNode result = ss.recontruct(a, b);
		System.out.println(result.left.left.key);
	}
}
