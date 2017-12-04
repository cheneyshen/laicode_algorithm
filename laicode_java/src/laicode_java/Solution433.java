package laicode_java;

import java.util.*;

//Generalized Abbreviation
//Write a function to generate the generalized abbreviations of a word.
//
//Example:
//
//Given word = "word", return the following list (order does not matter):
//
//["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", 
//"w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", 
//"2r1", "3d", "w3", "4"]

public class Solution433 {
	public List<String> generateAbbreviations(String word) {
		List<String> res = new ArrayList<String>();
		dfs(0, word.toCharArray(), new StringBuffer(), 0, res);
		return res;
	}
	
	public void dfs(int pos, char[] word, StringBuffer sb, int count, List<String> res) {
		int len = word.length;
		int sbSize = sb.length();
		if(pos == len) {
			if(count>0) {
				sb.append(count);
			}
			res.add(sb.toString());
		} else {
			//choose to abbr word[pos]
			dfs(pos+1, word, sb, count+1, res);

			//choose not to abbr word[pos]
			//first append previous count to sb if count>0
			if(count>0) {
				sb.append(count);
			}
			sb.append(word[pos]);
			dfs(pos+1, word, sb, 0, res);
		}
		sb.setLength(sbSize);
	}
	
	public static void main(String[] args) {


	}
}
