package laicode_java;

import java.util.*;

//Levelorder Reconstruct Complete Binary Tree
//	How to re construct a complete binary tree from its level - order traversal sequence only.
//	Assumptions:
//The given level - order is not null.
//	Examples :
//{1, 2, 3} -->
//	1
//	/ \
//	2     3
public class Solution294 {
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int val) {
			this.val = val;
			this.right = null;
			this.left = null;
		}
	}
	
	public TreeNode reconstruct(int[] levelOrder) {
		if (levelOrder == null || levelOrder.length == 0) {
			return null;
		}
		Queue<TreeNode> q = new LinkedList<>();
		TreeNode root = new TreeNode(levelOrder[0]);
		q.offer(root);
		int i=1;
		while (i<levelOrder.length) {
			int size = q.size();
			for (int j=0; j<size; j++) {
				TreeNode cur = q.poll();
				if (i<levelOrder.length) {
					cur.left = new TreeNode(levelOrder[i++]);
					q.offer(cur.left);
				}
				if (i<levelOrder.length) {
					cur.right = new TreeNode(levelOrder[i++]);
					q.offer(cur.right);
				}
			}
		}
		return root;
	}
	
	public static void main(String[] args) {


	}
}
