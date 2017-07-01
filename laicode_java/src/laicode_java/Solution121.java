package laicode_java;
import java.util.*;

//Longest Palindromic Substring
public class Solution121 {
	public String longestPalindrome(String s) {
		char[] array=s.toCharArray();
		int leng=array.length;
		int dist=0;
		String result="";
		if(leng==0) {
			return s;
		}
		boolean[][] isP=new boolean[leng+1][leng+1];
		int[] minCuts=new int[leng+1];
		for(int end=1;end<=leng;end++) {
			minCuts[end]=end;
			for(int start=end;start>=1;start--) {
				if(array[start-1]==array[end-1]) {
					isP[start][end]=end-start<2||isP[start+1][end-1];
				}
				if(isP[start][end] && end-start>=dist) {
					result=s.substring(start-1, end);
					dist=end-start;
				}
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		Solution121 s121 = new Solution121();
		String result=s121.longestPalindrome("abacbbcabcb");
		System.out.println(result);
		result=s121.longestPalindrome("a");
		System.out.println(result);
	}
}