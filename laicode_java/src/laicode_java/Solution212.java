package laicode_java;

import java.util.*;

//Reconstruct Binary Search Tree With Level Order Traversal
//Given the levelorder traversal sequence of a binary search tree, reconstruct the original tree.
//
//Assumptions
//
//The given sequence is not null
//There are no duplicate keys in the binary search tree
public class Solution212 {
	public TreeNode reconstruct(int[] level) {
		List<Integer> ll = new ArrayList<Integer>();
		for(int i=0; i<level.length; i++) {
			ll.add(level[i]);
		}
		int[] inorder = level;
		Arrays.sort(inorder);
		HashMap<Integer, Integer> dict = new HashMap<Integer, Integer>();
		for(int i=0; i<inorder.length; i++) {
			dict.put(inorder[i], i);
		}
		return helper(ll, 0, inorder.length-1, dict);
	}
	
	private TreeNode helper(List<Integer> ll, int left, int right, HashMap<Integer, Integer> dict) {
		if(left>right) {
			return null;
		}
		else if(left==right) {
			return new TreeNode(ll.get(0));
		}
		TreeNode root = new TreeNode(ll.get(0));
		List<Integer> lefts=new ArrayList<Integer>();
		List<Integer> rights=new ArrayList<Integer>();
		int pivot = dict.get(ll.get(0));
		for(int i=1; i<ll.size(); i++) {
			if(dict.get(ll.get(i))<pivot) {
				lefts.add(ll.get(i));
			}
			else if(dict.get(ll.get(i))>pivot) {
				rights.add(ll.get(i));
			}
		}
		root.left = helper(lefts, left, pivot-1, dict);
		root.right = helper(rights, pivot+1, right, dict);
		return root;
	}
	
	public static void main(String[] args) {
    	Solution212 ss = new Solution212();
		int[] level = new int[]{4,3,6,2,5,1};
		TreeNode result = ss.reconstruct(level);
		System.out.println(result.left.left.key);
	}
}
