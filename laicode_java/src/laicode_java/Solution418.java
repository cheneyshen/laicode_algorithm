package laicode_java;

import java.util.*;

//Range Sum Query 2D - Immutable
//Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).
//
//Range Sum Query 2D
//The above rectangle (with the red border) is defined by (row1, col1) = (2, 1) and (row2, col2) = (4, 3), which contains sum = 8.
//
//Example:
//
//Given matrix = [
//  [3, 0, 1, 4, 2],
//  [5, 6, 3, 2, 1],
//  [1, 2, 0, 1, 5],
//  [4, 1, 0, 1, 7],
//  [1, 0, 3, 0, 5]
//]
//
//sumRegion(matrix,2, 1, 4, 3) -> 8
//sumRegion(matrix, 1, 1, 2, 2) -> 11
//sumRegion(matrix, 1, 2, 2, 4) -> 12
//Note:
//
//You may assume that the matrix does not change.
//There are many calls to sumRegion function.
//You may assume that row1 ≤ row2 and col1 ≤ col2.
public class Solution418 {

    public static int wordsTyping(String[] sentence, int rows, int cols) {
        int i=0;
        int n=sentence.length;
        int[] len=new int[sentence.length];
        for(String s:sentence) {
            if(s.length()>cols) {
                return 0;
            }
            len[i++] = s.length();
        }
        int res=0;
        for(i=0; i<rows; i++) {
            int curr=res%n;
            int leng = len[curr];
            while(leng + 1 + len[(res+1)%n] <= cols) {
                leng += 1 + len[(res+1)%n];
                res++;
            }
            res++;
        }
        return res/sentence.length;
    }
    
	public static void main(String[] args) {
		String[] ss = new String[] {"a"};
		System.out.println(wordsTyping(ss, 20000, 20000));

	}
}
