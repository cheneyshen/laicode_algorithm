package laicode_java;

import java.util.PriorityQueue;
import java.util.Comparator;
//Kth smallest number in sorted matrix
public class Solution37 {
	//复制java文件
	//for i in {3..100}; do cp Solution2.java "Solution$i.java"; done
	//分离某一行然后替换
	//for i in {3..100}; do head -3 "Solution$i.java" | tail -1 $1 | awk '{split($0, a, ' '); print a[3]' ; done
	//sed -i ' ' 's/hi/hello/' file1
	//更改后复制到新文件
	//awk 'NR==2{gsub("hi", "Hello", $1)}; {print $0}' file1 > newfile
	//代变量就必须要用“”双引号
	//for i in {3..100}; do sed -i " " "3s/Solution/Solution$i/" Solution$i.java ; done
	public int kthSmallest(int[][] matrix, int k) {
		int rows=matrix.length;
		int columns=matrix[0].length;
		PriorityQueue<Cell> minHeap=new PriorityQueue<Cell>(k, new Comparator<Cell>() {
			@Override
			public int compare(Cell c1, Cell c2) {
				if(c1.value==c2.value) {
					return 0;
				}
				return c1.value<c2.value?-1:1;
			}
		});
		boolean[][] visited = new boolean[rows][columns];
		minHeap.offer(new Cell(0,0, matrix[0][0]));
		visited[0][0]=true;
		for(int i=0;i<k-1;i++) {
			Cell cur=minHeap.poll();
			if(cur.row+1<rows && !visited[cur.row+1][cur.column]) {
				minHeap.offer(new Cell(cur.row+1, cur.column, matrix[cur.row+1][cur.column]));
				visited[cur.row+1][cur.column]=true;
			}
			if(cur.column+1<columns && !visited[cur.row][cur.column+1]) {
				minHeap.offer(new Cell(cur.row, cur.column+1, matrix[cur.row][cur.column+1]));
				visited[cur.row][cur.column+1]=true;
			}
		}
		return minHeap.peek().value;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Solution37 s37 = new Solution37();
		int[][] matrix={  {1,  3,   5,  7},
						  {2,  4,   8,   9},
						  {3,  5, 11, 15},
						  {6,  8, 13, 18} };
		int result=s37.kthSmallest(matrix, 5);
		System.out.println(result);
		return;
	}
}

class Cell {
	int row, column, value;
	Cell(int row, int column, int value) {
		this.row=row;
		this.column=column;
		this.value=value;
	}
}