package laicode_java;

import java.util.*;

//Roman to Integer
//Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.
public class Solution246 {
	public int romanToInt(String s) {
		if(s==null || s.length()<1) {
			return 0;
		}
		int[] dict=new int[256];
		dict['I']=1;
		dict['V']=5;
		dict['X']=10;
		dict['L']=50;
		dict['C']=100;
		dict['D']=500;
		dict['M']=1000;
		int i=s.length()-1;;
		int result = dict[s.charAt(i)];
		int prev = dict[s.charAt(i)];
		int curr;
		for(i=s.length()-2; i>=0; i--) {
			curr = dict[s.charAt(i)];
			if(curr>=prev) {
				result += curr;
				prev = curr;
			} else {
				result -= curr;
				prev = curr;
			}
		}
		return result;
	}
	public static void main(String[] args) {
		Solution246 ss = new Solution246();
		System.out.println(ss.romanToInt(""));
		System.out.println(ss.romanToInt("MCM"));
		System.out.println(ss.romanToInt("MIM"));
		System.out.println(ss.romanToInt("IVXLM"));
	}
}
