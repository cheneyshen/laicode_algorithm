package laicode_java;

import java.util.*;

//Number Of Words
//Given a string, count number of words in it. The delimiters can be the following characters: space (‘ ‘) or new line (‘\n’) or tab (‘\t’) or a combination/duplication of these.
//
//Assumptions:
//The given string is not null.
//Examples:
//"I love \t\n google", there are 3 words in it.
public class Solution282 {

	public int numOfWords(String input) {
		String result="";
		int fast=0;
		int count=0;
		for(; fast<input.length(); ) {
			while(input.charAt(fast)==' ' ||input.charAt(fast)=='\n' || input.charAt(fast)=='\t') {
				fast++;
			}
			if(fast<input.length() && input.charAt(fast)!=' ' && input.charAt(fast)!='\n' && input.charAt(fast)!='\t') {
				count++;
				while(fast<input.length() && input.charAt(fast)!=' ' && input.charAt(fast)!='\n' && input.charAt(fast)!='\t') {
					result+=input.charAt(fast++);
				}
			}
			while(fast<input.length() && (input.charAt(fast)==' '||input.charAt(fast)=='\n' || input.charAt(fast)=='\t')) {
				fast++;
			}
			result+=' ';
		}
		return count;
	}
	public static void main(String[] args) {
		Solution282 ss = new Solution282();
		String input = "I love \t\n google";
		System.out.println(ss.numOfWords(input));
	}
}
