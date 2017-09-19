package laicode_java;

import java.util.*;
/*Decode Ways
A message containing letters from A - Z is being encoded to numbers using the following ways :
A = 1
B = 2

Z = 26
Given an encoded message containing digits, determine the total number of ways to decode it.
Input:    212
It can be either decoded as 2, 1, 2("BAB") or 2, 12("BL") or 21, 2("UB"), return 3.
            212
     2,12         21,2
     1,2  12    2,1  21
     1  -  1
     9  -  1
     10
            10
      1,0        10,
      1+0        1
            19
      1,9        19
            20
      2,0        20
        	26
      2,6        26
            
*/

public class Solution148 {
	public int numDecodeWay(String s) {
		if(s==null || s.length()==0 || s.charAt(0)=='0') {
			return 0;
		}
		int leng=s.length();
		if(leng==1) {
			return 1;
		} else if(leng==2) {
			if(s.charAt(1)=='0') {
				return 1;
			}
			else {
				return 2;
			}
		} else {
			if(s.charAt(1)=='0') {
				return numDecodeWay(s.substring(2)) + 1;
			}
			else {
				return 1 + numDecodeWay(s.substring(1));
			}
		}
	}
	public static void main(String[] args) {
		Solution148 ss = new Solution148();
		System.out.println(ss.numDecodeWay("2120"));
		
	}
}
