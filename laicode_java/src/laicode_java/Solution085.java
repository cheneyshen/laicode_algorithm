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
	int strstr(String large, String small) {
		if(small.length()==0) {
			return 0;
		}
		if(large.length()==0) {
			return -1;
		}
		int i=0, j=0;
		while(i<=large.length()-small.length()) {
			while(j<small.length() && small.charAt(j)==large.charAt(i+j)) {
				j++;
			}
			if(j==small.length()) {
				return i;
			}
			else {
				i+=1;
				j=0;
			}
		}
		return -1;
	}
	public static void main(String[] args) {


	}
}
