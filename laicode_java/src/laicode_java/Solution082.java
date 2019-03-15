package laicode_java;

import java.util.*;

//Remove Adjacent Repeated Characters IV
//Repeatedly remove all adjacent, repeated characters in a given string from left to right.
//
//No adjacent characters should be identified in the final string.
//
//Examples
//
//"abbbaaccz" → "aaaccz" → "ccz" → "z"
//"aabccdc" → "bccdc" → "bdc"
public class Solution082 {
    // abbbaaccz
    //  s
    //       f
	
	public String deDup(String s) {
		if(s==null || s.length()<2) {
			return s;
		}
	    /*
	    abbbaaccz
	           s
	   e
	    */
		int end = -1;
		char[] array = s.toCharArray();
		for(int start = 0; start<array.length; start++) {
			if(end==-1 || array[end] != array[start]) {
				array[++end] = array[start];
			} else {
				end--;
				while(start+1<array.length && array[start+1]==array[start]) {
					start++;
				}
			}
		}
		return new String(array, 0, end+1);
	}
	
	public static void main(String[] args) {
		Solution082 ss = new Solution082();
		System.out.println(ss.deDup("abbbaaccz"));
	}
}
