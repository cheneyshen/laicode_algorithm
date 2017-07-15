package laicode_java;

//Place To Put The Chair II
//Given a gym with k pieces of equipment without any obstacles.  Let’s say we bought a chair and wanted to put this chair into the gym such that the sum of the shortest path cost from the chair to the k pieces of equipment is minimal. The gym is represented by a char matrix, ‘E’ denotes a cell with equipment, ' ' denotes a cell without equipment. The cost of moving from one cell to its neighbor(left, right, up, down) is 1. You can put chair on any cell in the gym.
//
//Assumptions
//
//There is at least one equipment in the gym
//The given gym is represented by a char matrix of size M * N, where M >= 1 and N >= 1, it is guaranteed to be not null
//​Examples
//
//{ { 'E', ' ', ' ' },
//
//  {  ' ', 'E',  ' ' },
//
//  {  ' ',  ' ', 'E' } }
//
//we should put the chair at (1, 1), so that the sum of cost from the chair to the two equipments is 2 + 0 + 2 = 4, which is minimal.

import java.util.*;

public class Solution172 {
	private List<Pair> getNeis(int x, int y, int rows, int cols) {
		List<Pair> result2 = new ArrayList<Pair>();
	    if(x-1>=0) {
	    	Pair top=new Pair(x-1, y);
	        result2.add(top);
	    }
	    if(x+1<rows) {
	    	Pair bottom=new Pair(x+1, y);
	        result2.add(bottom);
	    }
	    if(y-1>=0) {
	    	Pair left=new Pair(x, y-1);
	        result2.add(left);
	    }
	    if(y+1<cols) {
	    	Pair right=new Pair(x, y+1);
	        result2.add(right);
	    }
	    return result2;
	}
	    
	private void getDist(int x, int y, int[][] dist, int rows, int cols) {
        boolean[][] visited=new boolean[rows][cols];
        for (boolean[] row: visited) {
            Arrays.fill(row, false);
        }
        Queue<Pair> myque = new LinkedList<Pair>();
        myque.offer(new Pair(x, y));
        visited[x][y]=true;
        while(!myque.isEmpty()) {
            int size=(int)myque.size();
            for(int i=0;i<size;++i) {
                Pair cur=myque.poll();
                List<Pair> neibs=getNeis(cur.first, cur.second, rows, cols);
                for(int m=0;m<neibs.size();++m) {
                    if(visited[neibs.get(m).first][neibs.get(m).second]==false) {
                        visited[neibs.get(m).first][neibs.get(m).second]=true;
                        dist[neibs.get(m).first][neibs.get(m).second] =dist[cur.first][cur.second]+1;
                        myque.offer(neibs.get(m));
                    }
                }
            }
        }
    }
	
	public List<Integer> putChair(char[][] gym) {
        int rows=(int)gym.length;
        if(rows<=0) {
            return null;
        }
        int cols=(int)gym[0].length;
        if(cols<=0) {
            return null;
        }
        List<Integer> result=new ArrayList<Integer>();
        List<Pair> equips = new ArrayList<Pair>();
        for(int i=0;i<rows;i++) {
            for(int j=0;j<cols;j++) {
                if(gym[i][j]=='E') {
                	Pair equip=new Pair(i, j);
                    equips.add(equip);
                }
            }
        }
        if(equips.size()<=0) {
            return null;
        }
        if(equips.size()==1) {
        	result.add(equips.get(0).first);
        	result.add(equips.get(0).second);
            return result;
        }
        int[][][] dist = new int[equips.size()][rows][cols];
        for(int i=0;i<equips.size();i++) {
            getDist(equips.get(i).first, equips.get(i).second, dist[i], rows, cols);
        }
        for(int m=1;m<equips.size();++m) {
            for(int i=0;i<rows;++i) {
                for(int j=0;j<cols;++j) {
                    dist[0][i][j]+=dist[m][i][j];
                }
            }
        }
        int minValue=dist[0][0][0];
        for(int i=0;i<rows;++i) {
            for(int j=0;j<cols;++j) {
                if(minValue>dist[0][i][j]) {
                    minValue=dist[0][i][j];
                    result=new ArrayList<Integer>();
                    result.add(i);
                    result.add(j);
                }
            }
        }
        return result;
	}
	
	public static void main(String[] args) {
		Solution172 s172=new Solution172();
		char[][] gym={	{ 'E', ' ', ' ' },
						{ ' ', 'E', ' ' },
						{ ' ', ' ', 'E' }};
		List<Integer> result=s172.putChair(gym);
		System.out.println(result);
	}
}


