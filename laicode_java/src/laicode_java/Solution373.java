package laicode_java;

import java.util.*;
//Reconstruct Binary Tree With Levelorder
//Given the levelorder traversal sequence of a binary tree, reconstruct the original tree.
//
//The levelorder traversal is represented by a string, each valid token is separated by ' ' character, and null node is represented by a special character '#'.
//
//The trailing '#'s are truncated to minimize the length needed of the traversal sequence.
//
//Assumptions
//
//The given sequence is not null
//Examples
//
//level traversal = "3 1 8 4 11 # 5"
//
//The corresponding binary search tree is
//
//        3
//
//      /    \
//
//    1        8
//
//  /   \        \
//
//4     11        5
//

import laicode_java.Solution126.TreeNode;

public class Solution373 {

	public TreeNode reconstruct(String inorder) {
	    // Write your solution here.
	    return null;
	}
	public List<int[]>  kSmallestPairs(int[] nums1, int[] nums2, int k) {
		List<int[]> result = new ArrayList<>();
		Queue<int[]> que = new PriorityQueue<int[]>(k, new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				return a[0] + a[1] - b[0] - b[1];
			}
		});
		if(nums1==null || nums1.length<1 || nums2==null || nums2.length<1) {
			return result;
		}
		for(int i=0; i<nums1.length && i<k; i++) {
			que.offer(new int[] {nums1[i], nums2[0], 0});
		}
		while(k-- > 0 && !que.isEmpty()) {
			int[] cur = que.poll();
			result.add(new int[] {cur[0], cur[1]});
			if(cur[2] == nums2.length-1)	continue;
			que.offer(new int[] {cur[0], nums2[cur[2]+1], cur[2]+1});
		}
		return result;
	}
	public static void main(String[] args) {


	}
}
