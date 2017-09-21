package laicode_java;

import java.util.*;

//2 Sum
//Determine if there exist two elements in a given array, the sum of which is the given target number.
//  
//  Assumptions
//  
//  The given array is not null and has length of at least 2
//  Examples
//  
//  A = {1, 2, 3, 4}, target = 5, return true (1 + 4 = 5)
//
//A = {2, 4, 2, 1}, target = 4, return true (2 + 2 = 4)
//
//A = {2, 4, 1}, target = 4, return false
public class Solution180 {
	public boolean existSum(int[] array, int target) {
		if(array==null || array.length<2) {
			return false;
		}
		Set<Integer> dict = new HashSet<Integer>();
		for(int i=0; i<array.length; i++) {
			if(dict.contains(target-array[i])==true) {
				return true;
			}
			dict.add(array[i]);
		}
		return false;
	}
	
	public static void main(String[] args) {
		Solution180 ss = new Solution180();
		int[] array = new int[]{1,2,3,4};
		int target = 5;
		System.out.println(ss.existSum(array, target));
		System.out.println(ss.existSum(array, 9));
	}
}
