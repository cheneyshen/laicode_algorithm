package laicode_java;

import java.util.*;

//Replacements Of A And B
//Given a string with only character 'a' and 'b', replace some of the characters such that the string becomes in the forms of all the 'b's are on the right side of all the 'a's.
//
//Determine what is the minimum number of replacements needed.
//
//Assumptions:
//
//The given string is not null.
//Examples:
//
//"abaab", the minimum number of replacements needed is 1 (replace the first 'b' with 'a' so that the string becomes "aaaab").
public class Solution350 {
    public int minReplacements(String input) {
        if (input.length() <= 1) {
            return 0;
        }
        //   0 1 2 3 4 5 6 7 8 9
        //   a b a b a a a a b a
        // 0 0 1 1 2 2 2 2 2 3 3 全换成a
        //  / / / / / / / / / /
        // 7 6 6 5 5 4 3 2 1 1 0 全换成b
        // 0 1 2 3 4 5 6 7 8 9 10
        int[] aCount = new int[input.length() + 1];
        int[] bCount = new int[input.length() + 1];
        for (int i = 1; i < bCount.length; i++) {
          int j = bCount.length-1-i;
          aCount[i] = input.charAt(i-1)=='b'?aCount[i-1]+1:aCount[i-1];
          bCount[j] = input.charAt(j)=='a'?bCount[j+1]+1:bCount[j+1];
        }
        int globalMin = Integer.MAX_VALUE;
        for (int i = 0; i < bCount.length; i++) {
            globalMin = Math.min(globalMin, bCount[i] + aCount[i]);
        }
        return globalMin;
    }

	public static void main(String[] args) {


	}
}
