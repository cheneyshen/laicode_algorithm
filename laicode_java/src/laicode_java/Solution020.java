package laicode_java;

import java.util.*;
//Search In Unknown Sized Sorted Array
//	Given a integer dictionary A of unknown size, where the numbers in the dictionary are sorted in ascending order, determine if a given target integer T is in the dictionary.Return the index of T in A, return -1 if T is not in A.

//	Assumptions

//	dictionary A is not null
//	dictionary.get(i) will return null(Java) / INT_MIN(C++) if index i is out of bounds

public class Solution020 {

	class Dictionary {
	public Integer get(int index) {
			//Return INT_MIN if out of bound;
			//Otherwise return the element value;
			return Integer.MAX_VALUE;
		}
	}
	public int search(Dictionary dictionary, int target) {
		if(dictionary==null) {
			return -1;
		}
		int left=0, right=1;
		while(dictionary.get(right)!=null && dictionary.get(right)<target) {
			left=right;
			right=2*right;
		}
		return binarySearch(dictionary, target, left, right);
	}
	
	private int binarySearch(Dictionary dict, int target, int left, int right) {
		while(left<=right) {
			int mid=left+(right-left)/2;
			if(dict.get(mid)==null || dict.get(mid)>target) {
				right=mid-1;
			} else if(dict.get(mid)<target) {
				left=mid+1;
			} else {
				return mid;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {


	}
}
