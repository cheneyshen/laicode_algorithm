package laicode_java;
import java.util.*;

public class Solution229 {

	public List<Integer> majorityElement(int[] nums) {
		int m1=0, m2=0, c1=0, c2=0;
		for(int i=0; i<nums.length; i++) {
			if(m1==nums[i]) {
				c1++;
			} else if(m2==nums[i]) {
				c2++;
			} else if(c1==0) {
				m1=nums[i];
				c1=1;
			} else if(c2==0) {
				m2=nums[i];
				c2=1;
			} else {
				c1--;
				c2--;
			}
		}
		c1=c2=0;
		for(int i=0; i<nums.length; i++) {
			if(nums[i]==m1) {
				c1++;
			} else if(nums[i]==m2) {
				c2++;
			}
		}
		List<Integer> result = new ArrayList<>();
		if(c1>nums.length/3) {
			result.add(m1);
		}
		if(c2>nums.length/3) {
			result.add(m2);
		}
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
