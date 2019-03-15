package laicode_java;

import java.util.*;

//Remove Certain Characters
//Remove given characters in input string, the relative order of other characters should be remained. Return the new string after deletion.
//
//Assumptions
//
//The given input string is not null.
//The characters to be removed is given by another string, it is guranteed to be not null.
//Examples
//
//input = "abcd", t = "ab", delete all instances of 'a' and 'b', the result is "cd".
public class Solution395 {
	public String remove(String input, String t) {
		if(input==null || input.length()<1) {
			return input;
		}
		char[] array = input.toCharArray();
		Set<Character> set = new HashSet<>();
		for(char c:t.toCharArray()) {
			set.add(c);
		}
		int slow=0;
		for(int fast=0; fast<array.length; fast++) {
			if(!set.contains(array[fast])) {
				array[slow++] = array[fast];
			}
		}
		return new String(array, 0, slow);
	}
	
	public static void main(String[] args) {
		Solution395 s = new Solution395();
		System.out.println(s.remove("aba", "cac"));
		System.out.println(s.remove("abc", "aaa"));
		System.out.println(s.remove("abc", "cba"));
	}
}
