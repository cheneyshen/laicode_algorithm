package laicode_java;

import java.util.*;

//Keep Distance For Identical Elements
//Given an integer k, arrange the sequence of integers [1, 1, 2, 2, 3, 3, ...., k - 1, k - 1, k, k], such that the output integer array satisfy this condition:
//
//Between each two i's, they are exactly i integers (for example: between the two 1s, there is one number, between the two 2's there are two numbers).
//
//If there does not exist such sequence, return null.
//
//Assumptions:
//
//k is guaranteed to be > 0
//Examples:
//
//k = 3, The output = { 2, 3, 1, 2, 1, 3 }.
public class Solution264 {
	public int[] keepDistance(int k) {
/*	0 0 0 0 0 0
 *      3     3
 *  2     2
 */
		int[] array = new int[2*k];
		int[] result = new int[2*k];
		Arrays.fill(array, 0);
		helper(array, k, 2*k, result);
		boolean failed=false;
		for(int x=0; x<2*k; x++) {
			if(result[x]==0) {
				failed=true;
			}
		}
		return failed ? null : result;
	}
	
	private void helper(int[] array, int curr, int leng, int[] result) {
		if(curr==0) {
			boolean failed=false;
			for(int x=0; x<leng; x++) {
				if(array[x]==0) {
					failed=true;
				}
			}
			if(failed==false) {
				for(int y=0; y<leng; y++) {
					result[y]=array[y];
				}
			}
			return;
		}
		for(int i=0;i+curr+1<leng; i++) {
			if(array[i]==0 && array[i+curr+1]==0) {
				array[i]=curr;
				array[i+curr+1]=curr;
				helper(array, curr-1, leng, result);
				array[i]=0;
				array[i+curr+1]=0;
			}
		}
	}
	
	public static void main(String[] args) {
		Solution264 ss = new Solution264();
		System.out.println(Arrays.toString(ss.keepDistance(1)));
		System.out.println(Arrays.toString(ss.keepDistance(2)));
		System.out.println(Arrays.toString(ss.keepDistance(3)));
		System.out.println(Arrays.toString(ss.keepDistance(4)));
		System.out.println(Arrays.toString(ss.keepDistance(5)));
		System.out.println(Arrays.toString(ss.keepDistance(6)));
		System.out.println(Arrays.toString(ss.keepDistance(7)));
	}
}
