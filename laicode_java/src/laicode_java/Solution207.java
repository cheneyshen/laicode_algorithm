package laicode_java;

import java.util.*;

//Majority Number II
//Given an integer array of length L, find all numbers that occur more than 1/3 * L times if any exist.
//  
//  Assumptions
//  
//  The given array is not null
//  Examples
//  
//  A = {1, 2, 1, 2, 1}, return [1, 2]
//A = {1, 2, 1, 2, 3, 3, 1}, return [1]
//A = {1, 2, 2, 3, 1, 3}, return []
public class Solution207 {
	public List<Integer> majority(int[] array) {
		int x=0, y=0;
		int a=0, b=0;
		for(int i=0; i<array.length; i++) {
			if(x==0) {
				a=array[i];
			}
			else if(y==0) {
				b=array[i];
			}
			else if(array[i]==a) {
				x++;
			}
			else if(array[i]==b) {
				y++;
			}
			else {
				x--;y--;
			}
		}
		List<Integer> result = new ArrayList<Integer>();
		x=0; y=0;
		for(int i=0; i<array.length; i++) {
			if(array[i]==a) {
				x++;
			}
			if(array[i]==b) {
				y++;
			}
		}
		if(x>array.length/3) {
			result.add(a);
		}
		if(y>array.length/3) {
			result.add(y);
		}
		return result;
	}
	
	public static void main(String[] args) {
		Solution207 ss = new Solution207();
		int[] array = new int[]{1,2,1,2,3,3,1};
		System.out.println(ss.majority(array));
	}
}
