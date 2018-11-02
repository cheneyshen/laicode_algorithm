package laicode_java;

import java.util.*;

//Combination Sum
//Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums toT. The same repeated number may be chosen from C unlimited number of times.
//
//All numbers (including target) will be positive integers.
//
//Elements in a combination (a1, a2, … , ak) must be in non-descending order.
//
//The solution set must not contain duplicate combinations.
//
//Example
//
//given candidate set 2,3,6,7 and target 7,
//
//A solution set is:
//
//[7]
//[2, 2, 3]
public class Solution232 {
	public List<List<Integer>> combinationSum(int[] num, int target) {
		if(num==null) {
			return null;
		}
		Arrays.sort(num);
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> combi = new ArrayList<>();
		dfsHelper(num, 0, target, combi, result);
		return result;
	}
	
	private void dfsHelper(int[] num, int start, int remain, List<Integer> combi, List<List<Integer>> result) {
		if(remain==0) {
			result.add(new ArrayList<Integer>(combi));
			return;
		}
		if(start==num.length) {
			return;
		}
		for(int i=0; i<=remain/num[start]; i++) {
			int lefts = remain - i*num[start];
			for(int j=0; j<i; j++) {
				combi.add(num[start]);
			}
			dfsHelper(num, start+1, lefts, combi, result);
			for(int j=0; j<i; j++) {
				combi.remove(combi.size()-1);
			}
		}
	}
	
	Stack<Integer> input, output;
	public Solution232() {
		input = new Stack<>();
		output = new Stack<>();
	}
	
	public void push(int x) {
		input.push(x);
	}
	
	public int pop() {
		int result = peek();
		output.pop();
		return result;
	}
	
	public int peek() {
		if(output.isEmpty()) {
			while(!input.isEmpty()) {
				output.push(input.pop());
			}
		}
		return output.peek();
	}
	
	public boolean empty() {
		return input.isEmpty() && output.isEmpty();
	}
	
	public static void main(String[] args) {
		Solution232 ss = new Solution232();
		int[] num = new int[]{2, 3, 6, 7};
		int target = 7;
		List<List<Integer>> result = ss.combinationSum(num, target);
		for(int i=0; i<result.size(); i++) {
			System.out.println(result.get(i));
		}
	}
}
