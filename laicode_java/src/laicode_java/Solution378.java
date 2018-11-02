package laicode_java;

import java.util.*;

//Arrange Tasks
//Given a list of tasks, each task could have a list of dependency tasks, for examples, task 1 only can be executed after task 2 and task 3 finish execution.
//
//If at a time there is only one task can be executed. Find an order of finishing all the tasks. If there is no such order, return null.
//
//Examples:
//
//task 1 depends on task 2 and 3.
//
//task 2 depends on task 3.
//
//task 3 does not depend on anything.
//
//There exists an order [task 3, task 2, task 1] to finish all.
public class Solution378 {
	public int kthSmallest(int[][] matrix, int k) {
		if(matrix==null || matrix.length < 1 || matrix[0].length<1 || k<0) {
			return -1;
		}
		int n = matrix.length;
		int left=matrix[0][0], right = matrix[n-1][n-1];
		int mid;
		while(left<right) {
			mid = (left+right)/2;
			int num=0;
			for(int i=0; i<n; i++) {
				int pos = findBiggestNoLessThan(matrix[i], mid);
				num+=pos;
			}
			if(num<k) {
				left=mid+1;
			} else {
				right=mid;
			}
		}
		return left;
	}
	
	public int findBiggestNoLessThan(int[] array, int target) {
		int left= 0, right = array.length;
		while(left<right) {
			int mid=(right-left)/2;
			if(array[mid] > target) {
				right = mid;
			} else {
				left= mid+1;
			}
		}
		return left;
	}
	
	public static void main(String[] args) {


	}
}
