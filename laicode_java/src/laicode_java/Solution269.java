package laicode_java;

import java.util.*;
import java.util.Map.Entry;

//Total Area Of Skyline
//Given n houses on the ground with each house represented by a rectangle. The i-th rectangle is represented as [start_i, end_i, height_i], where  0 <= i < n. The rectangles may overlap with each other.  How can we calculate the total area that these rectangles cover.
//Assumptions:
//The given array of buildings is not null, the buildings are not null.
//Examples:
//buildings = {<1,3,1>, <2,4,2>},  output = 5.
/*	
 *  ___
 * ___
 * ____
 */
public class Solution269 {
	public int totalArea(int[][] buildings) {
		if(buildings==null || buildings.length<1) {
			return 0;
		}
		TreeMap<Integer, Integer> dict=new TreeMap<>();
		for(int i=0; i<buildings.length; i++) {
			for(int j=buildings[i][0]; j<buildings[i][1]; j++) {
				if(dict.containsKey(j)) {
					if(buildings[i][2]>dict.get(j)) {
						dict.put(j,	buildings[i][2]);
					}
				} else {
					dict.put(j, buildings[i][2]);
				}
			}
		}
		int result=0;
		for(Entry<Integer, Integer> entry:dict.entrySet()) {
//			int key = entry.getKey();
			int value = entry.getValue();
			result += value;
//			System.out.println(key+" "+value);
		}
		return result;
	}
	public static void main(String[] args) {
		int[][] buildings = {{2,4,2},{1,3,1},{2,6,3}};
		Solution269 ss = new Solution269();
		int result = ss.totalArea(buildings);
		System.out.println(result);
	}
}
