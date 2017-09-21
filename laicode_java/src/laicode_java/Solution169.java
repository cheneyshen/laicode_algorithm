package laicode_java;

import java.util.*;

//Gray Code
//The gray code is a binary numeral system where two successive values differ in only one bit.
//
//For example: given n = 2, return [0,1,3,2], the gray code sequence is:
//
//00 - 0
//
//01 - 1
//
//11 - 3
//
//10 - 2
//
//Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.
//
//E.g.    Input: n = 2
//
//Output: [0, 2, 3, 1]
public class Solution169 {
	public List<Integer> graycode(int n) {
		List<String> array = grayHelper(n);
		List<Integer> result = new ArrayList<Integer>();
		for(int i=0; i<array.size(); i++) {
			result.add(convert2b(array.get(i)));
		}
		return result;
	}
	
	private List<String> grayHelper(int n) {
		List<String> result = new ArrayList<String>();
		if(n<0) {
			result = null;
			return result;
		} else if(n==0) {
			result.add("0");
			return result;
		} else if(n==1) {
			result.add("0");
			result.add("1");
			return result;
		}
		List<String> lower=grayHelper(n-1);
		for(int i=0; i<lower.size(); i++) {
			result.add("0"+lower.get(i));
		}
		for(int i=lower.size()-1; i>=0; i--) {
			result.add("1"+lower.get(i));
		}
		return result;
	}
	
	private int convert2b(String a) {
		 int result=0;
		 for(int i=0; i<a.length(); i++) {
			 if(a.charAt(i)=='1') {
				 result = result* 2 +1;
			 } else {
				 result = result*2;
			 }
		 }
		 return result;
	}
	public static void main(String[] args) {
		Solution169 ss = new Solution169();
		System.out.println(ss.graycode(3));
	}
}
