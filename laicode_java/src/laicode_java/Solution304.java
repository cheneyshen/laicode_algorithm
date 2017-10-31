package laicode_java;

import java.util.*;

//Valid Post-order Traversal Of Binary Search Tree
//Given an array with integers, determine whether the array contains a valid postorder traversal sequence a BST.
//
//Assumptions:
//The given postorder traversal array is not null.
//Examples:
//{ 3, 5, 4 }  is valid
//{ 3,  6,  2,  5,  4} is not valid
public class Solution304 {
	boolean isPostTraversalOfBST(int arr[], int start, int end) {
		if(end<2) {
			return true;
		}
		int i=0;
		//try to find out the beginning of right subtree's traversal
		for(; arr[start+i]<arr[end-1]; i++);
		//check if all arr[i,end-1) >= arr[end-1]
		for(int j=start+i+1; j+1<end; j++) {
			if(arr[j]<arr[end-1]) {
				return false;
			}
		}
		//check if both two parts are post traversals of BSTs
		return isPostTraversalOfBST(arr, 0, i) &&
				isPostTraversalOfBST(arr, i, end-1);
	}
	
	public static void main(String[] args) {


	}
}
