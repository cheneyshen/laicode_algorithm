package laicode_java;

import java.util.*;

//N Queens
//Get all valid ways of putting N Queens on an N * N chessboard so that no two Queens threaten each other.
public class Solution233 {

	public List<List<Integer>> nqueens(int n) {
		List<List<Integer>> result= new ArrayList<>();
		if(n<=0) {
			return result;
		}
		List<Integer> matrix = new ArrayList<Integer>();
		for(int i=0; i<n; i++) {
			matrix.add(0);
		}
		nqueensHelper(matrix, n, 0, result);
		return result;
	}
	
	private void nqueensHelper(List<Integer> matrix, int n, int start, List<List<Integer>> result) {
		if(start==n) {
			result.add(new ArrayList<Integer>(matrix));
			return;
		}
		for(int i=0; i<n; i++) {
			if(checker(matrix, i, start)==true) {
				matrix.set(start, i);
				nqueensHelper(matrix, n, start+1, result);
			}
		}
	}
	private boolean checker(List<Integer> matrix, int val, int idx) {
		for(int j=0; j<idx; j++) {
			if(matrix.get(j) == val) {
				return false;
			}
			if(Math.abs(matrix.get(j)-val) == Math.abs(j-idx)) {
				return false;
			}
		}
		return true;
	}
	
	public int countDigit(int n) {
		int result = 0, left = 1, right = 1;
		while(n>0) {
			int front = (n+8)/10;
			if(front > 0) {
				if(n%10==1) {
					result += front*left+right;
				} else {
					result += front*left;
				}
			} else if(n%10==1) {
				result += 1*right;
			}
			right += n%10*left;
			left *= 10;
			n/=10;
		}
		return result;
	}
	
	public static void main(String[] args) {
		Solution233 ss = new Solution233();
		List<List<Integer>> result = ss.nqueens(8);
		for(int i=0; i<result.size(); i++) {
			System.out.println(result.get(i));
		}
	}
}
