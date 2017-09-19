package laicode_java;

import java.util.*;

import laicode_java.Solution135.TreeNode;

//    Largest Number Smaller In Binary Search Tree
//    In a binary search tree, find the node containing the largest number smaller than the given target number.
//
//    If there is no such number, return INT_MIN.
//
//Assumptions:
//
//    The given root is not null.
//    There are no duplicate keys in the binary search tree.
//    Examples
//
//    5
//
//    /    \
//
//    2      11
//
//    /    \
//
//    6     14
//
//    largest number smaller than 1 is Integer.MIN_VALUE(Java) or INT_MIN(c++)
//
//    largest number smaller than 10 is 6
//
//    largest number smaller than 6 is 5
public class Solution136 {
	static class TreeNode {
		public int key;
		public TreeNode left;
		public TreeNode right;
		public TreeNode(int key) {
			this.key = key;
		}
	}
	
	public int largestSmaller(TreeNode root, int target) {
		int result=Integer.MIN_VALUE;
		while(root!=null) {
			if(root.key>=target) {
				root = root.left;
			}
			else {
				result=root.key;
				root = root.right;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {


	}
}
