package laicode_java;

import java.util.*;

//Remove Adjacent Repeated Characters II
//Remove adjacent, repeated characters in a given string, leaving only two characters for each group of such characters. The characters in the string are sorted in ascending order.
//  
//  Assumptions
//  
//  Try to do it in place.
//      Examples
//      
//      “aaaabbbc” is transferred to “aabbc”
//      Corner Cases
//      
//      If the given string is null, we do not need to do anything.
public class Solution080 {
	public String deDup(String input) {
		int leng=input.length();
		if(leng<=2) {
			return input;
		}
		String result="";
		result+=input.charAt(0);
		result+=input.charAt(1);
		for(int i=2; i<leng; i++) {
			if(input.charAt(i)==input.charAt(i-2)) {
				continue;
			} else {
				result+=input.charAt(i);
			}
		}
		return result;
	}
	
	public static void main(String[] args) {


	}
}
