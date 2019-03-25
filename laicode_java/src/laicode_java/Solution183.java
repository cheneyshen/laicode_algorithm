package laicode_java;

import java.util.*;
//2 Sum Closest
//Find the pair of elements in a given array that sum to a value that is closest to the given target number. Return the values of the two numbers.
//
//Assumptions
//
//The given array is not null and has length of at least 2
//Examples
//
//A = {1, 4, 7, 13}, target = 7, closest pair is 1 + 7 = 8, return [1, 7].

public class Solution183 {
	public List<Integer> solve(int[] array, int target) {
		if(array==null || array.length<2) {
			return null;
		}
		Arrays.sort(array);
		List<Integer> result = new ArrayList<>();
		result =  Arrays.asList(array[0], array[1]);
		if(array.length==2) {
			return result;
		}
		int start=0, end=array.length-1, mini = Integer.MAX_VALUE;
		while(start<end) {
			int sum = array[start]+array[end];
			int dist = Math.abs(sum-target);
			//说明在不断收敛，需要更新结果
			if(dist<mini) {
				result = Arrays.asList(array[start], array[end]);
				mini = dist;
			}
			//dist==0, 直接返回，否则移动左右
			if(dist==0) {
				return result;
			} else if(sum>target) {
				end--;
			} else {
				start++;
			}
		}
		return result;
		
	}
	
	public static void main(String[] args) {
		Solution183 ss = new Solution183();
		int[] array = new int[]{1,4,7,13};
		List<Integer> result = ss.solve(array, 7);
		System.out.println(result);
	}
}
