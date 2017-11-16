package laicode_java;

import java.util.*;

//Longest Substring with At Most K Distinct Characters
//Given a string, find the length of the longest substring T that contains at most k distinct characters.
//
//For example, Given s = “eceba” and k = 2,
//
//T is "ece" which its length is 3.
//

public class Solution473 {
	//a hashmap is used to track the unique elements in the map. When a third character is added to the map, the left pointer needs to move right.
	public int lengthOfLongestSubstringKDistinct(String s, int k) {
		if(k==0 || s==null || s.length()==0) {
			return 0;
		}
		if(s.length()<k) {
			return s.length();
		}
		
		int res = 0, left = 0;
		HashMap<Character, Integer> map = new HashMap<>();
		
		for(int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			if(map.containsKey(c)) {
				map.put(c, map.get(c)+1);
			} else {
				map.put(c, 1);
			}

			if(map.size()>k) {
				res = Math.max(res, i-left);
				while(map.size()>k) {
					char fc = s.charAt(left);
					if(map.get(fc)==1) {
						map.remove(fc);
					} else {
						map.put(fc, map.get(fc)-1);
					}
				}
				left++;
			}
		}
		res = Math.max(res, s.length()-left);
		return res;
	}
	
	public static void main(String[] args) {


	}
}
