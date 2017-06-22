package laicode_java;
import java.util.*;

//Spiral order traverse I
public class Solution60 {
	//复制java文件
	//for i in {3..100}; do cp Solution2.java "Solution$i.java"; done
	//分离某一行然后替换
	//for i in {3..100}; do head -3 "Solution$i.java" | tail -1 $1 | awk '{split($0, a, ' '); print a[3]' ; done
	//sed -i ' ' 's/hi/hello/' file1
	//更改后复制到新文件
	//awk 'NR==2{gsub("hi", "Hello", $1)}; {print $0}' file1 > newfile
	//代变量就必须要用“”双引号
	//for i in {3..100}; do sed -i " " "3s/Solution/Solution$i/" Solution$i.java ; done
	public List<Integer> spiral1(int[][] matrix) {
		List<Integer> list=new ArrayList<Integer>();
		recursiveTraverse(matrix, 0, matrix.length, list);
		return list;
	}
	
	private void recursiveTraverse(int[][] matrix, int offset, int size, List<Integer> result) {
		if(size==0) {
			return;
		}
		if(size==1) {
			result.add(matrix[offset][offset]);
			return;
		}
		for(int i=0;i<size-1;i++) {
			result.add(matrix[offset][offset+i]);
		}
		for(int i=0;i<size-1;i++) {
			result.add(matrix[offset+i][offset+size-1]);
		}
		for(int i=size-1;i>=1;i--) {
			result.add(matrix[offset+size-1][offset+i]);
		}
		for(int i=size-1;i>=1;i--) {
			result.add(matrix[offset+i][offset]);
		}
		recursiveTraverse(matrix, offset+1, size-2, result);
	}
	
	public List<Integer> spiral2(int[][] matrix) {
		List<Integer> list=new ArrayList<Integer>();
		int n=matrix.length;
		int start=0, end=n-1;
		while(start<end) {
			for(int i=start;i<=end;i++) {
				list.add(matrix[start][i]);
			}
			for(int i=start+1;i<=end-1;i++) {
				list.add(matrix[i][end]);
			}
			for(int i=end;i>=start;i--) {
				list.add(matrix[end][i]);
			}
			for(int i=end-1;i>=start+1;i--) {
				list.add(matrix[i][start]);
			}
			start++;
			end--;
		}
		if(start==end) {
			list.add(matrix[start][end]);
		}
		return list;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Solution60 s60 = new Solution60();
		int[][] matrix={ {1,  2,  3},
						  {4,  5,  6},
						  {7,  8,  9} };
		List<Integer> result=s60.spiral1(matrix);
		System.out.println(result);
		result=s60.spiral2(matrix);
		System.out.println(result);
		return;
	}
}
