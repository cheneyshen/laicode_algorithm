package laicode_java;
import java.util.*;

//Interleave Strings
public class Solution120 {
  public boolean canMerge(String a, String b, String c) {
	int asize=a.length();
	int bsize=b.length();
	int csize=c.length();
	if(asize+bsize!=csize) {
		return false;
	}
	boolean[][] interleaved=new boolean[asize+1][bsize+1];
	interleaved[0][0]=true;
	for(int i=1;i<=asize;i++) {
		if(c.charAt(i-1)==a.charAt(i-1) && interleaved[i-1][0]) {
			interleaved[i][0]=true;
		}
	}
	for(int i=1;i<=bsize;i++) {
		if(c.charAt(i-1)==b.charAt(i-1) && interleaved[0][i-1]) {
			interleaved[0][i]=true;
		}
	}
	for(int i=1;i<=asize;i++) {
		for(int j=1;j<=bsize;j++) {
			if((c.charAt(i+j-1)==a.charAt(i-1) && interleaved[i-1][j]) || 
			(c.charAt(i+j-1)==b.charAt(j-1) && interleaved[i][j-1])) {
				interleaved[i][j]=true;
			}
		}
	}
//	for(int i=0;i<=asize;i++) {
//		for(int j=0;j<=bsize;j++) {
//			if(interleaved[i][j]) {
//				System.out.print(1+" ");
//			}
//			else {
//
//				System.out.print(0+" ");
//			}
//		}
//		System.out.println();
//	}
	return interleaved[asize][bsize];
  }
  
  public static void main(String[] args) {

	  Solution120 s120 = new Solution120();
	  boolean result=s120.canMerge("a", "b", "ba");
	  System.out.println(result);
	  result=s120.canMerge("ab", "ac", "acab");
	  System.out.println(result);
  }
}