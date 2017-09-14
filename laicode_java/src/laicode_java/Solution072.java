package laicode_java;

import java.util.*;

//    Common Numbers Of Two Sorted Arrays
//    Find all numbers that appear in both of two sorted arrays (the two arrays are all sorted in ascending order).
//
//    Assumptions
//    
//    In each of the two sorted arrays, there could be duplicate numbers.
//    Both two arrays are not null.
//    Examples
//    
//    A = {1, 1, 2, 2, 3}, B = {1, 1, 2, 5, 6}, common numbers are [1, 1, 2]

public class Solution072 {
	public List<Integer> common(int[] a, int[] b) {
		List<Integer> result=new ArrayList<Integer>();
		if(a.length==0 || b.length==0) {
			return result;
		}
		HashMap<Integer, Integer> dict=new HashMap<Integer, Integer>();
		for(int i:a) {
			Integer aa=dict.get(i);
			if(aa==null) {
				dict.put(i, 1);
			} else {
				dict.put(i,	aa+1);
			}
		}
		for(int j:b) {
			Integer bb=dict.get(j);
			if(bb!=null && bb>0) {
				result.add(j);
				dict.put(j, bb-1);
			}
		}
		return result;
	}
	public static void main(String[] args) {


	}
}
