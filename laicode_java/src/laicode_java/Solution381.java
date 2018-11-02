package laicode_java;

import java.util.*;

public class Solution381 {
//
//Smallest Rectangle Cover All Black Pixels
//Given an binary matrix containing only 0 or 1, denoting white/black pixel.
//
//There is only one black object in the matrix, a black object is a number of value 1 pixels connected.
//
//Find the area of the smallest rectangle such that it can cover all the black pixels.
//
//Examples:
//
//{ {0, 0, 0, 0},
//
//  {0, 1, 1, 1},
//
//  {0, 0, 1, 0},
//
//  {0, 1, 1, 0} }
//
//the smallest rectangle needed is 3 * 3 = 9.
	  public int smallestRectangle(int[][] matrix) {
		    // Write your solution here.
		    return 0;
		  }
	  
	  
	public static void main(String[] args) {


	}
	
	public class RandomizedCollection {
		List<Integer> result;
		Map<Integer, LinkedHashSet<Integer>> map;
		
		public RandomizedCollection() {
			result = new ArrayList<>();
			map = new HashMap<Integer, LinkedHashSet<Integer>>();
		}
		
		public boolean insert(int val) {
			boolean est = map.containsKey(val);
			if(!est) {
				map.put(val, new LinkedHashSet<Integer>());
			}
			map.get(val).add(result.size());
			result.add(val);
			return !est;
		}
		
		public boolean remove(int val) {
			if(!map.containsKey(val)) {
				return false;
			}
			LinkedHashSet<Integer> indexes = map.get(val);
			int wantToChange = indexes.iterator().next();
			int lastValue = result.get(result.size()-1);
			LinkedHashSet<Integer> replaced = map.get(lastValue);
			result.set(wantToChange, lastValue);
			indexes.remove(wantToChange);
			if(wantToChange != result.size()-1) {
				replaced.remove(result.size()-1);
				replaced.add(wantToChange);
			}
			result.remove(result.size()-1);
			if(indexes.isEmpty()) {
				map.remove(val);
			}
			return true;
		}
		
		public int getRandom() {
			return result.get((int)(Math.random()*result.size()));
		}
	}
}
