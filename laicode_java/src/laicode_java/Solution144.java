package laicode_java;

//All Unique Characters I
//Determine if the characters of a given string are all unique.
//
//Assumptions
//
//The only set of possible characters used in the string are 'a' - 'z', the 26 lower case letters.
//The given string is not null.
//Examples
//
//the characters used in "abcd" are unique
//the characters used in "aba" are not unique

public class Solution144 {
	public boolean allUnique(String word) {
		char[] array=word.toCharArray();
		int[] dict=new int[8];
		for(int i=0;i<array.length;i++) {
			int aa=array[i]%32;
			int bb=array[i]/32;
			if((dict[bb] & (1 << aa)) > 0) {
				return false;
			}
			dict[bb]|=1<<aa;
		}
		return true;
	}
	
	public static void main(String[] args) {
		Solution144 s144=new Solution144();
		boolean result=s144.allUnique("abcd");
		System.out.println(result);
		result=s144.allUnique("aba");
		System.out.println(result);
		result=s144.allUnique("bcdkowa");
		System.out.println(result);
	}
}