package laicode_java;

import java.util.*;

//Add Binary
//Given two binary strings, return their sum (also a binary string).
//
//Input: a = ¡°11¡±
//
//b = ¡°1¡±
//
//Output: ¡°100¡±
public class Solution163 {
	public String addBinary(String a, String b) {
		if(a.isEmpty() || a.length()==0) {
			return b;
		}
		if(b.isEmpty() || b.length()==0) {
			return a;
		}
		int carry=0;
		int i=a.length()-1, j= b.length()-1;
		String result = "";
		while(i>=0 || j>=0 || carry!=0) {
			if(i>=0) {
				carry+=a.charAt(i--)-'0';
			}
			if(j>=0) {
				carry+=b.charAt(j--)-'0';
			}
			result = String.valueOf(carry%2) + result;
			carry = carry/2;
		}
		return result;
	}
	public static void main(String[] args) {
		Solution163 ss = new Solution163();
		String result = ss.addBinary("11", "1");
		System.out.println(result);
	}
}
