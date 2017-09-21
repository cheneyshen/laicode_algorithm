package laicode_java;

import java.util.*;

//2 Sum Smaller
//Determine the number of pairs of elements in a given array that sum to a value smaller than the given target number.
//
//Assumptions
//The given array is not null and has length of at least 2
//Examples
//A = {1, 2, 2, 4, 7}, target = 7, number of pairs is 6({1,2}, {1, 2}, {1, 4}, {2, 2}, {2, 4}, {2, 4})
public class Solution184 {
	public int smallerPairs(int[] array, int target) {
		if(array==null || array.length<=1) {
			return 0;
		}
		Arrays.sort(array);
		if(array.length==2) {
			if(array[0]+array[1]<target) {
				return 1;
			} else {
				return 0;
			}
		}
		int result=0;
		for(int i=0; i<array.length-1 && array[i]<=target; i++) {
			int other=target-array[i];
			int low=i, high=array.length-1, mid=i;
			while(low<=high) {
				mid = low + (high-low)/2;
				if(array[mid]<other) {
					if(mid+1<=high && array[mid+1]>other) {
						break;
					}
					else {
						low=mid+1;
					}
				} else {
					if(mid-1>=low && array[mid-1]<other) {
						mid=mid-1;
						break;
					}
					else {
						high=mid-1;
					}
				}
			}
			result+=mid-i;
		}
		return result;
	}
	
	public static void main(String[] args) {
		Solution184 ss = new Solution184();
		int[] array = new int[]{1, 2, 2, 4, 7};
		System.out.println(ss.smallerPairs(array, 7));
	}
}
