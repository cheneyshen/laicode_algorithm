package laicode_java;

import java.util.*;
public class Solution506 {
	public List<String> solution(int start, int length) {
		List<String> result = new ArrayList<>();
		if(start<0 || start>9) {
			return result;
		}
		String[] array = new String[]{"8", "24", "135", "26", "157", "2468", "359", "48", "5790", "68"};
		StringBuilder combo = new StringBuilder();
		combo.append(start);
		length = length-1;
		helper(start, length, combo, array, result);
		return result;
	}
	
	public void helper(int start, int length, StringBuilder combo, String[] dict, List<String> result) {
		if(length==0) {
			result.add(combo.toString());
			return;
		}
		for(int i=0; i<dict[start].length(); i++) {
			char cur = dict[start].charAt(i);
			combo.append(cur);
			helper((int)(cur-'0'), length-1, combo, dict, result);
			combo.deleteCharAt(combo.length()-1);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution506 solution = new Solution506();
		List<String> result = solution.solution(5, 1);
		System.out.println(result);
		result = solution.solution(1, 3);
		System.out.println(result);
		result = solution.solution(0, 0);
		System.out.println(result);
	}
}
