package laicode_java;

import java.util.*;

//All Subsets I
//Given a set of characters represented by a String, return a list containing all subsets of the characters.
//
//Assumptions
//
//There are no duplicate characters in the original set.
//​Examples
//
//Set = "abc", all the subsets are [“”, “a”, “ab”, “abc”, “ac”, “b”, “bc”, “c”]
//Set = "", all the subsets are [""]
//Set = null, all the subsets are []
public class Solution062 {

	void helper(char[] set, StringBuilder sb, int index, List<String> result) {
		if(index==set.length) {
			result.add(sb.toString());
			return;
		}
		helper(set, sb, index+1, result);
		helper(set, sb.append(set[index]), index+1, result);
		sb.deleteCharAt(sb.length()-1);
	}
	
	List<String> subsets(String set) {
		List<String> result=new ArrayList<String>();
		if(set==null) {
			return result;
		}
		char[] arraySet = set.toCharArray();
		StringBuilder sb= new StringBuilder();
		helper(arraySet, sb, 0, result);
		return result;
	}
	
	
	public static void main(String[] args) {


	}
}
