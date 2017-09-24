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
		public int a, b;
		public Pair(int a, int b) {
			this.a=a;
			this.b=b;
		}
		public Pair() {
			this.a=0;
			this.b=0;
		}
	}
	
	public List<Integer> solve(char[][] gym) {
		List<Integer> result=new ArrayList<Integer>();
		int m=gym.length, n=gym[0].length;
		int[][] costs = new int[m][n];
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				costs[i][j] = Integer.MAX_VALUE;
			}
		}
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(gym[i][j]=='E') {
					if(addWeight(costs, gym, i, j)==false) {
						return result;
					}
				}
			}
		}
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(gym[i][j]!='E' && gym[i][j]!='O') {
					if(result.size()==0) {
						result.add(i); result.add(j);
					} else if(costs[i][j]<costs[result.get(0)][result.get(1)]) {
						result.set(0, i); result.set(1, j);
					}
				}
			}
		}
		return result;
	}
	
	private boolean addWeight(int[][] costs, char[][] gym, int i, int j) {
		boolean[][] visited = new boolean[gym.length][gym[0].length];
		Queue<Pair> myque = new LinkedList<Pair>();
		Pair curr = new Pair(i, j);
		myque.add(curr);
		int fee=1;
		visited[i][j]=true;
		while(!myque.isEmpty()) {
			int size=myque.size();
			for(int m=0; m<size; m++) {
				curr = myque.poll();
				List<Pair> neis = getNeis(curr, gym);
				for(int n=0; n<neis.size(); n++) {
					if(!visited[neis.get(n).a][neis.get(n).b]) {
						costs[neis.get(n).a][neis.get(n).b]+=fee;
						visited[neis.get(n).a][neis.get(n).b]=true;
						myque.add(neis.get(n));
					}
				}
			}
			fee++;
		}
		for(int m=0; m<gym.length; m++) {
			for(int n=0; n<gym[0].length; n++) {
				if(gym[m][n]=='E' && !visited[m][n]) {
					return false;
				}
			}
		}
		return true;
	}
	
	private List<Pair> getNeis(Pair curr, char[][] gym) {
		List<Pair> result = new ArrayList<Pair>();
		int x = curr.a, y = curr.b;
		int rows=gym.length, cols=gym[0].length;
		if(x+1<rows && gym[x+1][y]!='O') {
			result.add(new Pair(x+1, y));
		}
		if(y+1<cols && gym[x][y+1]!='O') {
			result.add(new Pair(x, y+1));
		}
		if(x-1>=0 && gym[x-1][y]!='O') {
			result.add(new Pair(x-1, y));
		}
		if(y-1>=0 && gym[x][y-1]!='O') {
			result.add(new Pair(x, y-1));
		}
		return result;
	}
	
	public static void main(String[] args) {
		char[][] gym = new char[][]{{ 'E', 'O', 'C' },
									{ 'C', 'E', 'C' },
									{ 'C', 'C', 'C' } };
		Solution195 ss = new Solution195();
		System.out.println(ss.solve(gym));
	}
}
