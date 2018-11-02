package laicode_java;
import java.util.*;

public class Solution228 {

	public List<String> summaryRanges(int[] nums) {
		List<String> ans = new ArrayList<>();
		for(int i=0; i<nums.length; ) {
			int start = i;
			while(i+1<nums.length && nums[i+1] == nums[i]) {
				i++;
			}
			if(nums[i] > nums[start]) {
				ans.add(String.valueOf(nums[start]) + "->" + String.valueOf(nums[i]));
			} else if(nums[i] == nums[start]) {
				ans.add(String.valueOf(nums[i]));
			}
			i++;
		}
		return ans;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
