package laicode_java;

import java.util.*;

//Remove Adjacent Repeated Characters I
//Remove adjacent, repeated characters in a given string, leaving only one character for each group of such characters.
//  
//  Assumptions
//  
//  Try to do it in place.
//      Examples
//      
//      “aaaabbbc” is transferred to “abc”
//      Corner Cases
//      
//      If the given string is null, we do not need to do anything.
public class Solution079 {
	public String deDup(String s) {
		if(s==null || s.length()<2) {
			return s;
		}
		char[] array = s.toCharArray();
		int slow = 0;
		for(int fast=0; fast<array.length; fast++) {
			if(fast==0 || array[fast] != array[slow-1]) {
				array[slow++] = array[fast];
			}
		}
		return new String(array, 0, slow);
	}
	
	public static void main(String[] args) {


	}
}
