package laicode_java;

import java.util.*;

//Longest Ascending Subsequence
//Given an array A[0]...A[n-1] of integers, find out the length of the longest ascending subsequence.
//
//Assumptions
//
//A is not null
//Examples
//Input: A = {5, 2, 6, 3, 4, 7, 5}
//Output: 4
//Because [2, 3, 4, 5] is the longest ascending subsequence.
// result = 3
// table = 0 2 3 4 5 0 0 
public class Solution001 {
	public int longest(int[] array) {
		if(array.length==0) {
			return 0;
		}
		int[] table=new int[array.length];
		int result=1; // longest ascending subsequence 初始化为1
		table[1]=array[0];  //为什么是1？因为从table 1 到 result之间搜索
		for(int i=1; i<array.length; i++) {
			int index=find(table, 1, result, array[i]);
			if(index==result) {
				table[++result]=array[i];
			}
			else {
				table[index+1]=array[i];
			}
		}
		return result;
	}
	private int find(int[] table, int left, int right, int target) {
		while(left<=right) {
			int mid=left+(right-left)/2;
			if(table[mid]==target) {
				right=mid-1;
			}
			else if(table[mid]>target) {
				right=mid-1;
			}
			else {
				left=mid+1;
			}
		}
		return right;
	}
	static int[][] dirs = new int[][] {{0,1},{1,0},{0,-1},{-1,0}};
	static int getCount(int[][] arr, int m, int n) {
		int res = 0;
		boolean[][] visited = new boolean[m][n];
		Set<List<Integer>> dict = new HashSet<>();
		//String[] path = new String[1];
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(visited[i][j]==false && arr[i][j]==1) {
					List<Integer> path = new LinkedList<>();
					helper(arr, m, n, visited, path, i, j);
					if(dict.contains(path)==false) {
						dict.add(path);	res++;
					}
				}
			}
		}
		return res;
	}
	
	static void helper(int[][] arr, int m, int n, boolean[][] visited, List<Integer> path, int i, int j) {
		if(visited[i][j]) {
			return;
		}
		visited[i][j]=true;
		for(int[] dir:dirs) {
			int x = dir[0] +i; int y = dir[1]+j;
			if(x>=0 && x<m && y>=0 && y<n && visited[x][y]==false && arr[x][y] == 1) {
				path.add(dir[0]); path.add(dir[1]);
				helper(arr, m, n, visited, path, x, y);
			}
		}
	}
	public static void main(String[] args) {
		Solution001 ss = new Solution001();
		int[] array = {1, 2, 2, 2, 4, 5, 5};
		System.out.println(ss.longest(array));

		int[][] arr = {{1,1,0,0,0},{1,1,0,0,0},{0,0,1,1,0},{0,0,1,1,0}};
		System.out.println(getCount(arr,4,5));
		
		dedup(array);
	}
	
    public static int[] dedup(int[] array) {
        if(array==null || array.length<=1) {
            return array;
        }
        int end = 0;
        boolean flag = false;
        for(int i=1; i<array.length; i++) {
            if(array[i]==array[end]) {
                flag = true;
            } else if(flag == true) {
                array[end]=array[i];
                flag = false;
            } else {
                array[++end] = array[i];
            }
        }
        return Arrays.copyOf(array, flag?end:end+1);
    }
}
