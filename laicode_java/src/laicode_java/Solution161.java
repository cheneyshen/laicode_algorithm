package laicode_java;

import java.util.*;

//Square Root I
//Given an integer number n, find its integer square root.
//
//Assumption:
//
//n is guaranteed to be >= 0.
//Example:
//
//Input: 18, Return: 4
//
//Input: 4, Return: 2
public class Solution161 {
	public int sqrt(int x) {
		if(x<=0) {
			return 0;
		} else if (x==1) {
			return 1;
		} else {
			int i=x/2;
			for(; i>=2; i--) {
				if(Math.pow(i, 2)<=x) {
					break;
				}
			}
			return i;
		}
	}
	public static void main(String[] args) {


	}
}
