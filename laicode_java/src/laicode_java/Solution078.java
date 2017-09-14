package laicode_java;

import java.util.*;

//    Hexadecimal Representation
//    Generate the hexadecimal representation for a given non-negative integer number as a string. The hex representation should start with "0x".
//
//        There should not be extra zeros on the left side.
//
//        Examples
//
//        0's hex representation is "0x0"
//        255's hex representation is "0xFF"
public class Solution078 {
	public String hex(int n) {
		String result = "";
		int offset;
		char cur;
		if(n==0) {
			result+="0";
		}
		else {
			while(n>0) {
				offset=n%16;
				if(offset<10) {
					cur=(char) (offset+'0');
				} else {
					cur=(char)(offset+'A'-10);
				}
				result += cur;
				n/=16;
			}
		}
		result+="x0";
		return new StringBuilder(result).reverse().toString();
	}
	public static void main(String[] args) {
		Solution078 ss = new Solution078();
		System.out.println(ss.hex(22222));
	}
}
