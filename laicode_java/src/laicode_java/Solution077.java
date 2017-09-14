package laicode_java;

import java.util.*;

//    All Unique Characters II
//    Determine if the characters of a given string are all unique.
//
//        Assumptions
//
//        We are using ASCII charset, the value of valid characters are from 0 to 255
//        The given string is not null
//        Examples
//
//        all the characters in "abA+\8" are unique
//        "abA+\a88" contains duplicate characters
public class Solution077 {
	public boolean allUnique(String s) {
		int[] mapper=new int[8];
		for(int i=0; i<s.length(); i++) {
			int aa=s.charAt(i)/32;
			int bb=s.charAt(i)%32;
			if(((mapper[aa]>>bb)&1) ==1) {
				return false;
			} else {
				mapper[aa]|=(1<<bb);
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		Solution077 ss=new Solution077();
		System.out.println(ss.allUnique("abA+\\a8"));
	}
}
