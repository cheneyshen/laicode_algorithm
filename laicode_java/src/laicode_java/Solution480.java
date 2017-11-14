package laicode_java;

import java.util.*;

//Strobogrammatic Number III
//A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
//
//Write a function to count the total strobogrammatic numbers that exist in the range of low <= num <= high.
//
//For example,
//Given low = "50", high = "100", return 3. Because 69, 88, and 96 are three strobogrammatic numbers.
//
//Note:
//Because the range might be a large number, the low and high numbers are represented as string.
//

public class Solution480 {
	private int result = 0;
	
	public int strobogrammaticInRange(String low, String high) {
		for(int i=low.length(); i<=high.length(); i++) {
			find(low, high, "", i);
			find(low, high, "0", i);
			find(low, high, "1", i);
			find(low, high, "8", i);
		}
		return result;
	}
	
	private void find(String low, String high, String path, int leng) {
		if(path.length() >= leng) {
			if(path.length()!=leng || (leng!=1 && path.charAt(0)=='0')) {
				return;
			}
			if((leng==low.length() && path.compareTo(low)<0) || (leng==high.length() && path.compareTo(high)>0)) {
				return;
			}
			result++;
		}
		find(low, high, "0"+path+"0", leng);
		find(low, high, "1"+path+"1", leng);
		find(low, high, "6"+path+"9", leng);
		find(low, high, "8"+path+"8", leng);
		find(low, high, "9"+path+"6", leng);
	}
	
	public static void main(String[] args) {


	}
}
