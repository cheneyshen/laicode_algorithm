package laicode_java;

import java.util.*;

//Largest Product Of Length
//Given a dictionary containing many words, find the largest product of two words鈥� lengths, such that the two words do not share any common characters.
//  
//  Assumptions
//  The words only contains characters of 'a' to 'z'
//  The dictionary is not null and does not contains null string, and has at least two strings
//  If there is no such pair of words, just return 0
//  Examples
//  dictionary = [“abcde”, “abcd”, “ade”, “xy”], the largest product is 5 * 2 = 10 (by choosing “abcde” and “xy”)
public class Solution191 {
	public int largestProduct(String[] dict) {
		Map<String, Integer> bitMasks = getBitMasks(dict);
		Arrays.sort(dict, new Comparator<String>() {
			@Override
			public int compare(String s0, String s1) {
				return s1.length()-s0.length();
			}
		});
		int largest = 0;
		for(int i=1; i<dict.length; i++) {
			for(int j=0; j<i; j++) {
				int prod = dict[i].length() * dict[j].length();
				if(prod<=largest) {
					break;
				}
				int ibits = bitMasks.get(dict[i]);
				int jbits = bitMasks.get(dict[j]);
				if((ibits & jbits) == 0) {
					largest = prod;
				}
			}
		}
		return largest;
	}
	
	Map<String, Integer> getBitMasks(String[] dict) {
		Map<String, Integer> map = new HashMap<>();
		for(String str:dict) {
			int bits = 0;
			for(int i=0; i<str.length(); i++) {
				bits |= 1 <<(str.charAt(i)-'0');
			}
			map.put(str, bits);
		}
		return map;
	}
	
	public static void main(String[] args) {
		Solution191 ss = new Solution191();
		String[] dict = new String[]{"abcde", "abcd", "ade", "xy"};
		int result;
		result = ss.largestProduct(dict);
		System.out.println(result);
	}
}
