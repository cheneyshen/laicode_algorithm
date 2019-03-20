package laicode_java;

import java.util.*;

//4 Sum
//Determine if there exists a set of four elements in a given array that sum to the given target number.
//  
//  Assumptions
//  The given array is not null and has length of at least 4
//  Examples
//  A = {1, 2, 2, 3, 4}, target = 9, return true(1 + 2 + 2 + 4 = 8)
//A = {1, 2, 2, 3, 4}, target = 12, return false
public class Solution188 {
	public boolean exist(int[] array, int target) {
		if(array==null || array.length<4) {
			return false;
		}
		Arrays.sort(array);
		Map<Integer, List<Integer>> dict = new HashMap<Integer, List<Integer>>();
		for(int j=1; j<array.length; j++) {
			for(int i=0; i<j; i++) {
				int other=target-array[i]-array[j];
				if(dict.containsKey(other) && dict.get(other).get(1)>0 && dict.get(other).get(1)<i) {
					return true;
				} else if(!dict.containsKey(array[i]+array[j])) {
					dict.put(array[i]+array[j], Arrays.asList(i, j));
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		int[] array = new int[]{1,2,2,3,4};
		Solution188 ss = new Solution188();
		System.out.println(ss.exist(array, 9));
		System.out.println(ss.exist(array, 12));
	}
}
