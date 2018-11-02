package laicode_java;

import java.util.*;

//Combination Sum II
//Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums toT. Each number in C may only be used once in the combination.
//
//All numbers (including target) will be positive integers.
//Elements in a combination (a1, a2, … , ak) must be in non-descending order.
//The solution set must not contain duplicate combinations.
//
//Example
//given candidate set 10,1,2,7,6,1,5 and target 8,
//A solution set is:
//
//[1, 7]
//[1, 2, 5]
//[2, 6]
//[1, 1, 6]
public class Solution231 {
	public List<List<Integer>> combinationSum2(int[] num, int target) {
		if(num==null) {
			return null;
		}
		Arrays.sort(num);
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> combi = new ArrayList<>();
		HashMap<String, Integer> dict = new HashMap<>();
		dfsHelper(num, 0, target, combi, result, dict);
		return result;
	}
	
	private void dfsHelper(int[] num, int start, int remain, List<Integer> combi, List<List<Integer>> result, HashMap<String, Integer> dict) {
		if(remain==0) {
			String combo = "";
			for(int i=0; i<combi.size(); i++) {
				combo+=combi.get(i)+'0';
			}
			if(dict.containsKey(combo)==false) {
				dict.put(combo, 1);
				result.add(new ArrayList<Integer>(combi));
			}
			return;
		}
		if(start==num.length) {
			return;
		}
		if(remain>=num[start]) {
			int leng=combi.size();
			combi.add(num[start]);
			dfsHelper(num, start+1, remain-num[start], combi, result, dict);
			combi.remove(leng);
			dfsHelper(num, start+1, remain, combi, result, dict);
		}
	}
	
	public boolean isPowerOfTwo(int n) {
		return (n>0&&((n&(n-1))==0));
	}
	
	public static void main(String[] args) {
		Solution231 ss = new Solution231();
		int[] num = new int[]{10,1,2,7,6,1,5};
		int target = 8;
		List<List<Integer>> result = ss.combinationSum2(num, target);
		for(int i=0; i<result.size(); i++) {
			System.out.println(result.get(i));
		}
	}
}
