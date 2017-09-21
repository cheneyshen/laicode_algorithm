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
		helper(array, target, result);
		return result;
	}
	
	private void helper(int[] array, int target, List<List<Integer>> result) {
		HashMap<Integer, Integer> dict = new HashMap<Integer, Integer>();
		HashMap<Integer, Boolean> checker = new HashMap<Integer, Boolean>();
		for(int i=0; i<array.length; i++) {
			if(dict.containsKey(target-array[i]) && dict.get(target-array[i]) > 0 && !checker.containsKey(array[i])) {
				result.add(Arrays.asList(target-array[i], array[i]));
				checker.put(array[i], true);
				checker.put(target-array[i], true);
			}
			dict.put(array[i], i+1);
		}
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
