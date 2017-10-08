package laicode_java;

import java.util.*;

//3Sum Closest
//Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
//
//Example
//
//For example, given array S = {-1 2 1 -4}, and target = 1.
//
//The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
public class Solution244 {
	public int Sum3Closest(int[] array, int target) {
		if(array==null || array.length<3) {
			return Integer.MIN_VALUE;
		}
		Arrays.sort(array);
		int result=Integer.MAX_VALUE;
		for(int i=0; i<array.length-2; i++) {
			int left=i+1, right=array.length-1;
			while(left<right) {
				int sum = array[i]+array[left]+array[right];
				if(Math.abs(sum-target) < Math.abs(result-target)) {
					result=sum;
				}
				if(sum==target) {
					return target;
				}
				else if(sum>target) {
					right--;
				}
				else {
					left++;
				}
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		Solution244 ss = new Solution244();
		int[] array = new int[]{-1,2,1,-4};
		int target = 1;
		System.out.println(ss.Sum3Closest(array, target));
	}
}
