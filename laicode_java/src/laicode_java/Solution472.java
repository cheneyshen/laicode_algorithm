package laicode_java;

import java.util.*;

//House Robber III
//The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root." 
//Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that "all houses in this place forms a binary tree". 
//It will automatically contact the police if two directly-linked houses were broken into on the same night.
//
//Determine the maximum amount of money the thief can rob tonight without alerting the police.
//
//Example 1:
//
//     3
//    / \
//   2   3
//    \   \ 
//     3   1
//Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
//
//Example 2:
//
//     3
//    / \
//   4   5
//  / \   \ 
// 1   3   1
//Maximum amount of money the thief can rob = 4 + 5 = 9.
//

public class Solution472 {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	 
	public int rob(TreeNode root) {
		int[] res = robHelper(root);
		return Math.max(res[0], res[1]);
	}
	
	private int[] robHelper(TreeNode root) {
		if(root==null) {
			return new int[2];
		}
		int[] left = robHelper(root.left);
		int[] right = robHelper(root.right);
		int[] res = new int[2];
		res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
		res[1] = root.val + left[0] + right[0];
		return res;
	}
	
	public static void main(String[] args) {


	}
}
