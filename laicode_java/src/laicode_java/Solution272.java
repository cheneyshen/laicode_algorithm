package laicode_java;

import java.util.*;

//Combinations For Telephone Pad I
//Given a telephone keypad, and an int number, print all words which are possible by pressing these numbers, the output strings should be sorted.
//{0 : "", 1 : "", 2 : "abc", 3 : "def", 4 : "ghi", 5 : "jkl", 6 : "mno", 7 : "pqrs", 8 : "tuv", 9 : "wxyz"}
//Assumptions:
//The given number >= 0
//Examples:
//if input number is 231, possible words which can be formed are:
//  [ad, ae, af, bd, be, bf, cd, ce, cf]
public class Solution272 {
	public List<String> letterCombinations(String digits) {
//					 {}
//		2			 {"a" "b" "c"}
//		3	 {"ad","ae","af" "bd","be","bf", "cd","ce", "cf"}
//		1	 {"ad","ae","af" "bd","be","bf", "cd","ce", "cf"}
		HashMap<Integer, String> dict = new HashMap<>();
		dict.put(0, "");
		dict.put(1, "");
		dict.put(2, "abc");
		dict.put(3, "def");
		dict.put(4, "ghi");
		dict.put(5, "jkl");
		dict.put(6, "mno");
		dict.put(7, "pqrs");
		dict.put(8, "tuv");
		dict.put(9, "wxyz");
		List<String> result=new ArrayList<>();
		result.add("");	//!!!
		if(digits==null || digits.length()<1) {
			return result;
		}
		
		return dfsHelper(digits, 0, dict, result);
	}
	
	public List<String> dfsHelper(String digits, int i, HashMap<Integer, String> dict, List<String> result) {
		if(i==digits.length()) {
			return result;
		}
		List<String> newResult = new ArrayList<>();
		for(int j=0; j<result.size(); j++) {
			String curr = result.get(j);
			String pending = dict.get(digits.charAt(i)-'0');
			// Need take action for empty string
			if(pending==null || pending.length()<1) {
				newResult.add(curr);
			}
			else {
				for(int k=0; k<pending.length(); k++) {
					curr += pending.charAt(k);
					newResult.add(curr);
					curr = curr.substring(0, curr.length() - 1);
				}
			}
		}
		return dfsHelper(digits, i+1, dict, newResult);
	}
	
	public List<Integer> closetKValues(TreeNode root, double target, int k) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		helper(list, root, target, k);
		return list;
	}
	
	private boolean helper(LinkedList<Integer> list, TreeNode root, double target, int k) {
		if(root==null) {
			return false;
		}
		if(helper(list, root.left, target, k)) {
			return true;
		}
		if(list.size()==k) {
			if(Math.abs(list.getFirst() - target) < Math.abs(root.key - target)) {
				return true;
			} else {
				list.removeFirst();
			}
		}
		list.addLast(root.key);
		return helper(list, root.right, target, k);
	}
	
	public static void main(String[] args) {
		Solution272 ss = new Solution272();
		List<String> result = new ArrayList<>();
		result = ss.letterCombinations("");
		System.out.println(result);
		result = ss.letterCombinations("1");
		System.out.println(result);
		result = ss.letterCombinations("2");
		System.out.println(result);
		result = ss.letterCombinations("3");
		System.out.println(result);
		result = ss.letterCombinations("231");
		System.out.println(result);
		result = ss.letterCombinations("112");
		System.out.println(result);
	}
}
