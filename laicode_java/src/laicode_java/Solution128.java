package laicode_java;
import java.util.*;

//Generate random maza
public class Solution128 {
	public int[][] maze(int n) {
		int[][] result=new int[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
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
	
	private void generate(int[][] result, int x, int y) {
		Dir[] dirs=Dir.values();
		shuffle(dirs);
		for(Dir dir:dirs) {
			int nextX=dir.moveX(x, 2);
			int nextY=dir.moveY(y, 2);
			if(isValidWall(result, nextX, nextY)) {
				result[dir.moveX(x, 1)][dir.moveY(y, 1)]=0;
				result[nextX][nextY]=0;
				generate(result, nextX, nextY);
			}
		}
	}
	
	private void shuffle(Dir[] dirs) {
		for(int i=0;i<dirs.length;i++) {
			int index=(int)(Math.random()*(dirs.length-i));
			Dir temp=dirs[i];
			dirs[i]=dirs[i+index];
			dirs[i+index]=temp;
		}
	}
	
	private boolean isValidWall(int[][] result, int x, int y) {
		return x>=0 && x<result.length && y>=0 && y<result[0].length && result[x][y]==1;
	}
	
	public static void main(String[] args) {
		Solution128 s128 = new Solution128();
		int[][] result=s128.maze(5);
		for(int i = 0; i < result.length; i++) {
		      for(int j = 0; j < result[0].length; j++)
		      {
		         System.out.printf("%5d ", result[i][j]);
		      }
		      System.out.println();
		}
	}
}

enum Dir {
	NORTH(0, 1), SOUTH(0, -1), EAST(1, 0), WEST(-1, 0);
	int dx, dy;
	Dir(int dx, int dy) {
		this.dx=dx;
		this.dy=dy;
	}
	public int moveX(int x, int times) {
		return x+times*dx;
	}
	public int moveY(int y, int times) {
		return y+times*dy;
	}
}