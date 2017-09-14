package laicode_java;

import java.util.*;

//All Permutations I
//Given a string with no duplicate characters, return a list with all permutations of the characters.
//
//Examples
//
//Set = “abc”, all permutations are [“abc”, “acb”, “bac”, “bca”, “cab”, “cba”]
//Set = "", all permutations are [""]
//Set = null, all permutations are []
public class Solution064 {

	List<String> solve(String input) {
		List<String> result=new ArrayList<String>();
		if (input == "") {
			result.add("");
			return result;
		}
    	char[] arraySet=input.toCharArray();
    	Arrays.sort(arraySet);
		helper(arraySet, 0, result);
		return result;
	}
	
	void helper(char[] arraySet, int index, List<String> result) {
		if(index==arraySet.length) {
			result.add(new String(arraySet));
			return;
		}
		for(int i=index; i<arraySet.length; i++) {
			swap(arraySet, index, i);
			helper(arraySet, index+1, result);
			swap(arraySet, index, i);
		}
	}
	
	void swap(char[] input, int index, int i) {
		char temp=input[index];
		input[index]=input[i];
		input[i]=temp;
	}
	
	public static void main(String[] args) {


	}
}
