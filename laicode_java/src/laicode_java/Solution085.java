package laicode_java;

import java.util.*;

//Determine If One String Is Another's Substring
//Determine if a small string is a substring of another large string.
//  
//  Return the index of the first occurrence of the small string in the large string.
//  
//  Return -1 if the small string is not a substring of the large string.
//      
//      Assumptions
//      
//      Both large and small are not null
//      If small is empty string, return 0
//      Examples
//      
//      “ab” is a substring of “bcabc”, return 2
//      “bcd” is not a substring of “bcabc”, return -1
//      "" is substring of "abc", return 0
public class Solution085 {
	public int strstr(String large, String small) {
		if(small.length()==0) {
			return 0;
		}
		if(large.length() < small.length()) {
			return -1;
		}
		for(int i=0; i<=large.length()-small.length(); i++) {
			if(equals(large, i, small)) {
				return i;
			}
		}
		return -1;
	}
	
	public boolean equals(String large, int index, String small) {
		for(int i=0; i<small.length(); i++) {
			if(large.charAt(i+index)!=small.charAt(i)) {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {


	}
}
