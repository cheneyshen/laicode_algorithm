package laicode_java;

import java.util.*;

//Majority Number II
//Given an integer array of length L, find all numbers that occur more than 1/3 * L times if any exist.
//  
//  Assumptions
//  
//  The given array is not null
//  Examples
//  
//  A = {1, 2, 1, 2, 1}, return [1, 2]
//	A = {1, 2, 1, 2, 3, 3, 1}, return [1]
//	A = {1, 2, 2, 3, 1, 3}, return []
public class Solution207 {
	public List<Integer> majority(int[] array) {
		//超过1/3的数最多有2个
		int x=0, y=0;
		int a=0, b=0;
		for(int i=0; i<array.length; i++) {
			if(x==0) {
				a=array[i];	//第1个数
			}
			else if(y==0) {
				b=array[i];	//第2个数
			}
			else if(array[i]==a) {
				x++;	//等于第1个数
			}
			else if(array[i]==b) {
				y++;	//等于第2个数
			}
			else {
				x--;y--;	//都不相等，那么就都减掉
			}
		}
		List<Integer> result = new ArrayList<Integer>();
		//重新计算两个数的评率
		x=0; y=0;
		for(int i=0; i<array.length; i++) {
			if(array[i]==a) {
				x++;
			}
			if(array[i]==b) {
				y++;
			}
		}
		//验证通过就加入集合
		if(x>array.length/3) {
			result.add(a);
		}
		if(y>array.length/3) {
			result.add(y);
		}
		return result;
	}
	
	public static void main(String[] args) {
		Solution207 ss = new Solution207();
		int[] array = new int[]{1,2,1,2,3,3,1};
		System.out.println(ss.majority(array));
	}
}
