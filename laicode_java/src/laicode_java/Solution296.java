package laicode_java;

import java.util.*;

/*Right View Of Binary Tree
	Given a Binary Tree, return the right view of it.Right view of a Binary Tree is list of nodes visible when tree is visited from Right side, the order of the nodes in the list should be from top to bottom level of the original tree.
	Examples:
		1
	   / \
	 2     3
	/ \    / \
	4   5   6  7
	/       \
	9        8
	/ \
	10  11
	the right view = [1, 3, 7, 8, 11]*/
public class Solution296 {
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int val) {
			this.val = val;
			this.left = null;
			this.right = null;
		}
	}
	
	public void rightView(TreeNode root) {
		int[] max = new int[1];
		List<Integer> result = new ArrayList<>();
		helper(root, 1, max, result);
		System.out.println(result);
	}
	
	private void helper(TreeNode root, int level, int[] maxLevel, List<Integer> result) {
		if (root==null)	return;
		if (maxLevel[0]<level) {
			result.add(root.val);
			maxLevel[0] = level;
		}
		helper(root.right, level+1, maxLevel, result);
		helper(root.left, level+1, maxLevel, result);
	}
	
	public static void main(String[] args) {
		TreeNode a = new TreeNode(1);
		TreeNode b = new TreeNode(2);
		TreeNode c = new TreeNode(3);
		TreeNode d = new TreeNode(4);
		TreeNode e = new TreeNode(5);
		TreeNode f = new TreeNode(6);
		TreeNode g = new TreeNode(7);
		TreeNode h = new TreeNode(8);
		a.left = b;
		a.right = c;
		b.left = d;
		b.right = e;
		c.left = f;
		c.right = g;
		d.left = h;
		Solution296 ss = new Solution296();
		ss.rightView(a);
	}
}
