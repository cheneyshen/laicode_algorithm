package laicode_java;

import java.util.*;

/*String Frequency In Windows
	Given a string containing only 'A', 'B', 'C', 'D', return the number of occurrences of substring which has length 4 and includes all of the characters from 'A', 'B', 'C', 'D' with in descending sorted order.
	Assumptions:
The given string is not null and has length of >= 4.
	In the output, if two substrings have the same frequency, then they should be sorted by the their natural order.
	Examples :
	“ABCDABCDD”, --> {"ABCD" : 2, "BCDA" : 1, "CDAB" : 1, "DABC" : 1}*/
public class Solution289 {
	public void frequencySort(String s) {
        if (s==null || s.length()<4) {
        	return;
        }
        HashMap<String, Integer> dict = new HashMap<>();
        for(int i=0; i<s.length()-4; i++) {
        	String curr = s.substring(i, i+4);
        	System.out.println(curr);
        	if (dict.containsKey(curr)==false) {
        		dict.put(curr, 1);
        	} else {
        		dict.put(curr, dict.get(curr)+1);
        	}
        }
        System.out.println(dict.get("ABCD"));
        System.out.println(dict.get("BCDA"));
        System.out.println(dict.get("CDAB"));
        System.out.println(dict.get("DABC"));
    }
	public static void main(String[] args) {
		Solution289 ss = new Solution289();
		ss.frequencySort("ABCDABCDD");
	}
}
