package laicode_java;

import java.util.*;

//Container With Most Water
//Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water. Note: You may not slant the container.
public class Solution248 {
	public boolean existIII(int[] array, int target) {
		return true;
	}
	
	public int maxArea(int[] height) {
		if(height==null || height.length<2) {
			return 0;
		}
		/*  _ _  _ _ _ _
		 *	____________
		 */
		int left=0, right=height.length-1;
		int leftMax=height[left];
		int rightMax=height[right];
		int result=0;
		while(left<=right) {
			if(leftMax<=rightMax) {
				if(height[left]>leftMax) {
					leftMax=height[left];
				}
				int diff = leftMax-height[left];
				result += diff;
				left++;
			} else {
				if(height[right]>rightMax) {
					rightMax = height[right];
				}
				int diff = rightMax-height[right];
				result += diff;
				right--;
			}
		}
		return result;
	}
	public static void main(String[] args) {
		Solution248 ss = new Solution248();
		int[] height = new int[]{2,1,9,1,2,1,3};
		int result = ss.maxArea(height);
		System.out.println(result);
	}
}
