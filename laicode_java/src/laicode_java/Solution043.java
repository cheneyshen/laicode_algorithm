package laicode;

import java.util.*;
//In-order Traversal Of Binary Tree
//Implement an iterative, in-order traversal of a given binary tree, return the list of keys of each node in the tree as it is in-order traversed.
//
//Examples
//
//      5
//
//    /    \
//
//  3        8
//
///   \        \
//
//1      4        11
//
//In-order traversal is [1, 3, 4, 5, 8, 11]
//
//Corner Cases
//
//What if the given binary tree is null? Return an empty list in this case.
class TreeNode {
	public int key;
	public TreeNode left;
	public TreeNode right;
	public TreeNode(int key) {
		this.key=key;
		this.left=null;
		this.right=null;
	}
}

public class Solution043 {
	List<Integer> inOrder(TreeNode root) {
		List<Integer> inorder=new ArrayList<Integer>();
		Deque<TreeNode> stack=new LinkedList<TreeNode>();
		TreeNode curr=root;
		while(curr!=null || !stack.isEmpty()) {
			if(curr!=null) {
				stack.offerFirst(curr);
				curr=curr.left;
			}
			else {
				curr=stack.pollFirst();
				inorder.add(curr.key);
				curr=curr.right;
			}
		}
		return inorder;
	}
	public static void main(String[] args) {


	}
}
