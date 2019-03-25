package laicode_java;

import java.util.*;

//Remove Adjacent Repeated Characters II
//Remove adjacent, repeated characters in a given string, leaving only two characters for each group of such characters. The characters in the string are sorted in ascending order.
//  
//  Assumptions
//  
//  Try to do it in place.
//      Examples
//      
//      “aaaabbbc” is transferred to “aabbc”
//      Corner Cases
//      
//      If the given string is null, we do not need to do anything.
public class Solution080 {
	public static String deDup(String input) {
		if(input==null || input.length()<2) {
			return input;
		}
		char[] array = input.toCharArray();
		StringBuilder sb = new StringBuilder();
		//直接把前两个元素复制给结果
		sb.append(input.substring(0, 2));
		for(int fast=2; fast<array.length; fast++) {
			//看fast是不是等于fast-2, 不相等就记录
			if(array[fast]!=array[fast-2]) {
				sb.append(array[fast]);
			}
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(deDup("aaaabbbc"));
		System.out.println(deDup("acd"));
	}
}
