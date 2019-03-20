package laicode_java;

import java.util.*;
//Common Elements In Three Sorted Array
//Find all common elements in 3 sorted arrays.
//
//Assumptions
//
//The 3 given sorted arrays are not null
//There could be duplicate elements in each of the arrays
//Examples
//
//A = {1, 2, 2, 3}, B = {2, 2, 3, 5}, C = {2, 2, 4}, the common elements are [2, 2]

public class Solution171 {
	public List<Integer> common(int[] a, int[] b, int[] c) {
		List<Integer> result = new ArrayList<>();
		int i=0, j=0, k=0;
		while(i<a.length && j<b.length && k<c.length) {
			if(a[i] == b[j] && b[j] == c[k]) {
				result.add(a[i]);
				i++;j++;k++;
			} else if(a[i] <= c[k] && a[i] <= b[j]) {
				i++;
			} else if(b[j] <= a[i] && b[j] <= c[k]) {
				j++;
			} else {
				k++;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		Solution171 ss = new Solution171();
		List<Integer> result = ss.common(null, null, null);
		System.out.println(result);
		int[] a = new int[]{2, 2, 3, 5};
		int[] b = new int[]{1, 2, 2, 3};
		int[] c= new int[]{2, 2, 4};
		result = ss.common(a, b, c);
		System.out.println(result);
	}
}
