package laicode;

import java.util.*;

//    All Permutations II
//    Given a string with possible duplicate characters, return a list with all permutations of the characters.
//
//    Examples
//
//    Set = “abc”, all permutations are [“abc”, “acb”, “bac”, “bca”, “cab”, “cba”]
//    Set = "aba", all permutations are ["aab", "aba", "baa"]
//    Set = "", all permutations are [""]
//    Set = null, all permutations are []
public class Solution065 {
	List<String> permutations(String set) {
		List<String> result=new ArrayList<String>();
		if(set==null) {
			return result;
		}
		char[] array=set.toCharArray();
		helper(array, 0, result);
		return result;
	}
	
	void helper(char[] array, int index, List<String> result) {
		if(index==array.length) {
			result.add(new String(array));
			return;
		}
		Set<Character> used=new HashSet<Character>();
		for(int i=index; i<array.length; i++) {
			if(used.add(array[i])) {
				swap(array, i, index);
				helper(array, index+1, result);
				swap(array, i, index);
			}
		}
	}
	
	void swap(char[] array, int left, int right) {
		char temp=array[left];
		array[left]=array[right];
		array[right]=temp;
	}
	
	public static void main(String[] args) {
		Solution065 ss=new Solution065();
		List<String> result=ss.permutations("abc");
		System.out.println(result);
	}
}
