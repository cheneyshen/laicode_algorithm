package laicode_java;

import java.util.*;

//    Height of Binary Tree
//    Find the height of binary tree.
//
//Examples:
//
//    5
//
//    /    \
//
//    3        8
//
//    /   \        \
//
//    1      4        11
//
//    The height of above binary tree is 3.
public class Solution060 {

    int findHeight(TreeNode root) {
        if(root==null) {
            return 0;
        }
        else {
            return Math.max(findHeight(root.left), findHeight(root.right)) + 1;
        }
    }
    
	public static void main(String[] args) {


	}
}
