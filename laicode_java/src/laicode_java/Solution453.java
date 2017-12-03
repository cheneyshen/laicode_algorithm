package laicode_java;

import java.util.*;

//Number of Digit One
//Given an integer n, count the total number of digit 1 appearing in all non-negative integers less than or equal to n.
//
//For example:
//Given n = 13,
//Return 6, because digit 1 occurred in the following numbers: 1, 10, 11, 12, 13.
public class Solution453 {
	public int countDigitOne(int n) {
		int result=0, left=1, right=1;
        //case1: n=3141092,left= 31410,right=92.hundreds'1=3141*100
        //case2: n=3141192,left= 31411,right=92.hundreds'1=3141*100+(92+1)
        //case3: n=3141592,left= 31415,right=92.hundreds'1=(3141+1)*100 
		while(n>0) {
			int front = (n+8)/10;
			if(front>0) {
				//n>=2
				if(n%10==1) {
					//last digit is 1, such as 11
					result += front * left + right;
				} else {
					result += front * left;
				}
			} else if (n%10==1){
				result += 1*right;
			}
			right += n%10*left;
			left*=10;
			n/=10;
		}
		return result;
	}
	public static void main(String[] args) {


	}
}
