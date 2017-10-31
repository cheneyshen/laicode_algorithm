package laicode_java;

import java.util.*;

/*Convert Binary Tree To Doubly Linked List I
 Given a binary tree, convert it to a doubly linked list in place(use the left pointer as previous, use the right pointer as next).
 The values in the nodes of the doubly linked list should follow the in - order traversal sequence of the binary tree.
 Examples:
		10
		/ \
	   5    15
	  /
	 2
	Output:  2 <-> 5 <-> 10 <-> 15
*/
public class Solution300 {
	static class TreeNode {
		int val;
		TreeNode left, right;
		TreeNode(int val) {
			this.val = val;
			this.left = null;
			this.right = null;
		}
	}
	
	TreeNode helper(TreeNode node) {
		if (node==null) {
			return node;
		}
		if (node.left != null) {
			TreeNode left = helper(node.left);
			for (; left.right!=null; left=left.right);
			left.right = node;
			node.left = left;
		}
		if (node.right != null) {
			TreeNode right = helper(node.right);
			for (; right.left!=null; right=right.left);
			right.left = node;
			node.right = right;
		}
		return node;
	}
	
	TreeNode bintree2list(TreeNode node) {
		if (node==null) {
			return node;
		}
		node = helper(node);
		while (node.left != null) {
			node = node.left;
		}
		return node;
	}
	
	void printList(TreeNode node) 
    {
        while (node != null) 
        {
            System.out.print(node.val + " ");
            node = node.right;
        }
    }
	public static void main(String[] args) {
		Solution300 ss = new Solution300();
		TreeNode t1 =new TreeNode(10);
		TreeNode t2 =new TreeNode(12);
		TreeNode t3 =new TreeNode(15);
		TreeNode t4 =new TreeNode(25);
		TreeNode t5 =new TreeNode(30);
		TreeNode t6 =new TreeNode(36);
		t1.left = t2;
		t1.right = t3;
		t2.left = t4;
		t2.right = t5;
		t3.left = t6;
		t1 = ss.bintree2list(t1);
		ss.printList(t1);
	}
	
}
