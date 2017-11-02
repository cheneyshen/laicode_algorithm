package laicode_java;

import java.util.*;

//A + B + C = D
//Determine if there exist 4 elements in an given positive integer array, such that A + B + C = D.
//  Assumptions:
//  The given array is not null and has length of >= 4.
//  All the elements in the given array are positive integers.
//  Examples:
//  
//  array = {1, 4, 3, 2}, there does not exist such elements, return false.
//array = {5, 1, 4, 0, 2, 1}, since 1 + 4 + 0 = 5, return true.
public class Solution314 {
	class Pair {
		int first, second;
		Pair(int f, int s) {
			first = f;
			second = s;
		}
	}
	
	boolean findPairs(int arr[]) {
		HashMap<Integer, Pair> map = new HashMap<>();
		int n = arr.length;
		for(int i=0; i<n; i++) {
			for(int j=i+1; j<n; j++) {
				int sum = arr[i] + arr[j];
				int minus = arr[i] - arr[j];
				if(!map.containsKey(sum)) {
					map.put(sum, new Pair(i, j));
				} else if(map.containsKey(Math.abs(minus))){
					return true;
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) {


	}
}
