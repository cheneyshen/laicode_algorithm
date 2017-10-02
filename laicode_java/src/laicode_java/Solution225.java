package laicode_java;

import java.util.*;

//Implement atoi to convert a string to an integer.
//
//Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.
//
//Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.
public class Solution225 {
	public int atoi(String a) {
		if(a==null || a.length()<1) {
			return 0;
		}
		a=a.toLowerCase().trim();
		long result=0;
		int minus=1;
		for(int i=0; i<a.length(); i++) {
			if(i==0 && a.charAt(i)=='-') {
				minus=-1;
			}
			else if(a.charAt(i)>='0' && a.charAt(i)<='9') {
				result = result*10+a.charAt(i)-'0';
			}
			else {
				return 0;
			}
		}
		result = result*minus;
		if(result>Integer.MAX_VALUE || result<Integer.MIN_VALUE) {
			return 0;
		}
		return (int)result;
	}
	
	public static void main(String[] args) {
		Solution225 ss = new Solution225();
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		System.out.println(ss.atoi("-123456"));
		System.out.println(ss.atoi("-1234567891"));
		System.out.println(ss.atoi("-12345678912"));
		System.out.println(ss.atoi("-123456789123"));
		System.out.println(ss.atoi("-2147483649"));
		System.out.println(ss.atoi("2147483648"));
		System.out.println(ss.atoi("-2147483648"));
		System.out.println(ss.atoi("2147483647"));
		
	}
}
