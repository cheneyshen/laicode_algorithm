package laicode_java;

import java.util.*;

//Majority Number I
//Given an integer array of length L, find the number that occurs more than 0.5 * L times.
//
//Assumptions
//
//The given array is not null or empty
//It is guaranteed there exists such a majority number
//Examples
//
//A = {1, 2, 1, 2, 1}, return 1
public class Solution206 {
	public int majority(int[] array) {
		//结果初始化为第一个
		int result=array[0];
		//等于major的个数
		int count=1;
		//从第二个元素开始机选
		for(int i=1; i<array.length; i++) {
			//major个数为0,更新major
			if(count==0) {
				result=array[i];
				count++;
			}
			//不等于major,major抵消掉一个
			else if(array[i]!=result) {
				count--;
			}
			//major个数增加
			else {
				count++;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		Solution206 ss = new Solution206();
		int[] array = new int[]{1,2,3,3,2,1,1,1,1};
		System.out.println(ss.majority(array));
	}
}
