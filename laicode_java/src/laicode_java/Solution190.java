package laicode_java;

import java.util.*;

//Valid Number
//Validate if a given string is numeric.
//Input:  ¡°0¡±    Output: true
//Input:  ¡° 0.1 ¡± Output: true
//Input:  ¡°abc¡±   Output: false
//Input:  ¡°1 a¡±   Output: false
//Input:  ¡°2e10¡±    Output: true
public class Solution190 {
	public boolean isValidNumber(String s) {
		if(s==null || s.length()==0) {
			return false;
		}
		int i=0, leng=s.length();
		for(;i<leng && s.charAt(i)==' ' ; ) {
			i++;
		}
		if(i<leng && (s.charAt(i)=='+' || s.charAt(i)=='-')) {
			i++;
		}
		int nums=0, pots=0;
		for(;i<leng && ((s.charAt(i)>='0'&&s.charAt(i)<='9') || (s.charAt(i)=='.')); i++) {
			if(s.charAt(i)=='.') {
				pots++;
			} else {
				nums++;
			}
		}
		if(nums<1 || pots>1) {
			return false;
		}
		if(i<leng && s.charAt(i)=='e') {
			i++;
			if(i<leng && (s.charAt(i)=='+' || s.charAt(i)=='-')) {
				i++;
			}
			int tails=0;
			for(;i<leng && (s.charAt(i)>='0' && s.charAt(i)<='9'); i++) {
				tails++;
			}
			if(tails<1) {
				return false;
			}
		}
		for(;i<leng && s.charAt(i)==' '; i++)  {
		}
		return i==leng;
	}
	
	public static void main(String[] args) {
		Solution190 ss = new Solution190();
		boolean result;
		result = ss.isValidNumber("1");
		System.out.println(result);
		result = ss.isValidNumber("0");
		System.out.println(result);
		result = ss.isValidNumber(" +0.1 ");
		System.out.println(result);
		result = ss.isValidNumber("abc");
		System.out.println(result);
		result = ss.isValidNumber("1  a");
		System.out.println(result);
		result = ss.isValidNumber("2e10");
		System.out.println(result);
		result = ss.isValidNumber("6ee");
		System.out.println(result);
	}
}
