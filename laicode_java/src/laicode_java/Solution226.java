package laicode_java;

import java.util.*;

//Multiply Strings
//Given two numbers represented as strings, return multiplication of the numbers as a string. The numbers can be arbitrarily large and are non-negative.
//
//Example
//
//Input: "19", "20"
//
//Output: "380"
public class Solution226 {
	public String multiply(String num1, String num2) {
		if(num1==null || num2==null) {
			return null;
		}
		int al=num1.length(), bl=num2.length();
		char[] result = new char[al+bl];
		for(int i=0; i<al+bl; i++) {
			result[i]='0';
		}
		for(int i=al-1; i>=0; i--) {
			int carry = 0;
			int from = result.length-al+i;
			for(int j=bl-1; j>=0; j--) {
				int ai = num1.charAt(i) - '0';
				int bj = num2.charAt(j) - '0';
				int curr = ai*bj + carry;
//				System.out.println(result[from]);
//				System.out.println(current.charAt(current.length()-1)-'0');
				curr += result[from] -'0';
				result[from] = (char) (curr%10 + '0');
//				System.out.println(result[from]);
				from--;
				if(curr>9) {
					carry = curr/10;
				} else {
					carry = 0;		// fixed for no carry
				}
			}
			if(carry>0) {
				result[from] = (char) (carry+'0');
			}
//			System.out.println(Arrays.toString(result));
		}
		//we would have front 0, just find and remove them
		int i=0,j=0;
		for(; i<result.length; i++) {
			if(result[i]!='0') {
				j=i;
				break;
			}
		}
		if(i==result.length) {
			return "0";
		}
		String output=new String(result, j, result.length-j);
 		return output;
    }
	public static void main(String[] args) {
		Solution226 ss = new Solution226();
		String result="";
		result = ss.multiply("9", "9");
		System.out.println(result);
		result = ss.multiply("0", "0");
		System.out.println(result);
		result = ss.multiply("19", "20");
		System.out.println(result);
		result = ss.multiply("99", "99");
		System.out.println(result);
		result = ss.multiply("1910191", "202333");
		System.out.println(result);	//386494675603
	}
}
