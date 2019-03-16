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
		nqueensHelper(matrix, n, 0, result);
		return result;
	}
	
	private void nqueensHelper(List<Integer> matrix, int n, int start, List<List<Integer>> result) {
		if(start==n) {
			result.add(new ArrayList<>(matrix));
			return;
		}
		for(int i=0; i<n; i++) {
			if(checker(matrix, i)) {
				matrix.add(i);
				nqueensHelper(matrix, n, start+1, result);
				matrix.remove(matrix.size()-1);
			}
		}
	}
	private boolean checker(List<Integer> matrix, int val) {
		for(int j=0; j<matrix.size(); j++) {
			if(matrix.get(j) == val) {
				return false;
			}
			if(Math.abs(j-matrix.size()) == Math.abs(val-matrix.get(j))) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		Solution233 ss = new Solution233();
		List<List<Integer>> result = ss.nqueens(8);
		for(int i=0; i<result.size(); i++) {
			System.out.println(result.get(i));
		}
	}
}
