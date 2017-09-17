package laicode_java;

import java.util.*;

//    Perfect Shuffle
// std::srand(time(NULL)); is already called for you.
public class Solution108 {
	public void shuffle(int[] array) {
		if(array==null || array.length==0) {
			return;
		}
		int leng=array.length;
		for(int i=0; i<leng; i++) {
			int index=(int)(Math.random()*(leng-i));
			swap(array, i, i+index);
		}
	}
	
	private void swap(int[] array, int left, int right) {
		int temp = array[left];
		array[left]=array[right];
		array[right]=temp;
	}
	public static void main(String[] args) {
		Solution108 ss = new Solution108();
		int[] array = {1,2,3,4,5,6,7,8};
		ss.shuffle(array);
		System.out.println(Arrays.toString(array));
	}
}
