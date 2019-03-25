package laicode_java;

import java.util.*;

//Majority Number III
//Given an integer array of length L, find all numbers that occur more than 1/K * L times if any exist.
//  
//  Assumptions
//  
//  The given array is not null or empty
//  K >= 2
//  Examples
//  
//A = {1, 2, 1, 2, 1}, K = 3, return [1, 2]
//A = {1, 2, 1, 2, 3, 3, 1}, K = 4, return [1, 2, 3]
//A = {2, 1}, K = 2, return []
public class Solution208 {
	public List<Integer> majority(int[] array, int k) {
		if(k<2) {
			return null;
		}
		//直接用二维数组存取candidate & freq
		int[][] major = new int[k][2];
		for(int i=0; i<array.length; i++) {
			int comp=0;
			for(int j=0; j<major.length; j++) {
				if(major[j][0]==0) {
					major[j][0]=1;	//有个为空，就占用
					major[j][1]=array[i];
					break;
				} else if(major[j][1]==array[i]) {
					major[j][0]++;	//相等的话，freq++
					break;
				}
				else {
					comp++;	//如果不相等，记录比较次数
				}
			}
			if(comp==k) {	//发现一个都不相等
				for(int j=0; j<major.length; j++) {
					if(major[j][0]>0) {
						major[j][0]--;	//所有freq都--
					}
				}
			}
		}
		for(int i=0; i<k; i++) {
			major[i][0]=0;	//再把freq都清零
		}
		for(int j=0; j<array.length; j++) {
			for(int i=0; i<k; i++) {
				if(major[i][1]==array[j]) {
					major[i][0]++;//重新算freq
				}
			}
		}
		List<Integer> result=new ArrayList<Integer>();
		for(int i=0; i<k; i++) {
			if(major[i][0]>array.length/k) {
				result.add(major[i][1]);//验证通过的话，加入结果
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		Solution208 ss = new Solution208();
		int[] array = new int[]{1,2,1,2,1};
		System.out.println(ss.majority(array, 3));
		array = new int[]{1, 2, 1, 2, 3, 3, 1};
		System.out.println(ss.majority(array, 4));
	}
}
