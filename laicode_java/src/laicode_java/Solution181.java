package laicode_java;

import java.util.*;

//2 Sum All Pair I
//Find all pairs of elements in a given array that sum to the given target number. Return all the pairs of indices.
//
//Assumptions
//
//The given array is not null and has length of at least 2.
//
//Examples
//
//A = {1, 3, 2, 4}, target = 5, return [[0, 3], [1, 2]]
//
//A = {1, 2, 2, 4}, target = 6, return [[1, 3], [2, 3]]
public class Solution181 {
	public List<List<Integer>> allPairs(int[] array, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		for(int i=0; i<array.length; i++) {
			List<Integer> indices = map.get(target - array[i]);
			if(indices!=null) {
				for(int j : indices) {
					result.add(Arrays.asList(j, i));
				}
			}
			map.putIfAbsent(array[i], new ArrayList<Integer>());
			map.get(array[i]).add(i);
		}
		return result;
	}
	
	public static void main(String[] args) {
		Solution181 ss = new Solution181();
		int[] array = new int[]{1,2,2,4};
		List<List<Integer>> result = ss.allPairs(array, 6);
		for(int i=0; i<result.size(); i++) {
			System.out.println(result.get(i));
		}
	}
}
