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
		if(a==null || b==null || c==null) {
			return null;
		}
		if(a.length==0 || b.length==0 || c.length==0) {
			return null;
		}
		List<Integer> result = new ArrayList<Integer>();
		for(int i=0, j=0, k=0; i<a.length && j<b.length && k<c.length; ) {
			if(a[i]==b[j] && b[j]==c[k]) {
				result.add(a[i]);
				i++; j++; k++;
			} else if(a[i]<b[j] && a[i]<c[k]) {
				i++;
			} else if(a[i]==b[j] && a[i]<c[k]) {
				i++; j++;
			} else if(b[j]<a[i] && b[j]<c[k]) {
				j++;
			} else if(a[i]<b[j] && a[i]==c[k]) {
				i++; k++;
			} else if(b[j]<a[j] && b[j]==c[k]) {
				j++; k++;
			} else if(c[k]<a[i] && c[k]<b[j]) {
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
