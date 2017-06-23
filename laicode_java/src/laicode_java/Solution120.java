package laicode_java;
import java.util.*;

//Interleave Strings
public class Solution120 {
  public boolean canMerge(String a, String b, String c) {
	int asize=a.length();
	int bsize=b.length();
	int csize=c.length();
	int bj=0, ck=0;
	char[] alist=a.toCharArray();
	char[] blist=b.toCharArray();
	char[] clist=c.toCharArray();
	for(int i=0;i<asize;) {
		if(bj<bsize && alist[i]==blist[bj]) {
			i++;
			bj++;
		}
		else if(ck<csize && alist[i]==clist[ck]) {
			i++;
			ck++;
		}
		else {
			return false;
		}
	}
    if(bj==bsize && ck==csize) {
    	return true;
    }
    else {
    	return false;
    }
  }
  
  public static void main(String[] args) {

	  Solution120 s120 = new Solution120();
	  String A="abcde";
	  String B="acd";
	  String C="be";
	  B="adc";
	  boolean result=s120.canMerge(A, B, C);
	  System.out.println(result);
	  result=s120.canMerge("XXZXXXY", "XXY", "XXZ");
	  System.out.println(result);
	  result=s120.canMerge("XXXXXX", "XXX", "XXX");
	  System.out.println(result);
	  result=s120.canMerge("WZXY","XY" ,"WZ" );
	  System.out.println(result);
	  result=s120.canMerge("XXY", "XY", "X");
	  System.out.println(result);
	  result=s120.canMerge("XXY", "YX", "X");
	  System.out.println(result);
	  result=s120.canMerge("XXXXZY", "XXY", "XXZ");
	  System.out.println(result);
  }
}