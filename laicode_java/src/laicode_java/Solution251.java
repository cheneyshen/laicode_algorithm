package laicode_java;

import java.util.*;

//ZigZag Conversion
//The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility).
/*	PAYPALISHIRING
 * 	P   I  N
 *  A  LS IG
 *  Y A HR
 *  P   I
 */
//And then read line by line: "PAHNAPLSIIGYIR". Write the code that will take a string and make this conversion given a number of rows. convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
public class Solution251 {
	public String zigzagConvert(String s, int numRows) {
		if(s==null || s.length()<numRows) {
			return s;
		}
		String[] array = new String[numRows];
		Arrays.fill(array, "");
		int[] index = new int[numRows];
		Arrays.fill(index, 0);
		int i=0;	//i is string s char index
		int j=0;	//j is the string move around index, from 0 to numRows-1 then back to 0
		boolean down=true;
		while(i<s.length()) {
			//go down
			if(down) {
				array[j] += s.charAt(i);
			} 
			//come up
			else {
				//if not top and bottom row, append white space
				if(i%(numRows-1)!=0) {
					for(int k=0; k<numRows; k++) {
						if(k!=j) {
							array[k]+=" ";
						}
					}
		 		}
				array[j] += s.charAt(i); 
			}
			//direction switch 
			if(i>0 && i%(numRows-1)==0) {
				down=!down;
			}
			if(down) {
				j++;	//come down
			} else {
				j--;	//go up
			}
			i++;	//move to next char
		}
		for(int x=0; x<numRows; x++) {
			System.out.println(array[x]);
		}
		return " ";
	}
	
	public String convert(String s , int numRows) {
		if(numRows==1) {
			return s;
		}
		String[] rows = new String[numRows];
		Arrays.fill(rows, "");
		int i=0, j, gap = numRows-2;
		while(i<s.length()) {
			for(j=0; j<numRows && i<s.length(); j++) {
				rows[j++] += s.charAt(i++);
			}
			for(j=gap; j>=0 && i<s.length(); j--) {
				rows[j--] += s.charAt(i++);
			}
		}
		for(int x=0; x<numRows; x++) {
			System.out.println(rows[x]);
		}
		return " ";
	}
	public static void main(String[] args) {
		Solution251 ss = new Solution251();
		ss.zigzagConvert("PAYPALISHIRING", 3);
		ss.convert("PAYPALISHIRING", 3);
	}
}
