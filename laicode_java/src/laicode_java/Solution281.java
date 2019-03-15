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
	public String removeSpaces(String input) {
		if(input.isEmpty()) {
			return input;
		}
		char[] array = input.toCharArray();
		int end=0;
		for(int fast=0; fast<input.length(); fast++) {
			if(array[fast]==' ' && (fast==0 || array[fast-1]==' ')) {
				continue;
			}
			array[end++] = array[fast];
		}
		if(end>0 && array[end-1]==' ') {
			return new String(array, 0, end-1);
		}
		return new String(array, 0, end);
	}
	
	public static void main(String[] args) {
		Solution281 ss = new Solution281();
		System.out.println(ss.removeSpaces("   I     love MTV "));
	}
}
