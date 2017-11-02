package laicode_java;

import java.util.*;

//Primes
//Return the primes less than or equals to target in ascending order.
//
//Assumptions:
//
//The given target is >= 2.
//Examples:
//
//target = 3,  return [2, 3]
//target = 10, return [2, 3, 5, 7]
public class Solution312 {
	List<Integer> primes(int n) {
		boolean[] nonPrime = new boolean[n+1];
		for(int i=2; i<=Math.sqrt(n); i++) {
			if(!nonPrime[i]) {
				for(int j=i*2; j<=n; j+=i) {
					nonPrime[j]=true;
				}
			}
		}
		List<Integer> primes = new ArrayList<>();
		for(int i=2; i<=n; i++) {
			if(!nonPrime[i]) {
				primes.add(i);
			}
		}
		return primes;
	}
	
	public static void main(String[] args) {


	}
}
