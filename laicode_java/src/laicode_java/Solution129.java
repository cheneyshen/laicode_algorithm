package laicode_java;
import java.util.*;

public class Solution129 {
	public int search(int[] array, int target) {
		int left=0, right=array.length-1;
		while(left<right) {
			int mid=left+(right-left)/2;
			if(array[mid]>array[right]) {
				left=mid+1;
			}
			else {
				right=mid;
			}
		}
		int shift=left;
		left=0;
		right=array.length-1;
		while(left<=right) {
			int mid=left+(right-left)/2;
			int realmid=(mid+shift)%array.length;
			if(array[realmid]==target) {
				return mid;
			}
			else if(array[realmid]>target) {
				right=mid-1;
			}
			else {
				left=mid+1;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		Solution129 s129 = new Solution129();
		int[] array= {3, 4, 5, 1, 2};
		int result=s129.search(array, 4);
		System.out.println(result);
	}
}