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
		String result="";
		for(int i=0; i<input.length(); i++) {
			if(input.charAt(i)>='a' && input.charAt(i)<='z') {
				result+=input.charAt(i);
			} else {
				if(input.charAt(i)=='0') {
					result = result.substring(0, result.length()-1);
				} else {
					for(int add=input.charAt(i); add>'1'; add--) {
						result+= result.charAt(result.length()-1);
					}
				}
			}
		}
		return result;
	}
	public static void main(String[] args) {
		Solution175 ss = new Solution175();
		System.out.println(ss.decompress(""));
		System.out.println(ss.decompress(" "));
		System.out.println(ss.decompress("a"));
		System.out.println(ss.decompress("a1c0b2c4"));
	}
}
