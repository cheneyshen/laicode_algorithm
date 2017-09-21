package laicode_java;

import java.util.*;

//Permutation Sequence
//The set [1,2,3,...,n] contains a total of n! unique permutations, return kth largest permutation.
//
//E.g.    Input: n = 3, k = 2    =>    "123"
//
//"132"
//
//"213"
//
//"231"
//
//"312"
//
//"321"
//
//Output: “132”
public class Solution167 {
	public String getPermutation(int n, int k) {
		if(n<=0 || k<=0) {
			return "";
		}
		char[] perm=new char[n];
		int[] index = new int[1];
		index[0]=k;
		for(int i=1; i<=n; i++) {
			perm[i-1] = (char) (i+'0');
		}
		String[] result = new String[1];
		helper(perm, result, index, 0);
		return result[0];
	}
	
	private void helper(char[] input, String[] result, int[] index, int start) {
		if(start==input.length) {
			index[0]--;
			if(index[0]==0) {
				result[0]=String.copyValueOf(input);
			}
			return;
		}
		for(int i=start; i<input.length; i++) {
			swap(input, i, start);
			helper(input, result, index, start+1);
			swap(input, i, start);
		}
	}
	
	private void swap(char[] input, int a, int b) {
		char temp = input[a];
		input[a]= input[b];
		input[b] = temp;
	}
	
	public static void main(String[] args) {
		Solution167 ss = new Solution167();
		System.out.println(ss.getPermutation(3, 2));
	}
}
