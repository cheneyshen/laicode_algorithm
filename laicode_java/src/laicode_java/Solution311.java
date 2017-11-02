package laicode_java;

import java.util.*;

//Prime Factors
//Each positive integer larger than 1 is the production of several prime numbers. Return the list of prime factors in ascending order.
//
//Assumptions:
//The given number is >= 2.
//Examples:
//12 = 2 * 2 * 3, return [2, 2, 3]
//5 = 5, return [5]
public class Solution311 {
	List<Integer> primeFactors(int n) {
		List<Integer> result = new ArrayList<>();
		while(n%2==0) {
			result.add(2);
			n/=2;
		}
		for (int i=3; i<=Math.sqrt(n); i++) {
			while(n%i==0) {
				result.add(i);
				n/=i;
			}
		}
		if(n>2) {
			result.add(n);
		}
		return result;
	}
	
	public static void main(String[] args) {


	}
}
