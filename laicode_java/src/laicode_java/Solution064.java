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

	public List<String> permutations(String input) {
		List<String> res = new ArrayList<>();
		if(input==null) {
			return res;
		}
    	char[] array = input.toCharArray();
		helper(array, 0, res);
		return res;
	}
	
	private void helper(char[] array, int index, List<String> result) {
		if(index==array.length) {
			result.add(new String(array));
			return;
		}
		for(int i=index; i<array.length; i++) {
			swap(array, index, i);
			helper(array, index+1, result);
			swap(array, index, i);
		}
	}
	
	private void swap(char[] input, int i, int j) {
		char temp = input[i];
		input[i] = input[j];
		input[j] = temp;
	}
	
	public static void main(String[] args) {


	}
}
