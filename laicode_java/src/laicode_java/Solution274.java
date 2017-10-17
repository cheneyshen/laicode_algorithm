package laicode_java;

import java.util.*;

//All Factors Of A Number
//Get all possible combinations of factors that can multiply to a target number.
//
//Assumptions:
//The given number is guaranteed to be >= 2.
//Examples:
//12 -->  [ [2, 2, 3], [2, 6], [3, 4], [12] ]
//5 --> [ [5] ]
/*				12
 * 		2(6) 3(4) 4(3) 5 6(2) 7 8 9 10 11 12(1)
 *  2(3)3(2)456(1)
 *  2 
 */
public class Solution274 {
	public List<List<Integer>> getFacters(int n) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		helper(result, new ArrayList<Integer>(), n, 2);
		return result;
	}
	
	public void helper(List<List<Integer>> result, List<Integer> item, int n, int start) {
		if(n<=1) {
			if(item.size()>1) {
				result.add(new ArrayList<Integer>(item));
			}
			return;
		}
		for(int i=start; i<=n; i++) {
			if(n%i==0) {
				item.add(i);
				helper(result, item, n/i, i);
				item.remove(item.size()-1);
			}
		}
	}
	
	public static void main(String[] args) {


	}
}
