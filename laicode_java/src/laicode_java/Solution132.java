package laicode_java;

//Total Occurrence
public class Solution132 {
	public int totalOccurrence(int[] array, int target) {
		int left=0, right=array.length-1;
		int first=-1, last=-1;
		while(left<right-1) {
			int mid=left+(right-left)/2;
			if(array[mid]==target) {
				right=mid;
			}
			else if(array[mid]>target) {
				right=mid;
			}
			else {
				left=mid;
			}
		}
		if(array[left]==target) {
			first=left;
		}
		else if(array[right]==target) {
			first=right;
		}
		if(first==-1) {
			return 0;
		}
		left=0;
		right=array.length-1;
		while(left<right-1) {
			int mid=left+(right-left)/2;
			if(array[mid]==target) {
				left=mid;
			}
			else if(array[mid]<target) {
				left=mid;
			}
			else {
				right=mid;
			}
		}
		if(array[right]==target) {
			last=right;
		}
		else if(array[left]==target) {
			last=left;
		}
		return last-first+1;
	}
	
	public static void main(String[] args) {
		Solution132 s132 = new Solution132();
		int[] array=new int[]{1,2,2,2,3};
		int result=s132.totalOccurrence(array, 3);
		System.out.println(result);
		array=new int[]{1,2,2,2,3};
		result=s132.totalOccurrence(array, 2);
		System.out.println(result);
		array=new int[]{1,2,2,2,3};
		result=s132.totalOccurrence(array, 4);
		System.out.println(result);
	}
	
}