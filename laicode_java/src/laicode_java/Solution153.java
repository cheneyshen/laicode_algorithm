package laicode_java;

//Buy Stock IV
//Given an array of integers representing a stock¡¯s price on each day. On each day you can only make one operation: either buy or sell one unit of stock, and at any time you can only hold at most one unit of stock, and you can make at most K transactions in total. Determine the maximum profit you can make.
//
//Assumptions
//
//The give array is not null and is length of at least 2
//Examples
//
//{2, 3, 2, 1, 4, 5, 2, 11}, K = 3, the maximum profit you can make is (3 - 2) + (5 - 1) + (11 - 2)= 14

public class Solution153 {
  public int maxProfit(int[] array, int k) {
	  int leng=array.length;
	  if(leng<=1) {
		  return 0;
	  }
	  if(k<1) {
		  return 0;
	  }
	  int[][] matrix=new int[k+1][leng];
	  int result=0;
	  for(int kk=1;kk<=k;kk++) {
		  int temp=matrix[kk-1][0]-array[0];
		  for(int ii=1;ii<leng;ii++) {
			  matrix[kk][ii]=Math.max(matrix[kk][ii-1], array[ii]+temp);
			  temp=Math.max(temp, matrix[kk-1][ii]-array[ii]);
			  result=Math.max(result, matrix[kk][ii]);
		  }
	  }
	  return result;
  }
  
  public static void main(String[] args) {
	  Solution153 s153=new Solution153();
	  int[] array=new int[]{2, 3, 2, 1, 4, 5, 2, 11};
	  System.out.println(s153.maxProfit(array, 3));
  }
}