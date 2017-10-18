package laicode_java;

import java.util.*;

//Remove Spaces
//Given a string, remove all leading/trailing/duplicated empty spaces.
//Assumptions:
//The given string is not null.
//Examples:
//“  a” --> “a”
//“   I     love MTV ” --> “I love MTV"
public class Solution281 {
	public String removeSpace(String input) {
		String result="";
		int fast=0;
		for(; fast<input.length(); ) {
			while(input.charAt(fast)==' ') {
				fast++;
			}
			while(fast<input.length() && input.charAt(fast)!=' ') {
				result+=input.charAt(fast++);
			}
			while(fast<input.length() && input.charAt(fast)==' ') {
				fast++;
			}
			result+=' ';
		}
		return result;
	}
	public static void main(String[] args) {
		Solution281 ss = new Solution281();
		System.out.println(ss.removeSpace("   I     love MTV "));
	}
}
