package laicode_java;

import java.util.*;

//House Robber II
//Note: This is an extension of House Robber.
//
//After robbing those houses on that street, the thief has found himself a new place for his thievery so that he will not get too much attention. This time, all houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, the security system for these houses remain the same as for those in the previous street.
//
//Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
//

public class Solution434 {
	public int rob(int[] nums) {
		int n = nums.length;
		if(n==0)
			return 0;
		else if (n==1)
			return nums[0];
		else if (n==2)
			return Math.max(nums[0], nums[1]);
		else
			return Math.max(rob(nums, n, 0, n-2), rob(nums, n, 1, n-1));
	}
	
	private int rob(int[] nums, int n, int start, int end) {
		int[] f = new int[n];
        //f[start] = nums[start];
        //f[start+1] = max(nums[start], nums[start+1]);
		for(int i=start; i<=end; i++) {
			int a = (i-2>=0 ? f[i-2]:0) + nums[i];
			int b = (i-1>=0 ? f[i-1]:0);
			f[i] = Math.max(a, b);
		}
		return f[end];
	}
	
	public static void main(String[] args) {


	}
}
