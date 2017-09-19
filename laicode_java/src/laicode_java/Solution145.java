package laicode_java;

import java.util.*;

//    Find all binary search trees
//Description: Given a number n, generate all possible BST from 1…n.
//
//Input:   3
//
//Output:
//
//    1                 3       2              3      1
//
//    \              /         /   \          /           \
//
//    3        2       1        3    1               2
//
//    /         /                              \                \
//
//    2        1                                  2               3
public class Solution145 {
	static class TreeNode {
		public int key;
		public TreeNode left;
		public TreeNode right;
		public TreeNode(int key) {
			this.key = key;
		}
	}
	public List<TreeNode> generateBSTs(int n) {
		List<TreeNode> result = null;
		if(n<1) {
			return result;
		}
		else if(n==1) {
			TreeNode t1 = new TreeNode(1);
			result.add(t1);
			return result;
		}
		result = buildBST(1, n);
		return result;
	}
	
	private List<TreeNode> buildBST(int left, int right) {
		if(left>right) {
			return null;
		}
		List<TreeNode> result=new ArrayList<TreeNode>();
		if(left==right) {
			result.add(new TreeNode(left));
			return result;
		}
		for(int i=left; i<=right; i++) {
			List<TreeNode> lefts = buildBST(left, i-1);
			List<TreeNode> rights = buildBST(i+1, right);
			for(TreeNode lefti : lefts) {
				for(TreeNode rightj : rights) {
					TreeNode tt = new TreeNode(i);
					tt.left = lefti;
					tt.right = rightj;
					result.add(tt);
				}
			}
		}
		return result;
	}
	
	public static void main(String[] args) {


	}
}
