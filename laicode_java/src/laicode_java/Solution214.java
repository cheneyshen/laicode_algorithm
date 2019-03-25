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
		int pj=postorder.size()-1;
		int ij=inorder.size()-1;
		if(pj != ij) {
			return null;
		}
		if(pj==1 || ij==1) {
			return new TreeNode(postorder.get(0));
		}
		TreeNode root = new TreeNode(postorder.get(pj));
		List<Integer> leftp = new ArrayList<>();
		List<Integer> rightp = new ArrayList<>();
		List<Integer> lefti = new ArrayList<>();
		List<Integer> righti = new ArrayList<>();
		//遍历中序，先序数组，根据数字大小拆分
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
		//递归调用
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
