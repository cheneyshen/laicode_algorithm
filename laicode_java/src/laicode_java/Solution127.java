package laicode_java;

import java.util.*;

import laicode_java.Solution126.TreeNode;

//    Lowest Common Ancestor II
//    Given two nodes in a binary tree (with parent pointer available), find their lowest common ancestor.
//
//    Assumptions
//
//    There is parent pointer for the nodes in the binary tree
//
//        The given two nodes are not guaranteed to be in the binary tree
//
//        Examples
//
//        5
//
//        /   \
//
//        9     12
//
//        /  \      \
//
//        2    3      14
//
//        The lowest common ancestor of 2 and 14 is 5
//
//        The lowest common ancestor of 2 and 9 is 9
//
//        The lowest common ancestor of 2 and 8 is null (8 is not in the tree)
public class Solution127 {
	class TreeNode {
		public int key;
		public TreeNode left;
		public TreeNode right;
		public TreeNode parent;
		public TreeNode(int key) {
			this.key=key;
		}
	}
	public int getHeight(TreeNode one) {
		int result=0;
		while(one!=null) {
			result++;
			one=one.parent;
		}
		return result;
	}
	
	public TreeNode solve(TreeNode one, TreeNode two) {
		int height1 = getHeight(one);
		int height2 = getHeight(two);
		if(height1>height2) {
			int diff=height1-height2;
			while(diff>0) {
				one=one.parent;
				diff--;
			}
		}
		else if(height2>height1) {
			int diff=height2-height1;
			while(diff>0) {
				two=two.parent;
				diff--;
			}
		}
		while(one!=null && two!=null && one!=two) {
			one=one.parent;
			two=two.parent;
		}
		return one;
	}
	
	public static void main(String[] args) {


	}
}
