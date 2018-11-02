package laicode_java;

import java.util.*;

//Given an integer array with all positive numbers and no duplicates, find the number of possible combinations that add up to a positive integer target.
//
//Example:
//
//nums = [1, 2, 3]
//target = 4
//
//The possible combination ways are:
//(1, 1, 1, 1)
//(1, 1, 2)
//(1, 2, 1)
//(1, 3)
//(2, 1, 1)
//(2, 2)
//(3, 1)
//
//Note that different sequences are counted as different combinations.
//
//Therefore the output is 7.
//Follow up:
//What if negative numbers are allowed in the given array?
//How does it change the problem?
//What limitation we need to add to the question to allow negative numbers?
public class Solution377 {

    public int combinationSum4(int[] nums, int target) {
        if(nums==null || nums.length<1) {
            return 0;
        }
        List<List<Integer>> array = new ArrayList<>();
        List<Integer> combo = new ArrayList<>();
        helper(nums, target, combo, array);
        for(int i=0; i<array.size(); i++) {
        	System.out.println(array.get(i));
        }
        return array.size();
    }
    

    int findSmallestIndexNoLessThan(int[] array, int target) {
        int left=0, right=array.length;
        while(left<right) {
            int mid = left+(right-left)/2;
            if (array[mid] <= target) {
            	left = mid+1;
            } else {
                right = mid;
            }
        }
        return left;
    }
    
    void helper(int[] nums,  int target, List<Integer> combo, List<List<Integer>> array) {
        if(target==0) {
            List<Integer> mirr = new ArrayList<>();
            if(combo.size()>0) {
                mirr.addAll(combo);
                array.add(mirr);
            }
            return;
        }
        for(int i=0; i<nums.length; i++) {
            combo.add(nums[i]);
            if(target>=nums[i]) {
                helper(nums, target-nums[i], combo, array);
            }
            combo.remove(combo.size()-1);
        }
    }
	public static void main(String[] args) {
		Solution377 s = new Solution377();
		System.out.println(s.combinationSum4(new int[]{1,2,3,3}, 4));
		System.out.println(s.findSmallestIndexNoLessThan(new int[]{1,2,3}, 4));
	}
}
