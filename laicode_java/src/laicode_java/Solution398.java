package laicode_java;

import java.util.*;
//All Anagrams
//Find all occurrence of anagrams of a given string s in a given string l. Return the list of starting indices.
//
//Assumptions
//
//s is not null or empty.
//l is not null.
//Examples
//
//l = "abcbac", s = "ab", return [0, 3] since the substring with length 2 starting from index 0/3 are all anagrams of "ab" ("ab", "ba").
public class Solution398 {
	public List<Integer> allAnagrams(String sh, String lo) {
		if(sh==null || sh.length()>lo.length() || lo==null || lo.length()<1) {
			return new ArrayList<>();
		}
		Map<Character, Integer> map = countMap(sh);
		List<Integer> res = new ArrayList<>();
		int match = 0;
		for(int i=0; i<lo.length(); i++) {
			char c = lo.charAt(i);
			Integer m = map.get(c);
			if(m!=null) {
				map.put(c, m-1);
				if(m==1) {
					match++;
				}
			}
			if(i>=sh.length()) {
				c = lo.charAt(i-sh.length());
				m = map.get(c);
				if(m!=null) {
					map.put(c, m+1);
					if(m==0) {
						match--;
					}
				}
			}
			if(match==map.size()) {
				res.add(i-sh.length()+1);
			}
		}
		return res;
	}
	
	private Map<Character, Integer> countMap(String sh) {
		Map<Character, Integer> res = new HashMap<>();
		for(int i=0; i<sh.length(); i++) {
			char c = sh.charAt(i);
			res.put(c, res.getOrDefault(c, 0)+1);
		}
		return res;
	}
	public static void main(String[] args) {


	}
}
