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
		int leng=s.length();
		if(leng<=1) {
			return s;
		}
		int fast=0, slow=0;
		char[] array=s.toCharArray();
		for(; fast<leng; ) {
			if(array[fast]==array[slow]) {
				fast++;
			} else {
				slow++;
				array[slow] = array[fast];
				fast++;
			}
		}
		return new String(array, 0, slow);
	}
	
	public static void main(String[] args) {


	}
}
