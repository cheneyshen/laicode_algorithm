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
		if(input==null || pattern==null) {
			return false;
		}
		int fast = 0, slow = 0;
		while(fast<pattern.length()) {
			if(Character.isLetter(pattern.charAt(fast))) {
				if(input.charAt(slow)!=pattern.charAt(fast)) {
					return false;
				}
				fast++; slow++;
			} else {
				int cur = 0;
				while(fast<pattern.length() && Character.isDigit(pattern.charAt(fast))) {
					cur = cur*10 + pattern.charAt(fast)-'0';
					fast++;
				}
				slow+=cur;
			}
		}
		return slow==input.length() && fast==pattern.length();
	}
	public static void main(String[] args) {


	}
}
