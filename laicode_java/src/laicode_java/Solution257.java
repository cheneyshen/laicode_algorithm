package laicode_java;

import java.util.*;

//Minimum Depth of Binary Tree
//Given a binary tree, find its minimum depth. The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
//
//Example:
//Given the below binary tree
//5
///       \
//3         8
//\
//4
//minimum depth is 2,path is 5→8.
public class Solution257 {
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
	public int minDepth(TreeNode root) {
		if(root==null) {
			return 0;
		}
		int left=minDepth(root.left);
		int right=minDepth(root.right);
		if (left==0 || right==0) {
			//have to work through the valid tree
			return Math.max(left, right)+1;
		} else {
			return Math.min(left, right)+1;
		}
	}
	
	public List<String> binaryTreePaths(TreeNode root) {
		List<String> result = new ArrayList<>();
		if(root==null) {
			return result;
		}
		binaryTreePaths(root, String.valueOf(root.val), result);
		return result;
	}
	
	void binaryTreePaths(TreeNode root, String path, List<String> result) {
		if(root.left == null && root.right == null) {
			result.add(path);
			return;
		}
		if(root.left!=null) {
			binaryTreePaths(root.left, path + "->" + String.valueOf(root.left.val), result);
		}
		if(root.right!=null) {
			binaryTreePaths(root.right, path + "->" + String.valueOf(root.right.val), result);
		}
	}
	public static void main(String[] args) {


	}
}
