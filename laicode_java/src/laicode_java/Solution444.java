package laicode_java;

import java.util.*;

//Count Complete Tree Nodes
//Given a complete binary tree, count the number of nodes.
//
//Definition of a complete binary tree from Wikipedia:
//In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
//

public class Solution444 {
	public int countNodes(TreeNode root) {
		if(root==null) {
			return 0;
		}
		int l = leftHeight(root.left);
		int r = leftHeight(root.right);
		if(l==r) {
			return countNodes(root.right) + (1<<l);
		}
		return countNodes(root.right) + (1<<r);
	}
	
	private int leftHeight(TreeNode node) {
		int h=0;
		while(node!=null) {
			h++;
			node = node.left;
		}
		return h;
	}
	public static void main(String[] args) {


	}
}
