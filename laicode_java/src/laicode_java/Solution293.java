package laicode_java;

import java.util.*;

/*Smallest Substring Containing All Characters Of Another String
	Given two strings s1 and s2, find the shortest substring in s1 containing all characters in s2.
	If there does not exist such substring in s1, return an empty string.
	Assumptions:
s1 and s2 are not null or empty.
	Examples :
	s1 = “The given test strings”
	s2 : “itsst”
	Output string : “st stri”*/
public class Solution293 {
//	i1t2s2
//	t4i2s3
//	
//	t3i2s3 test strings 
//	https://leetcode.com/submissions/detail/62114065/
//	1- First check if length of string is less than
//	   the length of given pattern, if yes
//	       then "no such window can exist ".
//	2- Store the occurrence of characters of given 
//	   pattern in a hash_pat[].
//	3- Start matching the characters of pattern with 
//	   the characters of string i.e. increment count 
//	   if a character matches
//	4- Check if (count == length of pattern ) this 
//	   means a window is found
//	5- If such window found, try to minimize it by 
//	   removing extra characters from beginning of
//	   current window.
//	6- Update min_length.
//	7- Print the minimum length window.
	static final int noChars = 256;
	static String findSubString(String str, String pat) {
		int len1 = str.length();
		int len2 = pat.length();
		if (len1<len2) {
			return "";
		}
		int hash_pat[] = new int[noChars];
		int hash_str[] = new int[noChars];
		for(int i=0; i<len2; i++) {
			hash_pat[pat.charAt(i)]++;
		}
		int start=0, start_index=-1, result=Integer.MAX_VALUE;
		int count=0;
		for(int j=0; j<len1; j++) {
			hash_str[str.charAt(j)]++;
			if(hash_pat[str.charAt(j)]!=0 && 
				hash_str[str.charAt(j)] <= hash_pat[str.charAt(j)]) {
				count++;
			}
			if(count==len2) {
				while(hash_str[str.charAt(start)]>hash_pat[str.charAt(start)] || hash_str[str.charAt(start)]==0) {
					if(hash_str[str.charAt(start)]>hash_pat[str.charAt(start)]) {
						hash_str[str.charAt(start)]--;
					}
					start++;
				}
				int curr = j-start+1;
				if(result>curr) {
					result = curr;
					start_index = start;
				}
			}
		}
		if (start_index==-1) {
			return "";
		}
		return str.substring(start_index, start_index+result);
	}
	public static void main(String[] args) {


	}
}
