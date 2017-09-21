package laicode_java;

import java.util.*;

//Text Justification
//Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.
//
//Input: words: ["This", "is", "an", "example", "of", "text", "justification."]    L: 16.
//Output:[
//"This    is    an",
//"example  of text",
//"justification.  "
//]
//Input: words: [¡°This¡±, ¡°is¡±, ¡°my¡±]       L = 5
//Output: [
//¡°This ¡±,
//¡°is my¡±
//]
public class Solution189 {
	public List<String> fullJustify(String[] words, int maxWidth) {
		List<String> result = new ArrayList<String>();
		if(words==null || words.length<1) {
			return null;
		}
		int i=0, n = words.length;
		while(i<n) {
			int leng=words[i].length();
			int j=i+1;
			while(j<n && leng + 1 + words[j].length() <= maxWidth) {
				leng+=1+words[j].length();
				j++;
			}
			String line=words[i];
			if(j==n) {
				for(int k=i+1; k<n; k++) {
					line+=" "+words[k];
				}
				while(line.length()<maxWidth) {
					line+=" ";
				}
			} else {
				int whites = maxWidth-leng;
				int spaces=j-i-1;
				if(spaces==0) {
					while(line.length()<maxWidth) {
						line+=" ";
					}
				} else {
					for(int k=i+1; k<j; k++) {
						line+=" ";
						for(int p=0; p<whites/spaces; p++) {
							line+=" ";
						}
						if(k-i<=whites%spaces) {
							line+=" "; 
						}
						line+=words[k];
					}
				}
			}
			result.add(line);
			i=j;
		}
		return result;
	}
	
	public static void main(String[] args) {
		Solution189 ss = new Solution189();
		String[] words = new String[]{"This", "is", "my"};
		List<String> result = ss.fullJustify(words, 5);
		System.out.println(result);
		words = new String[]{"This", "is", "an", "example", "of", "text", "justification."};
		result = ss.fullJustify(words, 16);
		System.out.println(result);
	}
}
