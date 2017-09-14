package laicode_java;

import java.util.*;

//Symmetric Binary Tree
//Check if a given binary tree is symmetric.
//  
//  Examples
//  
//          5
//  
//        /    \
//  
//      3        3
//  
//    /   \    /   \
//  
//  1      4  4      1
//  
//  is symmetric.
//  
//         5
//  
//       /    \
//  
//     3        3
//  
//   /   \    /   \
//  
//  1      4  1      4
//  
//  is not symmetric.
public class Solution048 {
	boolean isSymmetric(TreeNode root) {
		if(root==null) {
			return true;
		}
		return isSymmetric(root.left, root.right);
	}
	
	boolean isSymmetric(TreeNode one, TreeNode two) {
		if(one==null && two==null) {
			return true;
		}
		else if(one==null || two==null) {
			return false;
		}
		else if(one.key!=two.key) {
			return false;
		}
		else {
			return isSymmetric(one.left, two.right) && isSymmetric(one.right, two.left);
		}
	}
	
	public static void main(String[] args) {


	}
}
