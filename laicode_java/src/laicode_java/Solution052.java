package laicode;

import java.util.*;

//    Search In Binary Search Tree
//    Find the target key K in the given binary search tree, return the node that contains the key if K is found, otherwise return null.
//        
//    Assumptions
//        
//    There are no duplicate keys in the binary search tree
//
public class Solution052 {

	TreeNode solve(TreeNode root, int value) {
		if (root == null) {
			return null;
		}
		TreeNode temp = root;
		while (temp != null) {
			if (temp.key == value) {
				return temp;
			}
			else if (temp.key>value) {
				temp = temp.left;
			}
			else {
				temp = temp.right;
			}
		}
		return null;
	}
	
	public static void main(String[] args) {


	}
}
