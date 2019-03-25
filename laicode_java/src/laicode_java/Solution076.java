package laicode_java;

import java.util.*;

//    All Unique Characters I
//    Determine if the characters of a given string are all unique.
//
//        Assumptions
//
//        The only set of possible characters used in the string are 'a' - 'z', the 26 lower case letters.
//        The given string is not null.
//        Examples
//
//        the characters used in "abcd" are unique
//        the characters used in "aba" are not unique
public class Solution076 {
	public boolean allUnique(String word) {
		int[] dict=new int[26];
		
		for(int i=0; i<word.length(); i++) {
			int cur = word.charAt(i)-'a';
			if(dict[cur] != 0) {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		Solution076 ss = new Solution076();
		System.out.println(ss.allUnique("cab"));
	}
}
