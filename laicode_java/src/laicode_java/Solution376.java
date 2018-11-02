package laicode_java;

import java.util.*;
//Ascending Triple I
//Determine if the given integer array has three indices such that i < j < k and a[i] < a[j] < a[k].
//
//Assumptions:
//
//The given array is not null.
//Examples:
//
//{1, 5, 2, 4}, return true since i = 0, j = 2, k = 3
//
//{4, 3, 2, 1}, return false
public class Solution376 {

	  public boolean existIJK(int[] array) {
	    // Write your solution here.
	    return false;
	  }
	  
	public int wiggleMaxLength(int[] nums) {
		if(nums==null || nums.length<1) {
			return nums.length;
		}
		int[] up = new int[nums.length];
		int[] down = new int[nums.length];
		up[0] = down[0] = 1;
		for(int i=1; i<nums.length; i++) {
			if(nums[i]>nums[i-1]) {
				up[i] = down[i-1] + 1;
				down[i] = down[i-1];
			} else if(nums[i]<nums[i-1]) {
				down[i] = up[i-1] + 1;
				up[i] = up[i-1];
			} else {
				up[i] = up[i-1];
				down[i] = down[i-1];
			}
		}
		return Math.max(up[nums.length-1], down[nums.length-1]);
	}
	
	public int combinationSum4(int[] nums, int target) {
		if(nums==null || nums.length<1) {
			return 0;
		}
		int[] dp = new int[target+1];
		Arrays.fill(dp, -1);
		dp[0] = 1;
		helper(nums, target, dp);
		return dp[target];
	}
	
	int helper(int[] nums, int target, int[] dp) {
		if(dp[target]!=-1) {
			return dp[target];
		}
		int result = 0;
		for(int i=0; i<nums.length; i++) {
			if(target>=nums[i]) {
				result += helper(nums, target-nums[i], dp);
			}
		}
		dp[target] = result;
		return result;
	}
	
	public static void main(String[] args) {


	}
}
