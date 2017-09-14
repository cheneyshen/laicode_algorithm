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
		int[] dict=new int[8];
		Arrays.fill(dict, 0);
		for(int i=0; i<word.length(); i++) {
			int aa=word.charAt(i)%32;
			int bb=word.charAt(i)/32;
			if((dict[bb] >> aa)==1) {
				return false;
			} 
			dict[bb]|=1<<aa;
		}
		return true;
	}
	public static void main(String[] args) {
		Solution076 ss = new Solution076();
		System.out.println(ss.allUnique("cab"));
	}
}
