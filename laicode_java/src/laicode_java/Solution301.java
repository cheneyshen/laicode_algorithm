package laicode_java;

import java.util.*;

//Get Post-order Sequence By Pre-order and In-order
//Given Inorder and Preorder traversals of a binary tree, get the Postorder traversal without reconstructing a binary tree.
//Assumptions:
//The given Inorder and Preorder traversals are guaranteed to be valid.
//Examples:
//Input:
//
//Inorder traversal in[] = {4, 2, 5, 1, 3, 6}
//Preorder traversal pre[] = {1, 2, 4, 5, 3, 6}
//
//Output:
//Postorder traversal is {4, 5, 2, 6, 3, 1}
public class Solution301 {
	int search(int arr[], int from, int x, int n) {
		for(int i=from; i<n; i++) {
			if(arr[i]==x) {
				return i;
			}
		}
		return -1;
	}
	
	void getPostOrder(int in[], int ii, int pre[], int pi, int n, List<Integer> result) {
		int root = search(in, ii, pre[pi], n);
		if(root!=0) {
			getPostOrder(in, ii, pre, pi+1, root, result);
		}
		if(root!=n-1) {
			getPostOrder(in, ii+root+1, pre, pi+root+1, n-root-1, result);
		}
		result.add(new Integer(pre[pi]));
	}
	
	public static void main(String[] args) {
		Solution301 ss = new Solution301();
		int[] in = {4, 2, 5, 1, 3, 6};
		int[] pre = {1, 2, 4, 5, 3, 6};
		List<Integer> result = new ArrayList<>();
		ss.getPostOrder(in, 0, pre, 0, 6, result);
		System.out.println(result.get(0));
	}
}
