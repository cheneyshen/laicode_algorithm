package laicode_java;

import java.util.*;

public class Solution063 {

    //    All Subsets II
    //    Given a set of characters represented by a String, return a list containing all subsets of the characters.
    //
    //    Assumptions
    //
    //    There could be duplicate characters in the original set.
	//​Examples
	//	Set = "abc", all the subsets are["", "a", "ab", "abc", "ac", "b", "bc", "c"]
	//	Set = "abb", all the subsets are["", "a", "ab", "abb", "b", "bb"]
	//	Set = "", all the subsets are[""]
	//	Set = null, all the subsets are[]

    List<String> subSets(String set) {
    	List<String> result=new ArrayList<String>();
    	if(set==null) {
    		return result;
    	}
    	char[] arraySet=set.toCharArray();
    	Arrays.sort(arraySet);
    	StringBuilder sb=new StringBuilder();
    	helper(arraySet, sb, 0, result);
    	return result;
    }
    
    void helper(char[] set, StringBuilder sb, int index, List<String> result) {
    	if(index==set.length) {
    		result.add(sb.toString());
    		return;
    	}
    	helper(set, sb.append(set[index]), index+1, result);
    	while(index<set.length-1 && set[index]==set[index+1]) {
    		index++;
    	}
    	sb.deleteCharAt(sb.length()-1);
    	helper(set, sb, index+1, result);
    }
    
    List<String> subsetII(String set) {
    	List<String> result=new ArrayList<String>();
    	if(set==null) {
    		return result;
    	}
    	char[] arraySet=set.toCharArray();
    	Arrays.sort(arraySet);
    	StringBuilder sb=new StringBuilder();
    	helperII(arraySet, sb, 0, result);
    	return result;
    }
    
    void helperII(char[] set, StringBuilder sb, int index, List<String> result) {
    	result.add(sb.toString());
    	for(int i=index; i<set.length; i++) {
    		if(i==index || set[i]!=set[i-1]) {
    			sb.append(set[i]);
    			helperII(set, sb, i+1, result);
    			sb.deleteCharAt(sb.length()-1);
    		}
    	}
    }
    
	public static void main(String[] args) {
		Solution063 solution = new Solution063();
		String input = "abb";
		List<String> result = solution.subSets(input);
		System.out.println(result);
		result = solution.subsetII(input);
		System.out.println(result);

	}
}
