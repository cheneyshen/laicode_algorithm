package laicode_java;

//Shift Position
public class Solution131 {
	public int shiftPosition(int[] array) {
		if(array.length<=0) {
			return -1;
		}
		int left=0, right=array.length-1;
		while(left<right) {
			int mid=left+(right-left)/2;
			if(array[mid]>=array[right]) {
				left=mid+1;
			}
			else {
				right=mid;
			}
		}
		return left;
	}
	
	public static void main(String[] args) {
		Solution131 s131 = new Solution131();
		int[] array={3,4,5,1,2};
		int result=s131.shiftPosition(array);
		System.out.println(result);
		array=new int[]{1,2,3,4,5};
		result=s131.shiftPosition(array);
		System.out.println(result);
		array=new int[]{4,1,2,3};
		result=s131.shiftPosition(array);
		System.out.println(result);
	}
}