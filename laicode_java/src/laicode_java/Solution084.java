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
		if(s.length()<=1) {
			return s;
		}
		int i, j=s.length()-1;
		char [] array = s.toCharArray();
		for(i=0; i<=j; i++, j--) {
			swap(array, i, j);
		}
		for(i=0; i<array.length; ) {
			while(i<array.length && array[i]==' ') {
				i++;
			}
			j=i;
			while(j<array.length && array[j] != ' ') {
				j++;
			}
			for(int m=i, n=j-1; m<n; m++, n--) {
				swap(array, m, n);
			}
			i=j;
		}
		return String.valueOf(array);
	}
	private void swap(char[] s, int i, int j) {
		char tmp = s[i];
		s[i]=s[j];
		s[j]=tmp;
	}
	public static void main(String[] args) {
		Solution084 ss = new Solution084();
		System.out.println(ss.reverseWords("   I love Google "));
	}
}
