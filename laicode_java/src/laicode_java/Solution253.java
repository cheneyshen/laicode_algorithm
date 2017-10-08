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
		HashMap<Character, Integer> dict = new HashMap<>();
		for(int slow=0, fast=0; fast<leng; fast++) {
			char curr = input.charAt(fast);
			if(dict.containsKey(curr)==false) {
				dict.put(curr, 1);
			} else {
				dict.put(curr, dict.get(curr));
			}
			if(dict.get(curr)>1) {
				while(dict.get(curr)>1) {
					dict.put(input.charAt(slow), dict.get(input.charAt(slow)));
					slow++;
				}
			} else {
				result = Math.max(result, fast-slow+1);
			}
		}
		return result;
	}
	
	public static void main(String[] args) {


	}
}
