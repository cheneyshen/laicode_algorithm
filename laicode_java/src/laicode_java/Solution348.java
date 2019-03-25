package laicode_java;

import java.util.*;

//Reverse Only Vowels
//Only reverse the vowels('a', 'e', 'i', 'o', 'u') in a given string, the other characters should not be moved or changed.
//
//Assumptions:
//
//The given string is not null, and only contains lower case letters.
//Examples:
//
//"abbegi" --> "ibbega"
public class Solution348 {
	public String reverse(String input) {
		if(input==null || input.length()<2) {
			return input;
		}
		char[] chars = input.toCharArray();
		int slow = 0, fast = chars.length-1;
		while(slow < fast) {
			if(isVowels(chars[slow])==false) {
		        slow++;
			} else if(isVowels(chars[fast])==false) {
				fast--;
			} else {
				swap(chars, slow++, fast--);
			}
	    }
		return new String(chars);
	}
	void swap(char[] array, int i, int j) {
		char tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}
	boolean isVowels(char c) {
		return c=='a'||c=='e'||c=='i'||c=='o'||c=='u';
	}
	
	public static void main(String[] args) {


	}
}
