package laicode_java;

import java.util.*;

//Remove Element
//Given an array and a value, remove all instances of that value in place and return the new length. The order of elements can not be changed.
//
//Examples
//Input:     [1,2,3,1]
//value:      1
//Output:   [2,3]
/* 1 2 3 1
 * 2 3 1 1
 * 
 * 
 */
public class Solution240 {
	public int[] removeElement(int[] nums, int target) {
		if(nums==null || nums.length<1) {
			return nums;
		}
		int i=0;
		for(int j=0; j<nums.length; j++) {
			if(nums[j]!=target) {
				nums[i++]=nums[j];
			}
		}
		return Arrays.copyOfRange(nums, 0, i);
	}

	public static void main(String[] args) {
		Solution240 ss = new Solution240();
		int[] nums = {1,2,3,1};
		int target = 1;
		nums = ss.removeElement(nums, target);
		System.out.println(Arrays.toString(nums));
	}
}
