package laicode_java;

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
	public List<Integer> inOrder(TreeNode root) {
		List<Integer> res=new ArrayList<Integer>();
		if(root==null) {
			return res;
		}
		Deque<TreeNode> que=new LinkedList<TreeNode>();
		pushLeft(root, que);
		while(!que.isEmpty()) {
			TreeNode cur = que.pollLast();
			res.add(cur.key);
			if(cur.right!=null) {
				pushLeft(cur.right, que);
			}
		}
		return res;
	}
	
	void pushLeft(TreeNode root, Deque<TreeNode> que) {
		while(root!=null) {
			que.addLast(root);
			root = root.left;
		}
	}
	
	public static void main(String[] args) {


	}
}
