package laicode_java;

import java.util.*;

//3 Sum
//Determine if there exists three elements in a given array that sum to the given target number. Return all the triple of values that sums to target.
//  
//  Assumptions
//  
//  The given array is not null and has length of at least 3
//  No duplicate triples should be returned, order of the values in the tuple does not matter
//  Examples
//  A = {1, 2, 2, 3, 2, 4}, target = 8, return [[1, 3, 4], [2, 2, 4]]
public class Solution186 {
	public List<List<Integer>> solve(int[] array, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		helper(array, target, result);
		return result;
	}
	
	private void helper(int[] array, int target, List<List<Integer>> result) {
		Arrays.sort(array);
		for(int i=0; i<array.length-2; i++) {
			if(i>0 && array[i]==array[i-1]) {
				continue;
			}
			int left=i+1, right = array.length-1;
			while(left<right) {
				int curr = target-array[i]-array[left]-array[right];
				if(curr==0) {
					result.add(Arrays.asList(array[i], array[left], array[right]));
					left++;
					while(left<right && array[left]==array[left-1]) {
						left++;
					}
				} else if(curr>0) {
					left++;
					while(left<right && array[left]==array[left-1]) {
						left++;
					}
				} else {
					right--;
					while(left<right && array[right]==array[right+1]) {
						right--;
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int[] array = new int[]{1,2,2,3,2,4};
		Solution186 ss = new Solution186();
		List<List<Integer>> result = ss.solve(array, 8);
		for(int i=0; i<result.size(); i++) {
			System.out.println(result.get(i));
		}
		array = new int[]{1,2,2};
		result = ss.solve(array, 8);
		for(int i=0; i<result.size(); i++) {
			System.out.println(result.get(i));
		}
	}
}
