package laicode_java;

import java.util.*;

/* 
	Given an array of strings, find if the strings can be concatenated to form a ring.The two strings s1 and s2 can be concatenated iff the the last char of s1 is identical to the first char of s2.The first char of the first string in the array must be identical to the last char of the last string.The ring must contain every string in the input once and only once.
	Assumptions:
The given array is not null or empty.
	None of the strings in the array is null or empty.
	Examples :
	input = { "aaa", "bbb", "baa", "aab" }, return true since it can be re - arranged to{ "aaa", "aab", "bbb"  and "baa" }
	input = { "aaa", "bbb" }, return false*/
public class Solution286 {
	public boolean arrange(String[] input) {
		if (input==null || input.length<1) {
			return false;
		}
		HashMap<Character, List<String>> dict = new HashMap<>();
		HashMap<String, Boolean> visited = new HashMap<>();
//		a aaa aab
//		b bbb baa
		for (int i=0; i<input.length; i++) {
			visited.put(input[i], false);
			char curr = input[i].charAt(0);
			if (dict.containsKey(curr)) {
				dict.get(curr).add(input[i]);
			} else {
				List<String> value = new ArrayList<>();
				value.add(input[i]);
				dict.put(curr, value);
			}
		}
		boolean[] result = new boolean[1];
		result[0]=false;
		dfsHelper(input, input[0], dict, visited, result);
		return result[0];
//		      aaa 
//		       |
//		      aab
//		     /   \
//		   bbb    baa
//		   |       |
//		   baa    bbb
	}
	
	private void dfsHelper(String[] input, String curr, HashMap<Character, List<String>> dict, HashMap<String, Boolean> visited, boolean[] result) {
		if(result[0]==true) {
			return;
		}
		visited.put(curr, true);
		boolean isEnd=true;
		for(int i=0; i<input.length; i++) {
			if(visited.get(input[i])==false) {
				isEnd=false;
				break;
			}
		}
		if(isEnd && curr.charAt(curr.length()-1)==input[0].charAt(0)) {
			result[0]=true;
			return;
		}
		char temp = curr.charAt(curr.length()-1);
		for(int j=0; j<dict.get(temp).size(); j++) {
			String next = dict.get(temp).get(j);
			if(visited.get(next)==false) {
				dfsHelper(input, dict.get(temp).get(j), dict, visited, result);
				visited.put(dict.get(temp).get(j), false);
			}
		}
 	}
	public static void main(String[] args) {
		Solution286 ss = new Solution286();
		String[] input =  { "aaa", "bbb", "baa", "aab" };
		boolean result = ss.arrange(input);
		System.out.println(result);
		input = new String[] {"geek", "king"};
		result = ss.arrange(input);
		System.out.println(result);
		input = new String[] {"for", "geek", "rig", "kaf"};
		result = ss.arrange(input);
		System.out.println(result);
		input = new String[] {"aaa", "bbb"};
		result = ss.arrange(input);
		System.out.println(result);
		
	}
}
