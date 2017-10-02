package laicode_java;

import java.util.*;

//Generate Random Maze
//Randomly generate a maze of size N * N (where N = 2K + 1) whose corridor and wall’s width are both 1 cell. For each pair of cells on the corridor, there must exist one and only one path between them. (Randomly means that the solution is generated randomly, and whenever the program is executed, the solution can be different.). The wall is denoted by 1 in the matrix and corridor is denoted by 0.
//
//Assumptions
//
//N = 2K + 1 and K >= 0
//the top left corner must be corridor
//there should be as many corridor cells as possible
//for each pair of cells on the corridor, there must exist one and only one path between them
//  Examples
//  
//  N = 5, one possible maze generated is
//  0  0  0  1  0
//  1  1  0  1  0
//  0  1  0  0  0
//  0  1  1  1  0
//  0  0  0  0  0

/*  0  1  0  1  0
 *  0  0  
 *  1  
 */
public class Solution218 {
	class Dir {
		public int dx, dy;
		public Dir(int dx, int dy) {
			this.dx = dx;
			this.dy = dy;
		}
		public int moveX(int x, int times) {
			return x + times*dx;
		}
		public int moveY(int y, int times) {
			return y + times*dy;
		}
	}
	
	public Solution218() {
		Dir north = new Dir(0, 1);
		Dir south = new Dir(0, -1);
		Dir east = new Dir(1, 0);
		Dir west = new Dir(-1, 0);
		this.dirs = new ArrayList<>();
		this.dirs.add(north);
		this.dirs.add(south);
		this.dirs.add(east);
		this.dirs.add(west);
	}
	
	private List<Dir>  dirs;
	public int[][] maze(int n) {
		if(n%2==0) {
			return null;
		}
		int[][] result=new int[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(i==0 && j==0) {
					result[i][j]=0;
				}
				else {
					result[i][j]=1;
				}
			}
		}
		generate(result, 0, 0);
		return result;
	}
	
	private void generate(int[][] matrix, int x, int y) {
		Collections.shuffle(dirs);
		for(int i=0; i<dirs.size(); i++) {
			int nextX = dirs.get(i).moveX(x, 2);
			int nextY = dirs.get(i).moveY(y, 2);
			if(isValidWall(matrix, nextX, nextY)) {
				int newX = dirs.get(i).moveX(x, 1);
				int newY = dirs.get(i).moveY(y, 1);
				matrix[newX][newY]=0;
				matrix[nextX][nextY]=0;
				generate(matrix, nextX, nextY);
			}
		}
	}
	
	private boolean isValidWall(int[][] matrix, int x, int y) {
        return x>=0 && x<matrix.length && y>=0 && y<matrix[0].length && matrix[x][y]==1;
	}
	
	public static void main(String[] args) {
		Solution218 ss = new Solution218();
		int[][] result = ss.maze(5);
		for(int i=0; i<5; i++) {
			System.out.println(Arrays.toString(result[i]));
		}
	}
}
