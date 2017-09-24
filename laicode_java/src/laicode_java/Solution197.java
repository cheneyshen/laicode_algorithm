package laicode_java;

import java.util.*;

//ReOrder Array
//Given an array of elements, reorder it as follow:
//{ N1, N2, N3, 鈥�, N2k } 鈫� { N1, Nk+1, N2, Nk+2, N3, Nk+3, 鈥� , Nk, N2k }
//{ N1, N2, N3, 鈥�, N2k+1 } 鈫� { N1, Nk+1, N2, Nk+2, N3, Nk+3, 鈥� , Nk, N2k, N2k+1 }
//
//Try to do it in place.
//  
//  Assumptions
//  
//  The given array is not null
//  Examples
//  
//{ 1, 2, 3, 4, 5, 6} 鈫� { 1, 4, 2, 5, 3, 6 }
//
//{ 1, 2, 3, 4, 5, 6, 7, 8 } 鈫� { 1, 5, 2, 6, 3, 7, 4, 8 }
/*
 * 1 2 3 4 5 6 7 8   8/4=2
 * 1 2 4 3 6 5 7 8
 * 1 2 5 6 3 4 7 8
 * 1 5 2 6 3 7 4 8 
 */
//{ 1, 2, 3, 4, 5, 6, 7 } 鈫� { 1, 4, 2, 5, 3, 6, 7 }
public class Solution197 {
	public List<Integer> reorder(int[] array) {
		List<Integer> intList = new ArrayList<Integer>();
		if(array.length%2==0) {
			helper(array, 0, array.length-1);
		}
		else {
			helper(array, 0, array.length-2);
		}
		for(int i=0; i<array.length; i++) {
			intList.add(array[i]);
		}
		return intList;
	}
	
	private void helper(int[] array, int left, int right) {
		if(right-left<=1) {
			return;
		}
		/* 0 1 2 3 4 5 6 7
		 * lm=2 m=4 rm=6
		 * 0 1 2 3 4 5 6 7 8 9
		 * lm=2 m=5 rm=7
		 */
		int leng = right-left+1;
		int mid = left+leng/2;
		int leftmid = left+leng/4;
		int rightmid = mid+leng/4;
		reverse(array, leftmid, mid-1);
		reverse(array, mid, rightmid-1);
		reverse(array, leftmid, rightmid-1);
		helper(array, left, left+2*(leftmid-left)-1);
		helper(array, left+2*(leftmid-left), right);
		return;
	}
	
	private void reverse(int[] array, int left, int right) {
		while(left<right) {
			int temp = array[left];
			array[left] = array[right];
			array[right] = temp;
			left++;right--;
		}
	}
	
	public static void main(String[] args) {
		Solution197 ss = new Solution197();
		int[] array = new int[] {1,2,3,4,5,6};
		List<Integer> result = ss.reorder(array);
		System.out.println(result);
		array = new int[] {1,2,3,4,5,6,7};
		result = ss.reorder(array);
		System.out.println(result);
		array = new int[] {1,2,3,4,5,6,7,8,9,10};
		result = ss.reorder(array);
		System.out.println(result);
	}
}
