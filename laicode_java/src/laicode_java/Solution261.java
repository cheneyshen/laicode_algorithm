package laicode_java;

import java.util.*;

//Sort In Specified Order
//Given two integer arrays A1 and A2, sort A1 in such a way that the relative order among the elements will be same as those are in A2.
//
//For the elements that are not in A2, append them in the right end of the A1 in an ascending order.
//
//Assumptions:
//
//A1 and A2 are both not null.
//There are no duplicate elements in A2.
//Examples:
//
//A1 = {2, 1, 2, 5, 7, 1, 9, 3}, A2 = {2, 1, 3}, A1 is sorted to {2, 2, 1, 1, 3, 5, 7, 9}
public class Solution261 {
	static class Data {
		int value;
		int index;
		Data() {
			this.value = -1;
			this.index = -1;
		}
		Data(int value, int index) {
			this.value = value;
			this.index = index;
		}
	}
	class MyComparator implements Comparator<Data>{
		@Override
		public int compare(Data o1, Data o2) {
			if(o1.index>=0 && o2.index>=0) {
				return o1.index-o2.index;
			} else if(o1.index>=0 && o2.index<0) {
				return -1;
			} else if(o1.index<0 && o2.index>=0) {
				return 1;
			} else {
	            //	a.index==-1 && b.index==-1
				return o1.value-o2.value;
			}
		}
	}
	
	public List<Integer> sortSpecial(int[] A1, int[] A2) {
		List<Data> result = new ArrayList<>();
		HashMap<Integer, Integer> indexer = new HashMap<>();
		for(int i=0; i<A1.length; i++) {
			indexer.put(A1[i], -1);
		}
		for(int i=0; i<A2.length; i++) {
			indexer.put(A2[i], i);
		}
		for(int i=0; i<A1.length; i++) {
			int index = indexer.get(A1[i]);
			Data curr = new Data(A1[i], index);
			result.add(curr);
		}
		Collections.sort(result, new MyComparator());
		List<Integer> output=new ArrayList<>();
		for(int i=0; i<result.size(); i++) {
			output.add(result.get(i).value);
		}
		return output;
	}
	
	public static void main(String[] args) {
		int[] A1=new int[]{2, 1, 2, 5, 7, 1, 9, 3};
		int[] A2=new int[]{2, 1, 3};
		Solution261 ss = new Solution261();
		List<Integer> result = ss.sortSpecial(A1, A2);
		for(int i=0; i<result.size(); i++) {
			System.out.println(result.get(i));
		}
	}
}
