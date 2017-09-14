package laicode_java;

import java.util.*;
//    Delete In Binary Search Tree
//    Delete the target key K in the given binary search tree if the binary search tree contains K. Return the root of the binary search tree.
//        
//    Find your own way to delete the node from the binary search tree, after deletion the binary search tree's property should be maintained.
//        
//    Assumptions
//        
//    There are no duplicate keys in the binary search tree

public class Solution053 {
	TreeNode solve(TreeNode root, int value) {
		if (root == null) {
			return root;
		}
		if (root.key>value) {
			//删除后，总会改变树的结构，不管改变的左子树还是右子树，返回新子树的根之后从新连接
			root.left = solve(root.left, value);
		}
		else if (root.key<value) {
			//删除后，总会改变树的结构，不管改变的左子树还是右子树，返回新子树的根之后从新连接
			root.right = solve(root.right, value);
		}
		else {
			if (root.left == null && root.right == null) {
				//不需要改
				return null;
			}
			else if (root.left == null || root.right == null) {
				//只返回另一个子树
				return root.left == null ? root.right : root.left;
			}
			else {
				//find the node with smallest value in the right subtree
				//copy its value to root
				//recurse delete the smallest node from right of this root
				TreeNode closet = root.right;
				while (closet.left != null) {
					closet = closet.left;
				}
				root.key = closet.key;
				root.right = solve(root.right, closet.key);
			}
		}
		return root;
	}
	
	public static void main(String[] args) {


	}
}
