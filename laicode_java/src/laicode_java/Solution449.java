package laicode_java;

import java.util.*;

//Invert Binary Tree
//Invert a binary tree.
//
//     4
//   /   \
//  2     7
// / \   / \
//1   3 6   9
//to
//     4
//   /   \
//  7     2
// / \   / \
//9   6 3   1
public class Solution449 {
	public TreeNode invertTree(TreeNode root) {
		if(root==null) {
			return null;
		}
		final TreeNode left = root.left, right = root.right;
		root.left = invertTree(right);
		root.right = invertTree(left);
		return root;
	}
	
	public static void main(String[] args) {


	}
}
