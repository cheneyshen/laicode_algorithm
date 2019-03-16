package laicode_java;

import java.util.*;

//    Power Of Two
//    Determine if a given integer is power of 2.
//
//        Examples
//
//        16 is power of 2 (2 ^ 4)
//        3 is not
//        0 is not
//        -1 is not
public class Solution074 {
	public boolean isPowerOfTwo(int number) {
        if (number == 0) {
            return false;
        }
        long lower = (long)number - 1;
        return (number & lower) == 0;
    }
	
	public static void main(String[] args) {


	}
}
