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
	public boolean canChange(String a, String b) {
		if(a==null && b==null) {
			return true;
		}
		if(a==null || b==null || a.length()!=b.length()) {
			return false;
		}
		char[] aa = a.toCharArray();
		char[] bb = b.toCharArray();
		Map<Character, Character> dict = new HashMap<>();
		for(int i=0; i<aa.length; i++) {
			if(aa[i] == bb[i]) {
				continue;
			}
			if(!dict.containsKey(aa[i])) {
				dict.put(aa[i], bb[i]);
			}
			char curr = aa[i];
			for(int j=0; j<aa.length; j++) {
				if(aa[j]==curr) {
					aa[j] = dict.get(curr);
				}
			}
			if(String.copyValueOf(aa).equals(String.valueOf(bb))) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		Solution395 s = new Solution395();
		System.out.println(s.canChange("aba", "cac"));
		System.out.println(s.canChange("abc", "aaa"));
		System.out.println(s.canChange("abc", "cba"));
	}
}
