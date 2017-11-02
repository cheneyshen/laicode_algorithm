package laicode_java;

import java.util.*;

//Least Insertions To Form A Palindrome
//Insert the least number of characters to a string in order to make the new string a palindrome. Return the least number of characters should be inserted.
//Assumptions:
//The given string is not null.
public class Solution308 {

	static int findMinInsertions(String str, int l, int h) {
		if (l>h)
		    return Integer.MAX_VALUE;
		if (l==h) {
		    return 0;
        }
        if (l==h-1) {
		    return str.charAt(l)==str.charAt(h)?0:1;
        }
        return (str.charAt(l)==str.charAt(l))?
                findMinInsertions(str, l+1, h-1) : (
                        Integer.min(findMinInsertions(str, l, h-1),
                                findMinInsertions(str, l+1, h))+1
                );
	}

	public static void main(String[] args) {

        Solution308 ss = new Solution308();
        String str = "javaj";
        System.out.println("Least Insertions is "+ ss.findMinInsertions(str, 0, str.length()-1));

	}
}
