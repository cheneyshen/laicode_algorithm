package laicode_java;

import java.util.*;

//Palindrome Number
//Determine whether an integer is a palindrome.
//
//Assumptions
//
//Could negative integers be palindromes? (ie, -1) No.
//
//If you are thinking of converting the integer to string, note the restriction of using extra space.You could also try reversing an integer. However, if you have solved the problem "Reverse Integer", you know that the reversed integer might overflow. How would you handle such case? There is a more generic way of solving this problem.
public class Solution250 {
	public boolean isPalindrome(int i) {
		if(i<0) {
			return false;
		}
		else if(i<10) {
			return true;
		}
		int copy = i;
		int mirror=0;
		while(copy>0) {
			mirror = mirror*10 + copy%10;
			copy = copy/10;
		}
		return mirror == i;
	}
	
	public static void main(String[] args) {
		Solution250 ss = new Solution250();
		boolean result=false;
		result = ss.isPalindrome(250);
		System.out.println(result);
		result = ss.isPalindrome(252);
		System.out.println(result);
		result = ss.isPalindrome(25252);
		System.out.println(result);
	}
}
