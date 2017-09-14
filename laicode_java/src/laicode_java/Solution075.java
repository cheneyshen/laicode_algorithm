package laicode_java;

import java.util.*;

//    Number Of Different Bits
//    Determine the number of bits that are different for two given integers.
//
//    Examples
//
//    5(“0101”) and 8(“1000”) has 3 different bits
public class Solution075 {
	public int diffBits(int a, int b) {
        //        int count=0;
        //        int a1=0, b1=0;
        //        while (a!=0 || b!=0) {
        //            a1=a&1;
        //            b1=b&1;
        //            count+=a1^b1;
        //            a>>=1;
        //            b>>=1;
        //        }
        //        return count;
        int count = 0;
        int result = a^b;
        while (result!=0) {
            count++;
            result = result&(result - 1);
        }
        return count;
    }
	
	public static void main(String[] args) {


	}
}
