package laicode_java;

import java.util.*;

//    Common Numbers Of Two Arrays I
//    Find all numbers that appear in both of the two unsorted arrays, return the common numbers in increasing order.
//
//    Assumptions
//
//    Both arrays are not null.
//    There are no duplicate numbers in each of the two arrays respectively.
//    Exmaples
//
//    A = {1, 2, 3}, B = {3, 1, 4}, return [1, 3]
//    A = {}, B = {3, 1, 4}, return []
public class Solution070 {
	List<Integer> common(int[] a, int [] b) {
		List<Integer> common=new ArrayList<Integer>();
		int i=0, j=0;
		while(i<a.length && j<b.length) {
			if(a[i]==b[j]) {
				common.add(a[i]);
				i++;
				j++;
			}
			else if(a[i]<b[j]) {
				i++;
			}
			else {
				j++;
			}
		}
		return common;
	}
	
	List<Integer> commonII(int[] a, int[] b) {
		List<Integer> common=new ArrayList<Integer>();
		HashMap<Integer, Integer> countA=new HashMap<Integer, Integer>();
		for(int num:a) {
			Integer ct=countA.get(num);
			if(ct!=null) {
				countA.put(num, ct+1);
			}
			else {
				countA.put(num, 1);
			}
		}
		HashMap<Integer, Integer> countB=new HashMap<Integer, Integer>();
		for(int num:b) {
			Integer ct=countB.get(num);
			if(ct!=null) {
				countB.put(num, ct+1);
			} else {
				countB.put(num, 1);
			}
		}
		for (Map.Entry<Integer, Integer> entry:countA.entrySet()) {
			Integer ctInB=countB.get(entry.getKey());
			if(ctInB!=null) {
				int appear=Math.min(entry.getValue(), ctInB);
				for(int i=0; i<appear; i++) {
					common.add(entry.getKey());
				}
			}
		}
		return common;
	}
	public static void main(String[] args) {


	}
}
