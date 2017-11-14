package laicode_java;

import java.util.*;

//Shortest Word Distance
//Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.
//
//For example,
//Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
//
//Given word1 = “coding”, word2 = “practice”, return 3.
//Given word1 = "makes", word2 = "coding", return 1.
//
//Note:
//You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
public class Solution477 {
	public int shortestDistance(String[] words, String word1, String word2) {
		int m=-1, n=-1;
		int min = Integer.MAX_VALUE;
		
		for(int i=0; i<words.length; i++) {
			String s = words[i];
			if(word1.equals(s)) {
				m=i;
				if(n!=-1) {
					min = Math.min(min,  m-n);
				}
			} else if(word2.equals(s)) {
				n=i;
				if(m!=-1) {
					min = Math.min(min, n-m);
				}
			}
		}
		return min;
	}
	
	public static void main(String[] args) {


	}
}
