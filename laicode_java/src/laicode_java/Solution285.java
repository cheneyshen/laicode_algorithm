package laicode_java;

import java.util.*;

/*Longest Substring With K Typed Characters
	Given a string, return the longest contiguous substring that contains exactly k type of characters.
	Return null if there does not exist such substring.
	Assumptions:
The given string is not null.
	k >= 0.
	Examples :
	input = "aabcc", k = 3, output = "aabcc".
	input = "aabcccc", k = 2, output = "bcccc".*/
public class Solution285 {
	static class Node {
		int first;
		int last;
		Node(int first, int last) {
			this.first=first;
			this.last=last;
		}
	}
	public String longestKChars(String input, int k) {
		if(k<1) {
			return "";
		}
		String temp='.'+input;
		List<Node> occurs = new ArrayList<>();
		String result="";
		int longest=Integer.MIN_VALUE;
		for(int i=0; i<temp.length(); i++) {
			if(occurs.isEmpty() || temp.charAt(occurs.get(occurs.size()-1).first)!=temp.charAt(i)) {
				Node curr = new Node(i, i);
				occurs.add(curr);
			} else {
				Node curr = occurs.get(occurs.size()-1);
				occurs.remove(occurs.size()-1);
				curr.last=i;
				occurs.add(curr);
			}
			if(occurs.size()>k) {
				int last1 = occurs.get(occurs.size()-1).last;
				int last2 = occurs.get(occurs.size()-k-1).last;
				if(last1-last2 > longest) {
					longest = last1-last2;
					result = temp.substring(last2+1, last1+1);
				}
			}
		}
		return result;
	}
	public static void main(String[] args) {
		Solution285 ss = new Solution285();
		System.out.println(ss.longestKChars("aabcc", 5));
		System.out.println(ss.longestKChars("aabcc", 3));
		System.out.println(ss.longestKChars("aabcccc", 2));
	}
}
