package laicode_java;

//Common Numbers Of Two Arrays II
//Find all numbers that appear in both of two unsorted arrays.
//
//Assumptions
//
//Both of the two arrays are not null.
//In any of the two arrays, there could be duplicate numbers.
//Examples
//
//A = {1, 2, 3, 2}, B = {3, 4, 2, 2, 2}, return [2, 2, 3] (there are both two 2s in A and B)
import java.util.*;
public class Solution143 {
	public List<Integer> common(List<Integer> A, List<Integer> B) {
		if(A.size()==0 || B.size()==0) {
			return new ArrayList<Integer>();
		}
		else {
			HashMap<Integer, Integer> dict=new HashMap<Integer, Integer>();
			List<Integer> result=new ArrayList<Integer>();
			for(int i=0;i<A.size();i++) {
				if(dict.containsKey(A.get(i))) {
					dict.put(A.get(i), dict.get(A.get(i))+1);
				}
				else {
					dict.put(A.get(i), 1);
				}
			}
			for(int i=0;i<B.size();i++) {
				if(dict.containsKey(B.get(i))) {
					result.add(B.get(i));
					if(dict.get(B.get(i))>1) {
						dict.put(B.get(i), dict.get(B.get(i))-1);
					}
					else {
						dict.remove(B.get(i));
					}
				}
			}
			return result;
		}
	}
	
	public static void main(String[] args) {
		Solution143 s143=new Solution143();
		List<Integer> a=new ArrayList<Integer>(Arrays.asList(1, 2, 3, 2));
		List<Integer> b=new ArrayList<Integer>(Arrays.asList(3, 4, 2, 2, 2));
		List<Integer> result=s143.common(a, b);
		System.out.println(result);
	}
}