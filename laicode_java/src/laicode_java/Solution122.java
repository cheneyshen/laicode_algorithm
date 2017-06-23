package laicode_java;
import java.util.*;

//Median Of Two Sorted Arrays
public class Solution122 {
  public double median(int[] a, int[] b) {
    int m=a.length, n=b.length;
    int total=m+n;
    if(total%2!=0) {
    	return findKth(a, m, b, n, total/2+1);
    }
    else {
    	return (findKth(a, m, b, n, total/2) + 
    			findKth(a, m, b, n, total/2+1))/2.0;
    }
  }
  
  private double findKth(int[] a, int m, int[] b, int n, int k) {
	  if(m>n) {
		  return findKth(b, n, a, m, k);
	  }
	  if(m==0) {
		  return b[k-1];
	  }
	  if(k==1) {
		  return Math.min(a[0], b[0]);
	  }
	  int p1=Math.min(k/2, m), p2=k-p1;
	  if(a[p1-1]<b[p2-1]) {
		  int[] newa=new int[m-p1];
		  System.arraycopy(a, p1, newa, 0, m-p1);
		  return findKth(newa, m-p1, b, n, k-p1);
	  }
	  else if(a[p1-1]>b[p2-1]) {
		  int[] newb=new int[n-p2];
		  System.arraycopy(b, p2, newb, 0, n-p2);
		  return findKth(a, m, newb, n-p2, k-p2);
	  }
	  else {
		  return a[p1-1];
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