package laicode_java;
import java.util.*;

//N queens
public class Solution59 {
	//复制java文件
	//for i in {3..100}; do cp Solution2.java "Solution$i.java"; done
	//分离某一行然后替换
	//for i in {3..100}; do head -3 "Solution$i.java" | tail -1 $1 | awk '{split($0, a, ' '); print a[3]' ; done
	//sed -i ' ' 's/hi/hello/' file1
	//更改后复制到新文件
	//awk 'NR==2{gsub("hi", "Hello", $1)}; {print $0}' file1 > newfile
	//代变量就必须要用“”双引号
	//for i in {3..100}; do sed -i " " "3s/Solution/Solution$i/" Solution$i.java ; done
	public List<List<Integer>> nqueens1(int n) {
		List<List<Integer>> result=new ArrayList<List<Integer>>();
		List<Integer> cur=new ArrayList<Integer>();
		helper(n, cur, result);
		return result;
	}
	
	private void helper(int n, List<Integer> cur, List<List<Integer>> result) {
		if(cur.size()==n) {
			result.add(new ArrayList<Integer>(cur));
			return;
		}
		for(int i=0;i<n;i++) {
			if(valid(cur, i)) {
				cur.add(i);
				helper(n, cur, result);
				cur.remove(cur.size()-1);
			}
		}
	}
	
	private boolean valid(List<Integer> cur, int column) {
		int row=cur.size();
		for(int i=0;i<row;i++) {
			if(cur.get(i)==column || Math.abs(cur.get(i)-column)==row-i) {
				return false;
			}
		}
		return true;
	}
	
	public List<List<Integer>> nqueens2(int n) {
		List<List<Integer>> result=new ArrayList<List<Integer>>();
		int[] cur=new int[n];
		boolean[] usedColumns=new boolean[n];
		boolean[] usedDiagonals=new boolean[2*n-1];
		boolean[] usedRevDiagonals=new boolean[2*n-1];
		helper(n, 0, cur, result, usedColumns, usedDiagonals, usedRevDiagonals);
		return result;
	}
	
	private void helper(int n, int row, int[] cur, List<List<Integer>> result, boolean[] usedColumns, boolean[] usedDiagonals, boolean[] usedRevDiagonals) {
		if(row==n) {
			result.add(toList(cur));
			return;
		}
		for(int i=0;i<n;i++) {
			if(valid(n, row, i, usedColumns, usedDiagonals, usedRevDiagonals)) {
				mark(n, row, i, usedColumns, usedDiagonals, usedRevDiagonals);
				cur[row]=i;
				helper(n, row+1, cur, result, usedColumns, usedDiagonals, usedRevDiagonals);
				unMark(n, row, i, usedColumns, usedDiagonals, usedRevDiagonals);
			}
		}
	}
	
	private boolean valid(int n, int row, int column, boolean[] usedColumns, boolean[] usedDiagonals, boolean[] usedRevDiagonals) {
		System.out.println(column);
		System.out.println(column+row);
		System.out.println(column-row+n+1);
		return !usedColumns[column]&&!usedDiagonals[column+row]&&!usedRevDiagonals[column-row+n+1];
	}
	
	private void mark(int n, int row, int column, boolean[] usedColumns, boolean[] usedDiagonals, boolean[] usedRevDiagonals) {
		usedColumns[column]=true;
		usedDiagonals[column+row]=true;
		usedRevDiagonals[column-row+n-1]=true;
	}
	
	private void unMark(int n, int row, int column, boolean[] usedColumns, boolean[] usedDiagonals, boolean[] usedRevDiagonals) {
		usedColumns[column]=false;
		usedDiagonals[column+row]=false;
		usedRevDiagonals[column-row+n-1]=false;
	}
	
	private List<Integer> toList(int[] array) {
		List<Integer> list=new ArrayList<>();
		for(int num:array) {
			list.add(num);
		}
		return list;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Solution59 s59 = new Solution59();
		List<List<Integer>> result=s59.nqueens1(5);
		System.out.println(result);
		result=s59.nqueens2(4);
		System.out.println(result);
		return;
	}
}
