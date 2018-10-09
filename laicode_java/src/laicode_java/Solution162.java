package laicode_java;

import java.util.*;

//Plus One
//Given a non-negative number represented as an array of digits, plus one to the number.
//
//Input: [2, 5, 9]
//
//Output: [2, 6, 0]
public class Solution162 {
	public int[] plus(int[] digits) {
		if(digits==null || digits.length==0) {
			return digits;
		}
		int carry=1;
		for(int i=digits.length-1; i>=0; i--) {
			int digit=(digits[i]+carry)%10;
			digits[i]=digit;
			carry = (digits[i]+carry)/10;
			if(carry==0) {
				return digits;
			}
		}
		int[] result=new int[digits.length+1];
		result[0] = 1;
		for(int i=0; i<digits.length; i++) {
			result[i+1] = digits[i];
		}
		return result;
	}
	
	public static void main(String[] args) {
		Solution162 ss = new Solution162();
		int[] digits = {9, 9, 9};
		digits = ss.plus(digits);
		System.out.println(Arrays.toString(digits));
	}
}
