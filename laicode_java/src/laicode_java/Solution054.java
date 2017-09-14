package laicode_java;

import java.util.*;
//Is Binary Search Tree Or Not
//Determine if a given binary tree is binary search tree.
//  
//Assumptions
//  
//There are no duplicate keys in binary search tree.
//You can assume the keys stored in the binary search tree can not be Integer.MIN_VALUE or Integer.MAX_VALUE.
//Corner Cases
//  
//What if the binary tree is null? Return true in this case.

public class Solution054 {
	boolean isBSTHelper(TreeNode root, int left, int right) {
		if (root == null) {
			return true;
		}
		if (root.key<right && root.key>left) {
			return isBSTHelper(root.left, left, root.key) &&
				isBSTHelper(root.right, root.key, right);
		}
		else {
			return false;
		}
	}
    
	boolean isBST(TreeNode root) {
		if (root == null) {
			return true;
		}
		return isBSTHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	public static void main(String[] args) {


	}
}
