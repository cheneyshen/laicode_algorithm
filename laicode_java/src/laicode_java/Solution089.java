package laicode_java;

import java.util.*;

//Array Hopper II
//	Given an array A of non - negative integers, you are initially positioned at index 0 of the array.A[i] means the maximum jump distance from index i(you can only jump towards the end of the array).Determine the minimum number of jumps you need to reach the end of array.If you can not reach the end of the array, return -1.

//	Assumptions

//	The given array is not null and has length of at least 1.
//	Examples

//{ 3, 3, 1, 0, 4 }, the minimum jumps needed is 2 (jump to index 1 then to the end of array)

//{ 2, 1, 1, 0, 2 }, you are not able to reach the end of array, return -1 in this case.
public class Solution089 {
	public int minJump(int[] input) {
		if(input==null || input.length<1) {
			return -1;
		}
		int[] mi = new int[input.length];
		Arrays.fill(mi, Integer.MAX_VALUE);
		mi[input.length-1] = 0;
		for(int i=input.length-2; i>=0; i--) {
			for(int j=input[i]; j>0; j--) {
				if(mi[i+j]!=Integer.MAX_VALUE) {
					mi[i]=Math.min(mi[i], mi[i+j]+1);
				}
			}
		}
		return mi[0]==Integer.MAX_VALUE?-1:mi[0];
	}
	
	public static void main(String[] args) {
		int[] array = new int[] {3,3,1,0,4};
		Solution089 s = new Solution089();
		System.out.println(s.minJump(array));
	}
}
