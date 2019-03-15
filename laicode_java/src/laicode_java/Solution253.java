package laicode_java;

import java.util.*;

//Longest Substring Without Repeating Characters
//Given a string, find the longest substring without any repeating characters and return the length of it. The input string is guaranteed to be not null.
//
//For example, the longest substring without repeating letters for "bcdfbd" is "bcdf", we should return 4 in this case.
public class Solution253 {
	public int longest(String input) {
		int leng=input.length();
		if(leng<=1) {
			return leng;
		}
		int result=0;
		char[] array = input.toCharArray();
		int slow = 0, fast = 0;
		Set<Character> set = new HashSet<>();
		while(fast<array.length) {
			if(set.contains(array[fast])) {
				set.remove(array[slow++]);
			} else {
				set.add(array[fast++]);
				result = Math.max(result, fast-slow);
			}
		}
		return result;
	}
	
	public static void main(String[] args) {


	}
}
