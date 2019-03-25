package laicode_java;

import java.util.*;

//Isomorphic String I
//Two Strings are called isomorphic if the letters in one String can be remapped to get the second String. Remapping a letter means replacing all occurrences of it with another letter. The ordering of the letters remains unchanged. The mapping is two way and no two letters may map to the same letter, but a letter may map to itself. Determine if two given String are isomorphic.
//  Assumptions:
//  The two given Strings are not null.
//  Examples:
//  "abca" and "xyzx" are isomorphic since the mapping is 'a' <-> 'x', 'b' <-> 'y', 'c' <-> 'z'.
//  "abba" and "cccc" are not isomorphic.
public class Solution342 {
	public boolean isomorphic(String source, String target) {
	    // use two hashset
		// Assume s and t are not null
		// as long as s and t have same length and same kinds of characters
		// s and t will be isomorphic
		if(source == null && target == null) {
			return true;
		}
		if(source==null || target==null) {
			return false;
		}
		int slen=source.length(), tlen=target.length();
		if(slen!=tlen) {
			return false;
		}
		char[] sarray = source.toCharArray();
		char[] tarray = target.toCharArray();
		Set<Character> settt = new HashSet<>();
		Set<Character> setss = new HashSet<>();
		for(int i=0; i<sarray.length; i++) {
			if(!setss.contains(sarray[i])) {
				setss.add(sarray[i]);
			}
			if(!settt.contains(tarray[i])) {
				settt.add(tarray[i]);
			}
		}
		return settt.size() == setss.size();
	}

	public static void main(String[] args) {


	}
}
