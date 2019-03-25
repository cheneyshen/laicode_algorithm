package laicode_java;

import java.util.*;
import java.util.logging.Level;

//Reconstruct Binary Search Tree With Level Order Traversal
//Given the levelorder traversal sequence of a binary search tree, reconstruct the original tree.
//
//Assumptions
//
//The given sequence is not null
//There are no duplicate keys in the binary search tree
public class Solution212 {
	public TreeNode reconstruct(int[] level) {
		if(level==null || level.length<1) {
			return null;
		}
		List<Integer> llist = new ArrayList<>();
		for(int i:level) {
			llist.add(i);
		}
		return helper(llist);
	}
	
	private TreeNode helper(List<Integer> ll) {
		if(ll.isEmpty()) {
			return null;
		}
		TreeNode root = new TreeNode(ll.remove(0));
		List<Integer> lefts=new ArrayList<Integer>();
		List<Integer> rights=new ArrayList<Integer>();
		for(int i : ll) {
			if(i<root.key) {
				lefts.add(i);
			} else {
				rights.add(i);
			}
		}
		root.left = helper(lefts);
		root.right = helper(rights);
		return root;
	}
	
	public static void main(String[] args) {
    	Solution212 ss = new Solution212();
		int[] level = new int[]{4,3,6,2,5,1};
		TreeNode result = ss.reconstruct(level);
		System.out.println(result.left.left.key);
	}
}
