package laicode_java;

import java.util.*;
/*
Largest SubArray Product
Given an unsorted array of doubles, find the subarray that has the greatest product.Return the product.

Assumptions

The given array is not null and has length of at least 1.
Examples

{ 2.0, -0.1, 4, -2, -1.5 }, the largest subarray product is 4 * (-2) * (-1.5) = 12
*/
public class Solution098 {
	public double largestProduct(double[] array) {
		if(array.length==0) {
			return 0;
		}
		double maxproduct=array[0];
		double maxtemp=array[0];
		double mintemp=array[0];
		for(int i=1; i<array.length; i++) {
			double a=maxtemp * array[i];
			double b=mintemp * array[i];
			maxtemp=Math.max(array[i], Math.max(a, b));
			mintemp=Math.min(array[i], Math.min(a, b));
			maxproduct=Math.max(maxtemp, maxproduct);
		}
		return maxproduct;
	}
	
	public static void main(String[] args) {


	}
}
