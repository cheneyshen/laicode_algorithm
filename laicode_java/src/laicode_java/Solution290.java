package laicode_java;

import java.util.*;

/*Wildcard Matching
	Given two strings where first string is a normal string and second string may contain wild card characters.Write a function that returns true if the two strings match.The following are allowed wildcard characters in first string.
	* --> Matches with 0 or more instances of any character or set of characters.
	? --> Matches with any one character.
	Assumptions:
The two strings are both not null.
	Assume there is no more than one '*' adjacent to each other.
	Examples :
	input = "abc", pattern = "?*", return true.*/
public class Solution290 {
	public boolean dfsMatch(String s, String p) {
		if(p.isEmpty())
			return s.isEmpty();
		char c = p.charAt(0);
		if(p.length()>1 && p.charAt(1)=='*') {
			int k=0;
			do {
				if(dfsMatch(s.substring(k), p.substring(2))) {
					return true;
				}
			} while(k<s.length() && match(s.charAt(k++), c));
			return false;
		}
		return !s.isEmpty() && match(s.charAt(0), c) && dfsMatch(s.substring(1), p.substring(1));
	}
	
	public boolean dfs2(String s, int i, String p, int j) {
		if(j==p.length()) {
			return i==s.length();
		}
		char c = p.charAt(j);
		if (j+1 <p.length() && p.charAt(j+1)=='*') {
			return dfs2(s, i, p, j+2) || (i<s.length() && match(s.charAt(i), c) && dfs2(s, i+1, p, j));
		}
		return i<s.length() && match(s.charAt(i), c) && dfs2(s, i+1, p, j+1);
	}
	
	private boolean match(char c, char p) {
		return p=='.'? true : p==c;
	}
	 
	public static void main(String[] args) {


	}
}
