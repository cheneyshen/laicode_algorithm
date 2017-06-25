package laicode_java;
import java.util.*;

//longest ascending subsequence
public class Solution125 {
	public int longest1(int[] array) {
		if(array.length==0) {
			return 0;
		}
		int[] longest=new int[array.length];
		int result=1;
		for(int i=0;i<array.length;i++) {
			longest[i]=1;
			for(int j=0;j<i;j++) {
				if(array[j]<array[i]) {
					longest[i]=Math.max(longest[j]+1, longest[i]);
				}
			}
			result=Math.max(result,  longest[i]);
		}
		return result;
	}
	
	public int longest2(int[] array) {
		if(array.length==0) {
			return 0;
		}
		int[] table=new int[array.length+1];
		int result=1;
		table[1]=array[0];
		for(int i=1;i<array.length;i++) {
			int index=find(table, 1, result, array[i]);
			if(index==result) {
				table[++result]=array[i];
			}
			else {
				table[index+1]=array[i];
			}
		}
		return result;
	}
	
	private int find(int[] table, int left, int right, int target) {
		while(left<=right) {
			int mid=left+(right-left)/2;
			if(table[mid]==target) {
				right=mid-1;
			}
			else if(table[mid]>target) {
				right=mid-1;
			}
			else {
				left=mid+1;
			}
		}
		return right;
	}
	
 	public static void main(String[] args) {
		Solution125 s125 = new Solution125();
		int[] array={5, 2, 6, 3, 4, 7, 5};
		int result=s125.longest1(array);
		System.out.println(result);
		result=s125.longest2(array);
		System.out.println(result);
	}
}