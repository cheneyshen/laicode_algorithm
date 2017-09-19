package laicode_java;

import java.util.*;
//    Binary Tree Diameter
//    Given a binary tree in which each node contains an integer number. The diameter is defined as the longest distance from one leaf node to another leaf node. The distance is the number of nodes on the path.
//
//    If there does not exist any such paths, return 0.
//
//    Examples
//
//    5
//
//    /    \
//
//    2      11
//
//          /    \
//
//          6     14
//
//    The diameter of this tree is 4 (2 鈫� 5 鈫� 11 鈫� 14)
//                      1
//                   2     6
//                3     4
//              7  8   5
//                9   10      7(9 8 3 2 4 5 10)
//    1
//       2
//     3   4   (3 2 4)
public class Solution142 {

	static class TreeNode {
		public int key;
		public TreeNode left;
		public TreeNode right;
		public TreeNode(int key) {
			this.key = key;
		}
	}
	
	public int diameter(TreeNode root) {
		int[] result = new int[]{0};
		height(root, result);
		return result[0];
	}
	
	private int height(TreeNode root, int[] result) {
		if(root==null) {
			return -1;
		}
		int leftHeight = height(root.left, result);
		int rightHeight = height(root.right, result);
		int height = Math.max(leftHeight, rightHeight) + 1;
		result[0] = Math.max(result[0], leftHeight + rightHeight + 1);
		return height;
	}
	
	public static void main(String[] args) {
		

	}
}
