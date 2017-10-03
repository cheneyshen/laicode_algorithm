package laicode_java;

import java.util.*;

//Next Permutation
//Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers. If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
//The replacement must be in-place, do not allocate extra memory.
//  
//  Example
//  1,2,3 → 1,3,2
//  3,2,1 → 1,2,3
//  1,1,5 → 1,5,1
public class Solution238 {
	class AscComparator implements Comparator<Integer>{
		@Override
		public int compare(Integer o1, Integer o2) {
			return o1 - o2;
		}
	}
	public void nextPermutation(int[] nums) {
        if(nums==null || nums.length<2) {
        	return;
        }
//      numbers into the lexicographically next greater permutation of numbers.
//        1 3 4 2
//          |
//            |
//        1 4 3 2
//        1 4 2 3
        int i=nums.length-2;
        for(; i>=0; i--) {
        	if(nums[i]<nums[i+1]) {
        		//found the first less than right node, here nums[i]=3
        		break;
        	}
        }
        int j=nums.length-1;
        for(; j>i; j--) {
        	if(nums[j]>nums[i]) {
        		//found the right section from right, first node bigger than nums[i], here is 4
        		break;
        	}
        }
        //swap the nums[i] with nums[j]
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
        //asc sort from i+1th to the end
        Arrays.sort(nums, i+1, nums.length);
        System.out.println(Arrays.toString(nums));
    }
	
	public static void main(String[] args) {
		Solution238 ss = new Solution238();
		int[] nums = new int[]{6,8,7,4,3,2};
		ss.nextPermutation(nums);
	}
}
