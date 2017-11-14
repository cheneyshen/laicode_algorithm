package laicode_java;

import java.util.*;

//Valid Anagram
//Given two strings s and t, write a function to determine if t is an anagram of s.
//
//For example,
//s = "anagram", t = "nagaram", return true.
//s = "rat", t = "car", return false.
//
//Note:
//You may assume the string contains only lowercase alphabets.
//
//Follow up:
//What if the inputs contain unicode characters? How would you adapt your solution to such case?
public class Solution476 {
	public boolean isAnagram(String s, String t) {
		if(s.length() != t.length()) {
			return false;
		}
		int[] mask = new int[256];
		for(int i=0; i<s.length(); i++) {
			mask[s.charAt(i)]++;
		}
		for(int i=0; i<t.length(); i++) {
			char cha = t.charAt(i);
			if(mask[cha]>0) {
				mask[cha]--;
			} else {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {


	}
}
