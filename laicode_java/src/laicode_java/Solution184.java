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
		if(array==null || array.length<2) {
			return 0;
		}
		Arrays.sort(array);
		int result=0;
		// 对每个数字i, 计算对应的最远的j, 然后求距离
		for(int i=0; i<array.length-1 && array[i]<=target; i++) {
			// 从i+1 到末尾 二分查找求
			int j = search(array, i+1, array.length-1, target-array[i]);
			if(j!=-1) {
				result+=j-i;
			}
		}
		return result;
	}
	private int search(int[] array, int left, int right, int target) {
		// binary search v3 2分查找
		if(left+1>=right) {
			if(right>left && array[right]<target) {
				return right;
			}
			if(array[left]<target) {
				return left;
			}
			return -1;
		}
		while(left+1<right) {
			int mid = left+(right-left)/2;
			if(array[mid]>=target) {
				right=mid;
			} else {
				left=mid;
			}
		}
		if(array[right]<target) {
			return right;
		}
		if(array[left]<target) {
			return left;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		Solution184 ss = new Solution184();
		int[] array = new int[]{1, 2, 2, 4, 7};
		System.out.println(ss.smallerPairs(array, 7));
	}
}
