package laicode_java;

import java.util.*;

//    Reverse Words In A Sentence I
//    Reverse the words in a sentence.
//
//    Assumptions
//
//    Words are separated by single space
//
//    There are no heading or tailing white spaces
//
//    Examples
//
//    “I love Google” → “Google love I”
//
//    Corner Cases
//
//    If the given string is null, we do not need to do anything.
public class Solution084 {
	public String reverseWords(String s) {
		if(s==null || s.length()<1) {
			return s;
		}
		s = s.trim();
		if(s.length()<1) {
			return s;
		}
		char [] array = s.toCharArray();
		reverse(array, 0, array.length-1);
		int end = 0;
		for(int start = 0; start<array.length; ) {
			int fast = start;
			// 
			while(fast<array.length && array[fast] != ' ') {
				fast++;
			}
			reverse(array, start, fast-1);	//Google
			while(start != fast) {
				// copy char from start pointer to end pointer
				// otherwise result will be empty
				array[end++] = array[start++];
			}
			// fast pointer move forward, skip spaces
			while(fast<array.length && array[fast]==' ') {
				fast++;
			}
			// add a single space
			if(fast<array.length) {
				array[end++] = ' ';
			}
			// assign fast to start
			start = fast;
		}
		return new String(array, 0, end);
	}
	
	private void reverse(char[] array, int left, int right) {
		while(left<right) {
			char tmp = array[left];
			array[left] = array[right];
			array[right] = tmp;
			left++; right--;
		}
	}
	
	public static void main(String[] args) {
		Solution084 ss = new Solution084();
		System.out.println(ss.reverseWords("   I love Google "));
	}
}
