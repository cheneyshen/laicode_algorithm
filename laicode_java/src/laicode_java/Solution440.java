package laicode_java;

import java.util.*;

//Binary Tree Path Sum To Target I
//Given a binary tree and a target sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given target.
//
//Example:
//Given the below binary tree and target = 16,
//
//              5
//             / \
//            4   8
//           /   / \
//          1    3  4
//         /  \      \
//        7    2      1
//return true, as there exist a root-to-leaf path 5-8-3 which sum is 16.
public class Solution440 {
	public boolean hasPathSum(TreeNode root, int sum) {
		if(root==null) {
			return false;
		}
		if(root.left == null && root.right == null && sum-root.key==0) {
			return true;
		}
		return hasPathSum(root.left, sum-root.key) || hasPathSum(root.right, sum-root.key);
	}
	
	public static void main(String[] args) {


	}
}
