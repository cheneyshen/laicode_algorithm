package laicode_java;
//Common Numbers Of Two Arrays I
//Find all numbers that appear in both of the two unsorted arrays, return the common numbers in increasing order.
//
//Assumptions
//
//Both arrays are not null.
//There are no duplicate numbers in each of the two arrays respectively.
//Exmaples
//
//A = {1, 2, 3}, B = {3, 1, 4}, return [1, 3]
//A = {}, B = {3, 1, 4}, return []

import java.util.*;
public class Solution142 {
	public List<Integer> common(List<Integer> a, List<Integer> b) {
		if(a.size()==0 || b.size()==0) {
			return new ArrayList<Integer>();
		}
		else {
			HashSet<Integer> dict=new HashSet<Integer>();
			ArrayList<Integer> result=new ArrayList<Integer>();
			for(int i=0;i<a.size();i++) {
				dict.add(a.get(i));
			}
			for(int i=0;i<b.size();i++) {
				if(dict.contains(b.get(i))) {
					result.add(b.get(i));
				}
			}
			Collections.sort(result);
			return result;
		}
	}
	
	public static void main(String[] args) {
		Solution142 s142 = new Solution142();
		List<Integer> a=new ArrayList<Integer>();
		a.add(1);
		a.add(2);
		a.add(3);
		List<Integer> b=new ArrayList<Integer>();
		b.add(3);
		b.add(1);
		b.add(4);
		List<Integer> result=s142.common(a, b);
		System.out.println(result.toString());
	}
}