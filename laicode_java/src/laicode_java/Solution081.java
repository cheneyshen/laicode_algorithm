package laicode_java;

import java.util.*;

//Remove Adjacent Repeated Characters III
//Remove adjacent, repeated characters in a given string, leaving no character for each group of such characters. The characters in the string are sorted in ascending order.
//  
//  Assumptions
//  
//  Try to do it in place.
//      Examples
//      
//      “aaaabbbc” is transferred to “c”
//      Corner Cases
//      
//      If the given string is null, we do not need to do anything.
public class Solution081 {
	public String duDup(String input) {
		int leng=input.length();
		if(leng<=1) {
			return input;
		}
		String result="";
		result+=input.charAt(0);
		for(int i=1; i<leng; ) {
			if(result.length()>0 && input.charAt(i)==result.charAt(result.length()-1)) {
				while(i<leng && input.charAt(i)==result.charAt(result.length()-1)) {
					i++;
				}
				result=result.substring(0, result.length()-1);
			} else {
				result+=input.charAt(i);
				i++;
			}
		} 
		return result;
	}
	
	public static void main(String[] args) {


	}
}
