package laicode_java;

import java.util.*;

/*	String Distance
	Given an array of strings, and two different string s and t.We need to return the smallest indices difference between the two given strings.

	Return - 1 if we can not find s or t in the array.

	Assumptions:

	The given array is not null, none of the strings in the array is null.
	s and t are different and they are not null.
	Examples :

	array = { "this", "is", "a", "is", "fox", "fox", "happy" }, the distance of "fox" and "is" is 1.*/
public class Solution283 {
	public int distance(String[] array, String s, String t) {
//		1  3  4   5   6   7
//		is is fox fox fox is
		if(array==null || array.length<2) {
			return Integer.MAX_VALUE;
		}
		int si=-1;
		int ti=-1;
		int result=Integer.MAX_VALUE;
		for(int i=0; i<array.length; i++) {
			if(array[i]==s) {
				si=i;
			} else if(array[i]==t) {
				ti=i;
			}
			if(si!=-1 && ti!=-1) {
				result = Math.min(result, Math.abs(ti-si));
			}
		}
		if(si==-1 || ti==-1) {
			return -1;
		}
		return result;
	}
	
	public static void main(String[] args) {
		Solution283 ss = new Solution283();
		String[] array = { "this", "is", "a", "is", "fox", "fox", "happy" };
		System.out.println(ss.distance(array, "fox", "is"));
		System.out.println(ss.distance(array, "this", "happy"));
		System.out.println(ss.distance(array, "fox", "good"));
	}
}
