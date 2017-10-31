package laicode_java;

import java.util.*;

/*Form Largest Number
	Given an array of numbers in string type, sort them in a way that the concatenation of them yields the largest value.Return the largest number in string type.
	Assumptions:
The given array is not null.
	Each of the strings in the array is not null and they are all numbers.
	Examples :
{“54”, “546”, “648”, “88”}, the arrangement “8864854654” gives the largest value.*/
public class Solution287 {
	
    public String largestNumber(String[] nums) {
    	if(nums==null || nums.length<1) {
    		return null;
    	} else if(nums.length<2) {
    		return nums[0];
    	}
    	Arrays.sort(nums);
        String result="";
        for(int i=nums.length-1; i>=0; --i) {
            result += nums[i];
//        	System.out.println(nums[i]);
        }
        return result;
    }
    
	public static void main(String[] args) {
		Solution287 ss = new Solution287();
		String[] nums = {"54", "546", "648", "88"};
		String result = ss.largestNumber(nums);
		System.out.println(result);
	}
}
