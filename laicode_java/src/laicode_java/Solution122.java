package laicode_java;
import java.util.*;

//Median Of Two Sorted Arrays
public class Solution122 {
  public double median(int[] a, int[] b) {
    int m=a.length, n=b.length;
    int total=m+n;
    if(total%2!=0) {
    	return findKth(a, 0, b, 0, total/2+1);
    }
    else {
    	return (findKth(a, 0, b, 0, total/2) + 
    			findKth(a, 0, b, 0, total/2+1))/2.0;
    }
  }
  
  private double findKth(int[] a, int m, int[] b, int n, int k) {
	  if(m>=a.length) {
		  return b[n+k-1];
	  }
	  if(n>=b.length) {
		  return a[m+k-1];
	  }
	  if(k==1) {
		  return Math.min(a[m], b[n]);
	  }
	  int ap=m+k/2-1>=a.length?Integer.MAX_VALUE:a[m+k/2-1];
	  int bp=n+k/2-1>=b.length?Integer.MIN_VALUE:b[n+k/2-1];
	  if(ap<bp) {
		  return findKth(a, m+k/2, b, n, k-k/2);
	  }
	  else {
		  return findKth(a, m, b, n+k/2, k-k/2);
	  }
  }
  
  public static void main(String[] args) {
	  int[] a={1, 4, 6};
	  int[] b={2,3};
	  Solution122 s122 = new Solution122();
	  double result=s122.median(a, b);
	  System.out.println(result);
  }
}