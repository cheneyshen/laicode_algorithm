package laicode_java;

import java.util.Arrays;

//Binary search in sorted 2d array I 
public class Solution9 {
	//复制java文件
	//for i in {3..100}; do cp Solution2.java "Solution$i.java"; done
	//分离某一行然后替换
	//for i in {3..100}; do head -3 "Solution$i.java" | tail -1 $1 | awk '{split($0, a, ' '); print a[3]' ; done
	//sed -i ' ' 's/hi/hello/' file1
	//更改后复制到新文件
	//awk 'NR==2{gsub("hi", "Hello", $1)}; {print $0}' file1 > newfile
	//代变量就必须要用“”双引号
	//for i in {3..100}; do sed -i " " "3s/Solution/Solution$i/" Solution$i.java ; done
	public int[] search1(int[][] matrix, int target) {
		int[] result=new int[]{-1,-1};
		if(matrix.length==0 || matrix[0].length==0) {
			return result;
		}
		int row=findRow(matrix, 0, matrix.length-1, target);
		if (row==-1) {
			return result;
		}
		int col=findCol(matrix[row], 0, matrix[row].length-1, target);
		if(col==-1) {
			return result;
		}
		result[0]=row;
		result[1]=col;
		return result;
	}
	private int findRow(int[][] matrix, int up, int down, int target) {
		while(up<=down) {
			int mid=up+(down-up)/2;
			if(matrix[mid][0]>target) {
				down=mid-1;
			}
			else {
				up=mid+1;
			}
		}
		return down;
	}
	private int findCol(int[] array, int left, int right, int target) {
		while(left<=right) {
			int mid=left+(right-left)/2;
			if(array[mid]==target) {
				return mid;
			}
			else if(array[mid]<target) {
				left=mid+1;
			}
			else {
				right=mid-1;
			}
		}
		return -1;
	}
	
	public int[] search2(int[][] matrix, int target) {
		if(matrix.length==0 || matrix[0].length==0) {
			return new int[]{-1,-1};
		}
		int rows=matrix.length;
		int cols=matrix[0].length;
		int left=0, right=rows*cols-1;
		while(left<=right) {
			int mid=left+(right-left)/2;
			int row=mid/cols;
			int col=mid%cols;
			if (matrix[row][col]==target) {
				return new int[]{row, col};
			}
			else if(matrix[row][col]<target) {
				left=mid+1;
			}
			else {
				right=mid-1;
			}
		}
		return new int[]{-1,-1};
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Solution9 s9 = new Solution9();
		int[][] matrix=new int[][]{ {1, 2, 3}, {4, 5, 7}, {8, 9, 10} };
		int[] result=s9.search1(matrix, 8);
		System.out.println(Arrays.toString(result));
		result=s9.search2(matrix, 6);
		System.out.println(Arrays.toString(result));
		return;
	}
}
