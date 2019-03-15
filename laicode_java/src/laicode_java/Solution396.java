package laicode_java;

import java.util.*;

//Reverse String
//Reverse a given string.
//
//Assumptions
//
//The given string is not null.
public class Solution396 {
	public String reverse(String input) {
		if(input==null || input.length()<2) {
			return input;
		}
		char[] array = input.toCharArray();
		int left = 0, right = array.length-1;
		while(left<right) {
			char tmp = array[left];
			array[left] = array[right];
			array[right] = tmp;
			left++;right--;
		}
		return new String(array);
	}
	public static void main(String[] args) {


	}
}
