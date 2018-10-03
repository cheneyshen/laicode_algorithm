package laicode_java;

import java.util.*;

//Array Hopper III
//	Given an array of non - negative integers, you are initially positioned at index 0 of the array.A[i] means the maximum jump distance from that position(you can only jump towards the end of the array).Determine the minimum number of jumps you need to jump out of the array.

//	By jump out, it means you can not stay at the end of the array.Return - 1 if you can not do so.

//	Assumptions

//	The given array is not null and has length of at least 1.
//	Examples

//{ 1, 3, 2, 0, 2 }, the minimum number of jumps needed is 3 (jump to index 1 then to the end of array, then jump out)

//{ 3, 2, 1, 1, 0 }, you are not able to jump out of array, return -1 in this case.
public class Solution090 {
	public int minJump(int[] array) {
		if(array.length==0) {
			return -1;
		}
		int[] jumps=new int[array.length];
		Arrays.fill(jumps, Integer.MAX_VALUE);
		jumps[0]=0;
		for(int i=0; i<array.length; i++) {
			for(int j=array[i]; j>=0; j--) {
				if(jumps[i]!=Integer.MAX_VALUE) {
					if(i+j<array.length) {
						jumps[i+j]=Math.min(jumps[i+j], jumps[i]+1);
					} else {
						return jumps[i]+1;
					}
				}
			}
		}
		if(array[array.length-1]>0) {
			if(jumps[array.length-1]!=Integer.MAX_VALUE) {
				return jumps[array.length-1]+1;
				
			} else {
				return -1;
			}
		} else {
			return -1;
		}
	}
	public static void main(String[] args) {
		int[] array = new int[] {1,3,2,0,2};
		Solution090 solution = new Solution090();
		System.out.println(solution.minJump(array));
		
	}
}
