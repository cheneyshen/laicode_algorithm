package laicode_java;

import java.util.*;
//Contains Duplicate
//Given an array of integers, find if the array contains any duplicates. Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
public class Solution437 {
	public boolean containsDuplicate(int[] nums) {
		Set<Integer> set = new HashSet<Integer>();
		for(int i:nums) {
			if(!set.add(i)) {	// if there is same
				return true;
			}
		}
		return false;
	}
	public static void main(String[] args) {


	}
}
