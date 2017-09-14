package laicode_java;

import java.util.*;
//    Common Numbers Of Two Arrays II
//    Find all numbers that appear in both of two unsorted arrays.
//
//    Assumptions
//
//    Both of the two arrays are not null.
//    In any of the two arrays, there could be duplicate numbers.
//    Examples
//
//    A = {1, 2, 3, 2}, B = {3, 4, 2, 2, 2}, return [2, 2, 3] (there are both two 2s in A and B)

public class Solution071 {
	public List<Integer> commonII(int[] a, int[] b) {
		List<Integer> common=new ArrayList<Integer>();
		HashMap<Integer, Integer> countA=new HashMap<Integer, Integer>();
		for(int num:a) {
			Integer ct=countA.get(num);
			if(ct!=null) {
				countA.put(num, ct+1);
			}
			else {
				countA.put(num, 1);
			}
		}
		HashMap<Integer, Integer> countB=new HashMap<Integer, Integer>();
		for(int num:b) {
			Integer ct=countB.get(num);
			if(ct!=null) {
				countB.put(num, ct+1);
			}
			else {
				countB.put(num, 1);
			}
		}
		for(Map.Entry<Integer, Integer> entry:countA.entrySet()) {
			Integer ctInB=countB.get(entry.getKey());
			if(ctInB!=null) {
				int appear = Math.min(entry.getValue(), ctInB);
				for (int i=0; i<appear; i++) {
					common.add(entry.getKey());
				}
			}
		}
		return common;
	}
	public static void main(String[] args) {


	}
}
