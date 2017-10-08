package laicode_java;

import java.util.*;

//Sorted Array To Binary Search Tree
//Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
//
//Example:
//Given ascending order array: [1, 3, 4, 5, 8, 11]
//
//return Binary Search Tree is
//
//4
//
///        \
//
//1          8
//
//\      /     \
//
//3     5    11
public class Solution255 {
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			this.val = x;
			this.left = null;
			this.right = null;
		}
	}
	public TreeNode sortedArrayToBST(int[] nums) {
		if(nums==null) {
			return null;
		}
		int length = nums.length;
		return getBST(nums, 0, length-1);
	}
	
	private TreeNode getBST(int[] nums, int l, int r) {
		if(l>r) {
			return null;
		}
		int m = (l+r)/2;
		TreeNode root = new TreeNode(nums[m]);
		root.left = getBST(nums, l, m-1);
		root.right = getBST(nums, m+1, r);
		return root;
	}
	
	public static void main(String[] args) {


	}
}
