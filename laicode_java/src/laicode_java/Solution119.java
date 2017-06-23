package laicode_java;
import java.util.*;

//Majority Number I
public class Solution119 {
	public int majority(int[] array) {
		int result=array[0];
		int count=1;
		for(int i=1;i<array.length;i++) {
			if(count==0) {
				result=array[i];
				count++;
			}
			else if(array[i]==result) {
				count++;
			}
			else {
				count--;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		Solution119 s119 = new Solution119();
		int[] array={1, 2, 1, 2, 1};
		int result=s119.majority(array);
		System.out.println(result);
	}
}