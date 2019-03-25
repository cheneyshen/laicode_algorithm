package laicode_java;

import java.util.*;

//Encode Space
//In URL encoding, whenever we see an space " ", we need to replace it with "20%". Provide a method that performs this encoding for a given string.
//  
//  Examples
//  
//  "google/q?flo wer market" → "google/q?flo20%wer20%market"
//  Corner Cases
//  
//  If the given string is null, we do not need to do anything.
public class Solution083 {
	public String encode(String input) {
		if(input==null || input.length()==0) {
			return input;
		}
		StringBuilder result = new StringBuilder();
		for(int i=0; i<input.length(); i++) {
			if(input.charAt(i) == ' ') {
				result.append("20%");
			}
			else {
				result.append(input.charAt(i));
			}
		}
		return result.toString();
	}
	
	public static void main(String[] args) {
		Solution083 ss = new Solution083();
		String result = ss.encode("google/q?flo wer market");
		System.out.println(result);
	}
}
