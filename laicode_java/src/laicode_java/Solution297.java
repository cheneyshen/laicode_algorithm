package laicode_java;

import java.util.*;

/*Top View Of Binary Tree
	Given a binary tree, get the top view of it.The nodes in the output list should be from left to right.A node x belongs to the output if x is the topmost node at its column.
	Examples:
	1
	/ \
	2     3
	/ \ / \
	4  (5, 6)  7
	the top view is[4, 2, 1, 3, 7]*/
public class Solution297 {
	static class TreeNode {
		int val;
		TreeNode left, right;
		TreeNode(int val) {
			this.val = val;
			this.left = null;
			this.right = null;
		}
	}
	
	static class QNode {
		TreeNode node;
		int hd;
		QNode(TreeNode n, int h) {
			node = n;
			hd = h;
		}
	}
	
	public void printTopView(TreeNode root) {
		if (root==null) {	return;	}
		HashSet<Integer> set = new HashSet<>();
		Queue<QNode> q = new LinkedList<QNode>();
		q.add(new QNode(root, 0));
		while(!q.isEmpty()) {
			QNode qi = q.remove();
			int hd = qi.hd;
			TreeNode n = qi.node;
			if (!set.contains(hd)) {
				set.add(hd);
				System.out.println(n.val + " ");
			}
			if (n.left != null) {
				q.add(new QNode(n.left, hd-1));
			}
			if (n.right != null) {
				q.add(new QNode(n.right, hd+1));
			}
		}
	}
	
	public static void main(String[] args) {


	}
}
