package laicode_java;

import java.util.*;

//Strobogrammatic Number
//A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
//
//Write a function to determine if a number is strobogrammatic. The number is represented as a string.
//
//For example, the numbers "69", "88", and "818" are all strobogrammatic.
//

public class Solution479 {
	public boolean isStrobogrammatic(String num) {
		HashMap<Character, Character> map = new HashMap<>();
		map.put('0', '0');
		map.put('1', '1');
		map.put('6', '9');
		map.put('8', '8');
		map.put('9', '6');
		for (int i=0; i<=num.length()/2; i++) {
			if(map.get(num.charAt(i)) != num.charAt(num.length() - i - 1)) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {


	}
}
