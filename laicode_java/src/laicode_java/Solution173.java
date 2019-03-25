package laicode_java;

import java.util.*;
//Compress String
//Given a string, replace adjacent, repeated characters with the character followed by the number of repeated occurrences. If the character does not has any adjacent, repeated occurrences, it is not changed.
//
//Assumptions
//
//The string is not null
//
//The characters used in the original string are guaranteed to be ‘a’ - ‘z’
//
//There are no adjacent repeated characters with length > 9
//
//Examples
//
//“abbcccdeee” → “ab2c3de3”
public class Solution173 {
	public String compress(String input) {
		if(input==null || input.length()<2) {
			return input;
		}
		StringBuilder sb = new StringBuilder();
		//先带第一个字母
		sb.append(input.charAt(0));
		int count=1;
		for(int i=1; i<input.length();) {
			//计算次数
			while(i<input.length() && input.charAt(i)==input.charAt(i-1)) {
				count++;
				i++;
			}
			//>1的时候才加数字
			if(count>1) {
				sb.append(String.valueOf(count));
			}
			if(i<input.length()) {
				sb.append(input.charAt(i));
			}
			count=1;
			i++;
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		Solution173 ss = new Solution173();
		System.out.println(ss.compress(" "));
		System.out.println(ss.compress("abbcccdeee"));
	}
}
