package laicode_java;

import java.util.*;

//Different Elements In Two Sorted Arrays
//Given two sorted arrays a and b containing only integers, return two list of elements: the elements only in a but not in b, and the elements only in b but not in a.
//Do it in one pass.
//Assumptions:
//The two given arrays are not null.
//Examples:
//a = {1, 2, 2, 3, 4, 5}
//b = {2, 2, 2, 4, 4, 6}
//The returned two lists are:
//[
//[1, 3, 5],
//[2, 4, 6]  // there are two 2s in a, so there is one 2 in b not in a
//]
public class Solution324 {
	    public static void wiggleSort(int[] nums) {
	        int mid = KthLargest(nums, (nums.length+1)/2);
	        System.out.println(mid);
	        int[] mapper = new int[nums.length];
	        for(int i=0; i<nums.length; i++) {
	            mapper[i] = (1+2*i)%(nums.length|1);
	        }
	        int left=0, right=nums.length-1;
	        int i=0;
	        while(i<=right) {
	            if(nums[mapper[i]]>mid) {
	                swap(nums, mapper[left], mapper[i]);
	                left++;i++;
	            } else if(nums[mapper[i]]<mid) {
	                swap(nums, mapper[i], mapper[right]);
	                right--;
	            } else {
	                i++;
	            }
	        }
	    }
	    
	    public static int KthLargest(int[] nums, int k) {
	        if(nums==null || nums.length<1) {
	            return 0;
	        }
	        int left=0, right=nums.length-1;
	        while(left<=right) {
	            int mid = partition(nums, left, right);
	            if(mid-left==k-1) {
	                return nums[mid];
	            } else if(mid-left>k-1) {
	                right=mid-1;
	            } else {
	                k=k-(mid-left+1);
	                left=mid+1;
	            }
	        }
	        return 0;
	    }
	    
	    private static int partition(int[] nums, int left, int right) {
	        if(nums==null || left>right) {
	            return 0;
	        }
	        int splitter = nums[right];
	        int ll = 0, rr = right-1;
	        while(ll<=rr) {
	            if(nums[ll]>splitter) {
	                ll++;
	            } else if(nums[rr]<splitter) {
	                rr--;
	            } else {
	                swap(nums, ll, rr);
	                ll++;rr--;
	            }
	        }
	        swap(nums, ll, right);
	        return ll;
	    }
	    
	    private static void swap(int[] nums, int left, int right) {
	        int temp = nums[left];
	        nums[left] = nums[right];
	        nums[right] = temp;
	    }
	
	public static void main(String[] args) {
		int[] arr = new int[] {1,3,2,2,3,1};
		//wiggleSort(arr);
		System.out.println(Arrays.toString(arr));
		arr = new int[] {1,2,2,1,2,1,1,1,1,2,2,2};
		wiggleSort(arr);
		System.out.println(Arrays.toString(arr));
	}
}
