package laicode_java;

import java.util.*;

//Shortest Word Distance III
//This is a follow up of Shortest Word Distance. The only difference is now word1 could be the same as word2.
//
//Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.
//
//word1 and word2 may be the same and they represent two individual words in the list.
//
//For example,
//Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
//
//Given word1 = “makes”, word2 = “coding”, return 1.
//Given word1 = "makes", word2 = "makes", return 3.
//
//Note:
//You may assume word1 and word2 are both in the list.
public class Solution478 {
	public int shortestWordDistance(String[] words, String word1, String word2) {
		if(words==null || words.length<1 || word1==null || word2==null) {
			return -1;
		}
		boolean isSame = false;
		if(word1.equals(word2)) {
			isSame = true;
		}
		int shortest = Integer.MAX_VALUE;
		int prev = -1;
		int i1=-1, i2=-1;
		for(int i=0; i<words.length; i++) {
			if(isSame) {
				if(words[i].equals(word1)) {
					if(prev!=-1) {
						shortest = Math.min(shortest, i-prev);
					}
					prev = i;
				}
			} else {
				if(word1.equals(words[i])) {
					i1=i;
					if(i2!=-1) {
						shortest = Math.min(shortest, i-i2);
					}
				} else if (word2.equals(words[i])) {
					i2=i;
					if(i1!=-1) {
						shortest = Math.min(shortest, i-i1);
					}
				}
			}
		}
		return shortest;
	}
	
	public static void main(String[] args) {


	}
}
