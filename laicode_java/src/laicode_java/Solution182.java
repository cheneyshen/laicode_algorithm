package laicode_java;

import java.util.*;
//2 Sum All Pair II
//Find all pairs of elements in a given array that sum to the pair the given target number. Return all the distinct pairs of values.
//
//Assumptions
//
//The given array is not null and has length of at least 2
//The order of the values in the pair does not matter
//Examples
//
//A = {2, 1, 3, 2, 4, 3, 4, 2}, target = 6, return [[2, 4], [3, 3]]

public class Solution182 {
	public List<List<Integer>> solve(int[] array, int target) {
		if(array==null || array.length<2) {
			return null;
		}
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Arrays.sort(array);
		int left = 0, right = array.length-1;
		while(left<right) {
			int cur = array[left]+array[right];
			if(cur==target) {
				result.add(Arrays.asList(array[left], array[right]));
				int newleft = left;
				while(newleft < right && array[newleft] == array[left]) {
					newleft++;
				}
				left = newleft;
			} else if(array[left]+array[right]<target) {
				left++;
			} else {
				right--;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		Solution182 ss = new Solution182();
		int[] array = new int[]{2,1,3,2,4,3,4,2};
		List<List<Integer>> result = ss.solve(array, 6);
		for(int i=0; i<result.size(); i++) {
			System.out.println(result.get(i));
		}
		array = new int[]{2,1};
		result = ss.solve(array, 4);
		for(int i=0; i<result.size(); i++) {
			System.out.println(result.get(i));
		}
	}
}
