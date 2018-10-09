package laicode_java;

import java.util.*;

//Largest Container
//Given an array of non-negative integers, each of them representing the height of a board perpendicular to the horizontal line, the distance between any two adjacent boards is 1. Consider selecting two boards such that together with the horizontal line they form a container. Find the volume of the largest such container.
//
//Assumptions
//The given array is not null and has size of at least 2
//Examples
//{ 2, 1, 3, 1, 2, 1 }, the largest container is formed by the two boards of height 2, the volume of the container is 2 * 4 = 8.
public class Solution201 {
	public int largest(int[] array) {
		int result=0;
		if(array==null || array.length<1) {
			return 0;
		}
		int leng=array.length;
		int left=0, right=leng-1;
		while (left < right) {
			int minHeight = Math.min(array[left], array[right]);
			result = Math.max(result, minHeight*(right-left));
			if(left<right) {
				if(array[left]<array[right]) {
					left++;
				} else {
					right--;
				}
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		Solution201 ss = new Solution201();
		int[] array = new int[]{2,1,3,1,2,1};
		System.out.println(ss.largest(array));
	}
}
