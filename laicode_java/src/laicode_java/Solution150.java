package laicode_java;

//Buy Stock I
//Given an array of positive integers representing a stock¡¯s price on each day. On each day you can only make one operation: either buy or sell one unit of stock and you can make at most 1 transaction. Determine the maximum profit you can make.
//
//Assumptions
//
//The given array is not null and is length of at least 2.
//Examples
//
//{2, 3, 2, 1, 4, 5}, the maximum profit you can make is 5 - 1 = 4
//1 2 2 3 4 5
//4 1 3 2 5 6 Ð¡¶ÑË³Ðò
//i
//
//5 4 3 2 2 1
//6 5 2 3 1 4 ´ó¶ÑË³Ðò
//j
//
//if j>i return array[j]-array[i]
//else return j-1 i j i-1
public class Solution150 {
	public int maxProfit(int[] array) {
		int leng=array.length;
		if(leng<=1) {
			return 0;
		}
		int minprice=array[0];
		int maxprofit=0;
		for(int i=1;i<leng;i++) {
			minprice=Math.min(minprice, array[i]);
			maxprofit=Math.max(maxprofit, array[i]-minprice);
		}
	    return maxprofit;
	}
	
	public static void main(String[] args) {
		Solution150 s150 = new Solution150();
		int[] array=new int[]{7, 1, 5, 3, 6, 4};
		int result=s150.maxProfit(array);
		System.out.println(result);
	}
}