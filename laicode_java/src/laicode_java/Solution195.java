package laicode_java;

import java.util.*;

//Place To Put The Chair I
//Given a gym with k pieces of equipment and some obstacles.  We bought a chair and wanted to put this chair into the gym such that  the sum of the shortest path cost from the chair to the k pieces of equipment is minimal. The gym is represented by a char matrix, 鈥楨鈥� denotes a cell with equipment, 鈥極鈥� denotes a cell with an obstacle, 'C' denotes a cell without any equipment or obstacle. You can only move to neighboring cells (left, right, up, down) if the neighboring cell is not an obstacle. The cost of moving from one cell to its neighbor is 1. You can not put the chair on a cell with equipment or obstacle.
//  
//  Assumptions
//  There is at least one equipment in the gym
//  The given gym is represented by a char matrix of size M * N, where M >= 1 and N >= 1, it is guaranteed to be not null
//  It is guaranteed that each 'C' cell is reachable from all 'E' cells.
//  If there does not exist such place to put the chair, just return null (Java) empty vector (C++)
//  Examples
//  
//{ { 'E', 'O', 'C' },
//  {  'C', 'E',  'C' },
//  {  'C',  'C',  'C' } }
//  we should put the chair at (1, 0), so that the sum of cost from the chair to the two equipment is 1 + 1 = 2, which is minimal.
public class Solution195 {
	static class Pair {
		private int a, b;
		public Pair(int a, int b) {
			this.a=a;
			this.b=b;
		}
	}
	
	public List<Integer> putChair(char[][] gym) {
		int m = gym.length, n = gym[0].length;
		int[][] cost = new int[m][n];
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(gym[i][j] == 'E') {
					if(!addCost(gym, i, j, cost)) {
						return null;
					}
				}
			}
		}
		List<Integer> res = Arrays.asList(Integer.MAX_VALUE, Integer.MAX_VALUE);
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(gym[i][j] != 'E' && gym[i][j] != 'O') {
					if(res.get(0)==Integer.MAX_VALUE || cost[i][j]<cost[res.get(0)][res.get(1)]) {
						res = Arrays.asList(i, j);
					}
				}
			}
		}
		return res.get(0) == Integer.MAX_VALUE ?  Arrays.asList(-1, -1) : res;
	}
	
	private boolean addCost(char[][] gym, int i, int j, int[][] cost) {
		boolean[][] visited = new boolean[gym.length][gym[0].length];
		int pathcost = 1;
		Queue<Pair> que = new LinkedList<>();
		visited[i][j] = true;
		que.offer(new Pair(i, j));
		while(!que.isEmpty()) {
			int size = que.size();
			for(int l=0; l<size; l++) {
				Pair cur = que.poll();
				List<Pair> neis = getNeis(cur, gym);
				for(Pair nei:neis) {
					if(!visited[nei.a][nei.b]) {
						visited[nei.a][nei.b] = true;
						cost[nei.a][nei.b] += pathcost;
						que.offer(nei);
					}
				}
			}
			pathcost++;
		}
		for(int l=0; i<gym.length; l++) {
			for(int m=0; m<gym[0].length; m++) {
				if(!visited[i][j] && gym[l][m] == 'E') {
					return false;
				}
			}
		}
		return true;
	}
	
	private List<Pair> getNeis(Pair cur, char[][] gym) {
		int x=cur.a, y=cur.b;
		int m=gym.length, n=gym[0].length;
		List<Pair> neis = new ArrayList<>();
		if(x+1<m && gym[x+1][y] != 'O') {
			neis.add(new Pair(x+1, y));
		}
		if(y+1<n && gym[x][y+1] != 'O') {
			neis.add(new Pair(x, y+1));
		}
		if(x>0 && gym[x-1][y] != 'O') {
			neis.add(new Pair(x-1, y));
		}
		if(y>0 && gym[x][y-1] != 'O') {
			neis.add(new Pair(x, y-1));
		}
		return neis;
	}

	public static void main(String[] args) {
		char[][] gym = new char[][]{{ 'E', 'O', 'C' },
									{ 'C', 'E', 'C' },
									{ 'C', 'C', 'C' } };
		Solution195 ss = new Solution195();
		System.out.println(ss.putChair(gym));
	}
}
