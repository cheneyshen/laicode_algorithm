package laicode_java;

import java.util.*;

//Distance Of Two Nodes In Binary Tree
//	Find distance between two given keys of a Binary Tree, no parent pointers are given.Distance between two nodes is the minimum number of edges to be traversed to reach one node from other.
//	Assumptions:
//There are no duplicate keys in the binary tree.
//	The given two keys are guaranteed to be in the binary tree.
//	Examples :
//	1
//	/ \
//	2    3
//	/ \ / \
//	4   5 6   7
//	\
//	8
//	distance(4, 5) = 2
//	distance(4, 6) = 4
public class Solution299 {
	static int d1=-1;
	static int d2=-1;
	static int dist=0;
	static class TreeNode {
		int val;
		TreeNode left, right;
		TreeNode(int val) {
			this.val = val;
			this.left = null;
			this.right = null;
		}
	}
	
	private int findLevel(TreeNode root, int k, int level) {
		if(root==null) {
			return -1;
		}
		if(root.val==k) {
			return level;
		}
		int l = findLevel(root.left, k, level+1);
		return (l!=-1) ? l : findLevel(root.right, k, level+1);
	}
	
	private TreeNode findDistHelper(TreeNode root, int n1, int n2) {
		if (root == null || root.val ==  n1 || root.val == n2) {
			return root;
		}
		TreeNode left_lca = findDistHelper(root.left, n1, n2);
		TreeNode right_lca = findDistHelper(root.right, n1, n2);
		if (left_lca !=null && right_lca !=null) {
			return root;
		}
		return (left_lca!=null) ? left_lca : right_lca; 
	}
	
	public int findDistance(TreeNode root, int n1, int n2) {
		TreeNode lca = findDistHelper(root, n1, n2);
		
		int d1 = findLevel(lca, n2, 0);
		int d2 = findLevel(lca, n1, 0);
		
		return d1+d2;
	}
	
	public static void main(String[] args) {


	}
}
