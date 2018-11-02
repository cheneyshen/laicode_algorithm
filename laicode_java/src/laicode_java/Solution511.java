package laicode_java;

import java.util.*;
import java.io.*;
public class Solution511 {
 /*
  * 1 2 3
  * 4 5 6
  * 7 8 9
  * 
  */
	
	public int getPaths() {
		int[] result = new int[1];
		Map<Integer, List<Integer>> table = new HashMap<>();
		List<Integer> list= new ArrayList<>();
		list.add(2);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(8);
		table.put(1, list);
		Map<Integer, List<Integer>> block = new HashMap<>();
		block.add(3);
		block.add(7);
		block.add(9);
		
		list= new ArrayList<>();
		list.add(1);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(9);
		table.put(1, list);
		block = new HashSet<>();
		block.add(3);
		block.add(7);
		block.add(9);
		
		for(int i=1; i<10; i++) {
			Set<Integer> path = new HashSet<>();
			dfsHelper(i, path, table, block, result);
		}
		return result[0];
	}
	
	void dfsHelper(int i, Set<Integer> path,  Map<Integer, List<Integer>> table, Map<Integer, List<Integer>> block, int[] result) {
		if(path.contains(i)) {
			return;
		}
		if(path.size()>3) {
			result[0]++;
		}
		if(path.size()==9) {
			return;
		}
		path.add(i);
		for(int j=1; j<10; j++) {
			//already visited, skip
			if(path.contains(j)) {
				continue;
			} else {
				// blocked number  3, 7, 9
				if(block.get(i).contains(j)) {
					// need helper number, 2, 4, 5
					if(path.contains((i+1)/2)) {
						path.add(j);
						dfsHelper(j, path, table, block, result);
					}
				} else {
					path.add(j);
					dfsHelper(j, path, table, block, result);
				}
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
