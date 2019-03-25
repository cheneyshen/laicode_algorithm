package laicode_java;

import java.util.*;

//Remove Adjacent Repeated Characters III
//Remove adjacent, repeated characters in a given string, leaving no character for each group of such characters. The characters in the string are sorted in ascending order.
//  
//  Assumptions
//  
//  Try to do it in place.
//      Examples
//      
//      “aaaabbbc” is transferred to “c”
//      Corner Cases
//      
//      If the given string is null, we do not need to do anything.
public class Solution081 {
	public String duDup(String input) {
		if(input==null || input.length()<2) {
			return input;
		}
		StringBuilder result = new StringBuilder();
		int fast = 0, leng = input.length();
		while(fast<leng) {
			int fast1=fast;
			while(fast1<leng && input.charAt(fast)==input.charAt(fast1)) {
				fast1++;
			}
			//有重复的则跳过
			//没有重复的则添加到结果中
			if(fast1-fast==1) {
				result.append(input.charAt(fast));
			}
			fast=fast1;
		}
		return result.toString();
	}
	
	public static void main(String[] args) {


	}
}
