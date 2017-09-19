package laicode_java;

import java.util.*;

import laicode_java.Solution140.TreeNode;
//    Binary Tree Path Sum To Target III
//    Given a binary tree in which each node contains an integer number. Determine if there exists a path (the path can only be from one node to itself or to any of its descendants), the sum of the numbers on the path is the given target number.
//
//        Examples
//
//        5
//
//        /    \
//
//        2      11
//
//        /    \
//
//        6     14
//
//        /
//
//        3
//
//        If target = 17, There exists a path 11 + 6, the sum of the path is target.
//
//        If target = 20, There exists a path 11 + 6 + 3, the sum of the path is target.
//
//        If target = 10, There does not exist any paths sum of which is target.
//
//        If target = 11, There exists a path only containing the node 11.
public class Solution141 {

	static class TreeNode {
		public int key;
		public TreeNode left;
		public TreeNode right;
		public TreeNode(int key) {
			this.key = key;
		}
	}
	
	public boolean exit(TreeNode root, int target) {
		Set<Integer> map = new HashSet<Integer>();
		map.add(0);
		return helper(root, 0, target, map);
	}
	
	private boolean helper(TreeNode root, int pre, int target, Set<Integer> map) {
		if(root==null) {
			return false;
		}
		pre += root.key;
		if(map.contains(pre-target)) {
			return true;
		}
		boolean needRemove = map.add(pre);
		if(root.left!=null && helper(root.left, pre, target, map)) {
			return true;
		}
		if(root.right!=null & helper(root.right, pre, target, map)) {
			return true;
		}
		if(needRemove) {
			map.remove(pre);
		}
		return false;
	}
	
	public static void main(String[] args) {
		Solution141 ss = new Solution141();
		TreeNode t1 = new TreeNode(5);
		TreeNode t2 = new TreeNode(2);
		TreeNode t31 = new TreeNode(11);
		TreeNode t3 = new TreeNode(6);
		TreeNode t4 = new TreeNode(14);
		TreeNode t5 = new TreeNode(3);
		t1.left = t2;
		t1.right = t31;
		t31.left = t3;
		t31.right = t4;
		t3.left = t5;
		System.out.println(ss.exit(t1, 20));
		System.out.println(ss.exit(t1, 10));
		System.out.println(ss.exit(t1, 11));
	}
}
