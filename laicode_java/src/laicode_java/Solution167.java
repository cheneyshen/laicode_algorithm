package laicode_java;

//2 Sum Closest
//Find the pair of elements in a given array that sum to a value that is closest to the given target number. Return the values of the two numbers.
//
//Assumptions
//
//The given array is not null and has length of at least 2
//Examples
//
//A = {1, 4, 7, 13}, target = 7, closest pair is 1 + 7 = 8, return [1, 7].
import java.util.*;
public class Solution167 {
	public List<Integer> closest(int[] array, int target) {
		if(array==null || array.length<2) {
			return null;
		}
		Arrays.sort(array);
		if(array.length==2) {
			List<Integer> result=Arrays.asList(array[0], array[1]);
			return result;
		}
		int first=0, second=array.length-1;
		int minDist=Integer.MAX_VALUE;
		List<Integer> result = null;
		while(first<second) {
			int sum=array[first]+array[second];
			int diff=Math.abs(sum-target);
			if(diff<minDist) {
				result=Arrays.asList(array[first], array[second]);
				minDist=diff;
			}
			if(diff==0) {
				return result;
			}
			else if(sum>target) {
				second--;
			}
			else {
				first++;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		Solution167 s167=new Solution167();
		int[] array = {1, 4, 7, 13};
		int target = 7;
		System.out.println(s167.closest(array, target));
		
		array=new int[]{3, 4, 0, -1, 2, 0, 5};
		target=1;
		System.out.println(s167.closest(array, target));
	}
}