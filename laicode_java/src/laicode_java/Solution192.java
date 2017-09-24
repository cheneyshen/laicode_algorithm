package laicode_java;

import java.util.*;

//Kth Smallest With Only 2, 3 As Factors
//Find the Kth smallest number s such that s = 2 ^ x * 3 ^ y, x >= 0 and y >= 0, x and y are all integers.
//Assumptions
//K >= 1
//Examples
//the smallest is 1
//the 2nd smallest is 2
//the 3rd smallest is 3
//the 5th smallest is 2 * 3 = 6
//the 6th smallest is 2 ^ 3 * 3 ^ 0 = 8
//    2^0*3^0  2^0*3^0
//    2^1*3^0  2^0*3^0
//    2^1*3^0  2^0*3^1
//    2^2*3^0  2^0*3^1
//    2^2*3^0  2^1*3^1
//    2^2*3^0  2^1*3^1
//    2^3*3^0  2^1*3^1
public class Solution192 {
	public int Kth(int k) {
		if(k<=0) {
			return 0;
		} else if(k==1) {
			return 1;
		}
		int[] result=new int[k];
		int i2=0, i3=0;
		int next=1;
		result[0]=1;
		for(int i=1; i<k; i++) {
			next = Math.min(result[i2]*2, result[i3]*3);
			result[i] = next;
			if(result[i]==result[i2]*2) {
				i2++;
			}
			if(result[i]==result[i3]*3) {
				i3++;
			}
		}
		return result[k-1];
	}
	
	public static void main(String[] args) {


	}
}
