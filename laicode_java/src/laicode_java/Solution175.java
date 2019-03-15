package laicode_java;

import java.util.*;
//Decompress String II
//Given a string in compressed form, decompress it to the original string. The adjacent repeated characters in the original string are compressed to have the character followed by the number of repeated occurrences.
//
//Assumptions
//
//The string is not null
//
//The characters used in the original string are guaranteed to be 鈥榓鈥� - 鈥榸鈥�
//
//There are no adjacent repeated characters with length > 9
//
//Examples
//“a1c0b2c4” → “abbcccc”
public class Solution175 {
	public String decompress(String input) {
		if(input==null || input.length()<=1) {
			return input;
		}
		int fast = 0;
		char[] array = input.toCharArray();
		StringBuilder sb = new StringBuilder();
		while(fast < array.length) {
			if(Character.isLetter(array[fast])) {
				sb.append(array[fast]);
				fast++;
			} else {
				int res = 0;
				while(fast<array.length && Character.isDigit(array[fast])) {
					res = res*10 + array[fast]-'0';
					fast++;
				}
				if(res==0) {
					sb.setLength(sb.length()-1);
				} else {
					while(res>1) {
						sb.append(sb.charAt(sb.length()-1));
						res--;
					}
				}
			}
		}
		return sb.toString();
	}
	public static void main(String[] args) {
		Solution175 ss = new Solution175();
		System.out.println(ss.decompress(""));
		System.out.println(ss.decompress(" "));
		System.out.println(ss.decompress("a"));
		System.out.println(ss.decompress("a1c0b2c4"));
	}
}
