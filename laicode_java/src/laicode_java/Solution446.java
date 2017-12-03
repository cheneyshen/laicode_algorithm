package laicode_java;

import java.util.*;
//Valid palindrome
//Given a string, determine if it is a palindrome, considering only alphanumeric characters('0'-'9','a'-'z','A'-'Z') and ignoring cases.
//
//For example,
//"an apple, :) elp pana#" is a palindrome.
//
//"dia monds dn dia" is not a palindrome.
//

public class Solution446 {
	public boolean isPalindrome(String s) {
		for(int i=0,j=s.length()-1; i<j; i++,j--) {
			while(Character.isDigit(s.charAt(i))==false && Character.isLetter(s.charAt(i))==false && i<j) {
				i++;
			}
			while(Character.isDigit(s.charAt(i))==false && Character.isLetter(s.charAt(i))==false && i<j) {
				j--;
			}
			if(Character.toUpperCase(s.charAt(i)) != Character.toUpperCase(s.charAt(j))) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {


	}
}
