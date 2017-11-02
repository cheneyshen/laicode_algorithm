package laicode_java;

import java.util.*;

//Greatest Common Factor
//Find the greatest common factor of two positive integers.
//
//Examples:
//a = 12, b = 18, the greatest common factor is 6, since 12 = 6 * 2, 18 = 6 * 3.
//a = 5, b = 16, the greatest common factor is 1.
public class Solution313 {
	int gcd(int a, int b) {
		if (a==0 || b==0) {
			return 0;
		}
		if (a==b) {
			return a;
		}
		if (a>b) {
			return gcd(a-b, b);
		}
		return gcd(b, b-a);
	}
	
	public static void main(String[] args) {


	}
}
