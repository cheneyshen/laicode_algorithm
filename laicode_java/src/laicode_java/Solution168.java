package laicode_java;

import java.util.*;

//Length of Last Word
//Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
//
//Input: s = ¡°Hello World   ¡°
//
//Output: 5
public class Solution168 {
	public int lenOfLast(String s) {
		if(s==null || s.length()==0) {
			return 0;
		}
		int leng=0, i=s.length()-1;
		while(i>=0 && s.charAt(i)==' ') {
			i--;
		}
		for(;i>=0 && s.charAt(i) != ' '; i--) {
			leng++;
		}
		return leng;
	}
	public static void main(String[] args) {
		Solution168 ss = new Solution168();
		System.out.println(ss.lenOfLast(""));
		System.out.println(ss.lenOfLast(" "));
		System.out.println(ss.lenOfLast("leng "));
		System.out.println(ss.lenOfLast("Hello World"));
		System.out.println(ss.lenOfLast("Hello World   "));
	}
}
