package laicode_java;

import java.util.*;

//    Get Keys In Binary Tree Layer By Layer Zig-Zag Order
//    Get the list of keys in a given binary tree layer by layer in zig-zag order.
//
//    Examples
//
//    5
//
//    /    \
//
//    3        8
//
//    /   \        \
//
//    1     4        11
//
//    the result is [5, 3, 8, 11, 4, 1]
public class Solution058 {
	public class TreeNode {
		public int key;
		public TreeNode left;
		public TreeNode right;
		public TreeNode(int key) {
			this.key = key;
		}
	}
	
	public List<Integer> zigZag(TreeNode root) {
		if(root==null) {
			return new LinkedList<Integer>();
		}
		Deque<TreeNode> deque=new LinkedList<TreeNode>();
		List<Integer> list=new LinkedList<Integer>();
		deque.offerFirst(root);
		int layer=0;
		while(!deque.isEmpty()) {
			int size=deque.size();
			for(int i=0; i<size; i++) {
				if(layer==0) {
					TreeNode temp = deque.pollLast();
					list.add(temp.key);
					if(temp.right!=null) {
						deque.offerFirst(temp.right);
					}
					if(temp.left!=null) {
						deque.offerFirst(temp.left);
					}
				}
				else {
					TreeNode temp = deque.pollFirst();
					list.add(temp.key);
					if(temp.left!=null) {
						deque.offerLast(temp.left);
					}
					if(temp.right!=null) {
						deque.offerLast(temp.right);
					}
				}
			}
			layer=1-layer;
		}
		return list;
	}
	
	public static void main(String[] args) {


	}
}
