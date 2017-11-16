package laicode_java;

import java.util.*;

//Largest BST Subtree
//Given a binary tree, find the largest subtree which is a Binary Search Tree (BST), where largest means subtree with largest number of nodes in it.
//
//Note:
//A subtree must include all of its descendants.
//Here's an example:
//
//    10
//    / \
//   5  15
//  / \   \ 
// 1   8   7
//The Largest BST Subtree in this case is the highlighted one. 
//The return value is the subtree's size, which is 3. 
//
//Follow up:
//Can you figure out ways to solve it with O(n) time complexity?
public class Solution467 {

    public int largestBSTSubtree(TreeNode root) {
        if (root==null)
        	return 0;
        if (isValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE))
        	return count(root);
        return Math.max(largestBSTSubtree(root.left), largestBSTSubtree(root.right));
    }
    
    public boolean isValid(TreeNode root, int mn, int mx) {
        if (root==null) return true;
        if (root.key <= mn || root.key >= mx) return false;
        return isValid(root.left, mn, root.key) && isValid(root.right, root.key, mx);
    }
    
    public int count(TreeNode root) {
        if (root==null) return 0;
        return count(root.left) + count(root.right) + 1;
    }
    
	public static void main(String[] args) {


	}
}
