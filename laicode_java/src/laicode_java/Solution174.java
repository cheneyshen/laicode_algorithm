package laicode_java;

import java.util.*;
//Decompress String I
//Given a string in compressed form, decompress it to the original string. The adjacent repeated characters in the original string are compressed to have the character followed by the number of repeated occurrences. If the character does not have any adjacent repeated occurrences, it is not compressed.
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
//
//“acb2c4” → “acbbcccc”
public class Solution174 {
	public String decompress(String input) {
		if(input==null || input.length()<2) {
			return input;
		}
		StringBuilder sb = new StringBuilder();
		char curr = input.charAt(0);
		for(int i=0; i<input.length(); i++) {
			//不是数字的话，我们直接加字母，同时更新当前字母
			if(input.charAt(i)>'9') {
				sb.append(input.charAt(i));
				curr = input.charAt(i);
			} else {
				//从2开始，因为我们已经加了一次
				for(char j='2'; j<=input.charAt(i); j++) {
					sb.append(curr);
				}
			}
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		Solution174 ss = new Solution174();
		System.out.println(ss.decompress(null));
		System.out.println(ss.decompress("acb2c4"));
	}
}
