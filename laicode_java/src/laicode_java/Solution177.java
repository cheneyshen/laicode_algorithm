package laicode_java;

import java.util.*;

//Reconstruct Binary Search Tree With Level Order Traversal
//Given the levelorder traversal sequence of a binary search tree, reconstruct the original tree.
//
//Assumptions
//
//The given sequence is not null
//There are no duplicate keys in the binary search tree
//Examples
//
//levelorder traversal = {5, 3, 8, 1, 4, 11}
//
//the corresponding binary search tree is
//
//        5
//
//      /    \
//
//    3        8
//
//  /   \        \
//
//1      4        11
//
//How is the binary tree represented?
//
//We use the pre order traversal sequence with a special symbol "#" denoting the null node.
//
//For Example:
//
//The sequence [1, 2, #, 3, 4, #, #, #] represents the following binary tree:
//
//    1
//
//  /   \
//
// 2     3
//
//      /
//
//    4
public class Solution177 {

	private TreeNode helper(int[] level, int[] inorder, int left, int right, Map<Integer, Integer> dict) {
		if (left>right) {
		    return null;
		}
		else if (left==right) {
		    return new TreeNode(level[0]);
		}
		TreeNode root = new TreeNode(level[0]);
		int[] leftlevel = new int[right-left];
		int[] rightlevel = new int[right-left];
		int pivot = dict.get(level[0]);
		int lefti=0, righti=0;
		for(int k=1;k<level.length;++k) {
			System.out.println(right+" "+k+" "+level[k]+" "+pivot);
			if(dict.get(level[k]) != null && dict.get(level[k])<pivot) {
				leftlevel[lefti] = level[k];
				lefti++;
			}
			else if(dict.get(level[k]) != null && dict.get(level[k])>pivot) {
				rightlevel[righti] = level[k];
				righti++;
			}
		}
		
		root.left = helper(leftlevel, inorder, left, pivot-1, dict);
		root.right = helper(rightlevel, inorder, pivot+1, right, dict);
		return root;
	}
	public TreeNode reconstruct(int[] level) {
	    // Write your solution here.
		int[] inorder = level.clone();
		Arrays.sort(inorder);
		Map<Integer, Integer> dict = new HashMap<Integer, Integer>();  
		for(int i=0;i<inorder.length;++i) {
			dict.put(inorder[i], i);
		}
		return  helper(level, inorder, 0, level.length-1, dict);
	}
	  
	public static void main(String[] args) {
		Solution177 s177 = new Solution177();
		int[] level={3,2,8,1,5,12,4,7,10,13};
		  // 3 2 8 1 5 12 4  7 10 13
		  // 1 2 3 4 5  7 8 10 12 13
//		  			3
//		  		2       8
//		  	1       5       12
//		  	      4   7  10   13
		TreeNode result = s177.reconstruct(level);
		assert(result.left.value==2);
		return;
	}
}