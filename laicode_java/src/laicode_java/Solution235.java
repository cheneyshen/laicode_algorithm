package laicode_java;

import java.util.*;

//Count and Say
//Given a sequence of number: 1, 11, 21, 1211, 111221, …
//
//The rule of generating the number in the sequence is as follow:
//
//1 is "one 1" so 11.
//11 is "two 1s" so 21.
//21 is "one 2 followed by one 1" so 1211.
//
//Find the nth number in this sequence.
//Assumptions:
//
//n starts from 1, the first number is "1", the second number is "11"
public class Solution235 {
	public String countAndSay(int n) {
		if(n<=0) {
			return "";
		}
		String result = "1";
		if(n==1) {
			return result;
		}
		while(--n>0) {
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<result.length(); i++) {
				int count=1;
				while((i+1<result.length()) && (result.charAt(i)==result.charAt(i+1))) {
					count++;
					i++;
				}
				sb.append(count).append(result.charAt(i));
			}
			result=sb.toString();
		}
		return result;
	}
	
	public static void main(String[] args) {
		Solution235 ss = new Solution235();
		System.out.println(ss.countAndSay(1));
		System.out.println(ss.countAndSay(2));
		System.out.println(ss.countAndSay(3));
		System.out.println(ss.countAndSay(4));
		System.out.println(ss.countAndSay(10));
	}
}
