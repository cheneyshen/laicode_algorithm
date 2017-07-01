package laicode_java;
import java.util.*;

//Search In Shifted Sorted Array II
public class Solution130 {
	public int search(int[] array, int target) {
	    int leng=array.length;
	    if(leng<=0) {
	    	return -1;
	    }
		int left=0, right=leng-1;
		while(left<=right) {
			int mid=left+(right-left)/2;
			if(array[mid]==target) {
				return mid;
			}
			else if(array[mid]>array[left]) {
				//{3, 4, 5, 1, 2}
				if(array[mid]>target && array[left]<=target) {
					right=mid-1;
				}
				else {
					left=mid+1;
				}
			}
			else if(array[mid]<array[left]) {
				//{1, 2, 3, 4, 5, 6}
				if(array[mid]<target && array[right]>=target) {
					left=mid+1;
				}
				else {
					right=mid-1;
				}
			}
			else {
				//array[mid]=array[left], 3, 3, 3, 1, 2  
				left++;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		Solution130 s130 = new Solution130();
		int[] array= {1};
		int result=s130.search(array, 1);
		System.out.println(result);
	}
}