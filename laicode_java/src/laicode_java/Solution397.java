package laicode_java;

import java.util.*;
//
//Right Shift By N Characters
//Right shift a given string by n characters.
//
//Assumptions
//
//The given string is not null.
//n >= 0.

public class Solution397 {
	public String rightShift(String input, int n) {
		/*
		 defgabc		gfedcba	defgabc
		 */
		if(input==null || input.length()<=1) {
			return input;
		}
		char[] array = input.toCharArray();
		n %= array.length;
		swap(array, 0, array.length-1);
		swap(array, 0, n-1);
		swap(array, n, array.length-1);
		return new String(array);
	}
	
	private void swap(char[] array, int i, int j) {
		while(i<j) {
			char tmp = array[i];
			array[i] = array[j];
			array[j] = tmp;
			i++; j--;
		}
	}
	
	public static void main(String[] args) {


	}
}
