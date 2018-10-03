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
    // z
    // s
    //         f
	
	public String deDup(String s) {
		if(s==null || s.length()==0) {
			return s;
		}
		Stack<Character> stk = new Stack<Character>();
		int fast=0;
		for(; fast<s.length(); ) {
			if(!stk.isEmpty() && s.charAt(fast)==stk.peek()) {
				while(s.charAt(fast)==stk.peek()) {
					fast++;
				}
				stk.pop();
			} else {
				stk.push(s.charAt(fast));
				fast++;
			}
		}
		char[] result = new char[stk.size()];
		for(int i=0; i<stk.size(); i++) {
			result[i]=stk.get(i);
		}

		for(int i=0, j=result.length-1; i<j; i++, j--) {
			char temp=result[i];
			result[i]=result[j];
			result[j]=temp;
		}
		return Arrays.toString(result);
	}
	
	public static void main(String[] args) {
		Solution082 ss = new Solution082();
		System.out.println(ss.deDup("abbbaaccz"));
	}
}
