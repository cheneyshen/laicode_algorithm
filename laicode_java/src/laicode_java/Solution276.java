package laicode_java;

import java.util.*;

//Get Count Array
//Given an array A with all positive integers from [1...N]. How to get an array B such that B[i] represents how many elements A[j] (j > i) in array A that are smaller than A[i].
//Assumptions:
//The given array A is not null.
//Examples:
//A = { 4, 1, 3, 2 }, we should get B = { 3, 0, 1, 0 }.
//Requirement:
//time complexity = O(nlogn).
/*	
 * 该题对应leetcode 315
 */
public class Solution276 {
	//TreeMap 实现方法O(Nlog(N))
	public int[] countArray(int[] array) {
		if(array==null || array.length==0) {
			return array;
		}
		if(array.length == 1) {
			return new int[] {0};
		}
		int[] result = new int[array.length];
		NavigableMap<Integer, Integer> map = new TreeMap<>();
		//从后往前计算，对每个数字统计频率
		for(int i=array.length-1; i>=0; i--) {
			map.put(array[i], map.getOrDefault(array[i], 0)+1);
			//NavigableMap的headMap统计有多少个比array[i]小的key
			Map<Integer, Integer> headMap = map.headMap(array[i], false);
			int value = 0;
			for(Map.Entry<Integer, Integer> e : headMap.entrySet()) {
				value += e.getValue();
			}
			result[i] = value;
		}
		return result;
	}
	
	public static void main(String[] args) {
		Solution276 ss = new Solution276();
		int[] nums = new int[]{5,2,3,3,3,6,1};
		System.out.println(ss.countArray(nums).toString());
	}
}
