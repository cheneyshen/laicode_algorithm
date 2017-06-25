package laicode_java;
import java.util.*;

//Longest common substring
public class Solution123 {
	public String longestCommon(String s, String t){
		char[] sa=s.toCharArray();
		char[] ta=t.toCharArray();
		int start=0;
		int longest=0;
		int[][] common=new int[sa.length][ta.length];
		for(int i=0;i<sa.length;i++) {
			for(int j=0;j<ta.length;j++) {
				if(sa[i]==ta[j]) {
					if(i==0 || j==0) {
						common[i][j]=1;	
					}
					else {
						common[i][j]=common[i-1][j-1]+1;
					}
					longest=Math.max(longest, common[i][j]);
					start=i-longest+1;
				}
			}
		}
		return s.substring(start, start+longest); 
	}
	
	public static void main(String[] args) {
		Solution123 s123 = new Solution123();
		String result=s123.longestCommon("abcde", "cdt");
		System.out.println(result);
	}
}