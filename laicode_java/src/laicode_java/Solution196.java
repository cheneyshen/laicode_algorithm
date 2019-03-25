package laicode_java;

import java.util.*;

//Place To Put The Chair II
//Given a gym with k pieces of equipment without any obstacles.  Let鈥檚 say we bought a chair and wanted to put this chair into the gym such that the sum of the shortest path cost from the chair to the k pieces of equipment is minimal. The gym is represented by a char matrix, 鈥楨鈥� denotes a cell with equipment, ' ' denotes a cell without equipment. The cost of moving from one cell to its neighbor(left, right, up, down) is 1. You can put chair on any cell in the gym.
//
//Assumptions
//
//There is at least one equipment in the gym
//The given gym is represented by a char matrix of size M * N, where M >= 1 and N >= 1, it is guaranteed to be not null
//鈥婨xamples
//{ { 'E', ' ', ' ' },
//  {  ' ', 'E',  ' ' },
//  {  ' ',  ' ', 'E' } }
//we should put the chair at (1, 1), so that the sum of cost from the chair to the two equipments is 2 + 0 + 2 = 4, which is minimal.
public class Solution196 {
	public List<Integer> putChair(char[][] gym) {
		int m=gym.length, n=gym[0].length;
		List<Integer> result =new ArrayList<Integer>();
		List<Integer> lat = new ArrayList<Integer>();
		List<Integer> log = new ArrayList<Integer>();
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				//找到所有的E
				if(gym[i][j]=='E') {
					lat.add(i);
					log.add(j);
				}
			}
		}
		Collections.sort(lat);
		Collections.sort(log);
		int leng = lat.size();
		//求中位数就好了
		if(leng%2==0) {
			int a = lat.get(lat.size()/2-1) + lat.get(lat.size()/2);
			int b = log.get(log.size()/2-1) + log.get(log.size()/2);
			result.add(a/2);
			result.add(b/2);
		} else {
			result.add(lat.get(lat.size()/2));
			result.add(log.get(log.size()/2));
		}
		return result;
	}
	
	public static void main(String[] args) {
		Solution196 ss = new Solution196();
		char[][] gym = new char[][] 
				{ { 'E', ' ', ' ', 'E'},
				{  ' ', 'E',  ' ', 'E'},
				{  ' ',  ' ', 'E', 'E'} };
		List<Integer> result = ss.putChair(gym);
		System.out.println(result);
	}
}
