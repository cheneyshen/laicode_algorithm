package laicode_java;

import java.util.*;
//String Replace
//Given an original string input, and two strings S and T, replace all occurrences of S in input with T.
//
//Assumptions
//
//input, S and T are not null, S is not empty string
//Examples
//
//input = "appledogapple", S = "apple", T = "cat", input becomes "catdogcat"
//input = "dodododo", S = "dod", T = "a", input becomes "aoao"

public class Solution172 {
	public String replace(String input, String s, String t) {
		if(input==null || input.length()==0 || input=="") {
			return input;
		}
		List<List<Integer>> pos = new ArrayList<>();
		finderHelper(input, 0, s, pos);
		return replaceHelper(input, t, pos);
	}
	
	private void finderHelper(String input, int index, String s, List<List<Integer>> pos) {
		for(int i=index; i<input.length();i++) {
			int j=0;
			while(j<s.length() && input.charAt(i+j)==s.charAt(j)) {
				j++;
			}
            //docomomomocomo    omo
            //0123456789
            //   i
            //docom
			if(j==s.length()) {
				pos.add(Arrays.asList(i, j));
				i+=j-1;
			}
		}
	}
	
	private String replaceHelper(String input, String t, List<List<Integer>> pos) {
		//from end to start
		StringBuilder sb = new StringBuilder();
		int j = 0;
		for(int i=0; i<pos.size() && j<input.length(); ) {
			if(j!=pos.get(i).get(0)) {
				sb.append(input.charAt(j));
				j++;
			} else {
				sb.append(t);
				j = j + pos.get(i).get(1);
				i++;
			}
		}
		if(j<input.length()) {
			sb.append(input.substring(j));
		}
		return sb.toString();
	}
	public static void main(String[] args) {
		Solution172 ss = new Solution172();
		ss.replace("appledogapple", "apple", "cat");
		ss.replace("dodododo", "dod", "a");
		ss.replace("docomomomocomo", "omo", "o");
	}
}
