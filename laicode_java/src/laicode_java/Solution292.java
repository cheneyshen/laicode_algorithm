package laicode_java;

import java.util.*;

/*String Abbreviation Matching
	Word “book” can be abbreviated to 4, b3, b2k, etc.Given a string and an abbreviation, return if the string matches the abbreviation.
	Assumptions:
The original string only contains alphabetic characters.
	Both input and pattern are not null.
	Examples :
	pattern “s11d” matches input “sophisticated” since “11” matches eleven chars “ophisticate”.*/
public class Solution292 {
	boolean match(String input, String pattern) {
		return helper(input, 0, pattern, 0);
	}
	
	boolean helper(String input, int id, String pattern, int ip) {
		if(id==input.length() && ip==pattern.length()) {
			return true;
		} else if (input.length()==id || pattern.length()==ip) {
			return false;
		} else if (Character.isDigit(pattern.charAt(ip))) {
			int i=ip;
			int num=0;
			while(i<pattern.length() && Character.isDigit(pattern.charAt(i))) {
				num = num*10 + pattern.charAt(i)-'0';
				i++;
			}
			if(id+num>input.length()) {
				return false;
			} else {
				return helper(input, id+num, pattern, i);
			}
		} else {
			if (input.charAt(id)!=pattern.charAt(ip)) {
				return false;
			} else {
				return helper(input, id, pattern, ip+1);
			}
		}
	}
	public static void main(String[] args) {


	}
}
