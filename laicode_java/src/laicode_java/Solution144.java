package laicode_java;

import java.util.*;

//    Recover Binary Search Tree
//    Given a Binary Search Tree with only two nodes swapped. Try to find them and recover the binary search tree.
//
//Input:
//
//    4
//
//    / \
//
//    2   6
//
//    / \   / \
//
//    1  5 3  7
//
//Output:       4
//
//    / \
//
//    2   6
//
//    /  \   / \
//
//    1  3   5  7
public class Solution144 {

	static class TreeNode {
		public int key;
		public TreeNode left;
		public TreeNode right;
		public TreeNode(int key) {
			this.key = key;
		}
	}
		
	public TreeNode recover(TreeNode root) {
		if(root==null || (root.left==null && root.right==null)) {
			return root;
		}
		TreeNode[] list = new TreeNode[3];
//		private TreeNode node1 = null;
//		private TreeNode node2 = null;
//		private TreeNode prev = null;
		helper(root, list, Integer.MIN_VALUE, Integer.MAX_VALUE);
		if (list[0]!=null && list[1]!=null) {
			int temp=list[0].key;
			list[0].key = list[1].key;
			list[1].key = temp;
		}
		return root;
	}
	
	private void helper(TreeNode root, TreeNode[] list, int left, int right) {
		if(root==null) {
			return;
		}
		helper(root.left, list, left, root.key);
		if(list[2]!=null && list[2].key > root.key) {
			if(list[0]==null) {
				list[0]=list[2];
			}
			list[1]=root;
		}
		list[2] = root;
		helper(root.right, list, root.key, right);
	}
	
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);
		TreeNode t6 = new TreeNode(6);
		TreeNode t7 = new TreeNode(7);
		t4.left=t2;
		t4.right=t6;
		t2.left=t1;
		t2.right=t5;
		t6.left=t3;
		t6.right=t7;
		Solution144 ss = new Solution144();
		t4 = ss.recover(t4);
		System.out.println(t4.left.right.key);
	}
}
