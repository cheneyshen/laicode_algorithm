package laicode_java;

import java.util.*;

//Search In Sorted Matrix I
//Given a 2D matrix that contains integers only, which each row is sorted in an ascending order. The first element of next row is larger than (or equal to) the last element of previous row.
//
//Given a target number, returning the position that the target locates within the matrix. If the target number does not exist in the matrix, return {-1, -1}.
//
//Assumptions:
//
//The given matrix is not null, and has size of N * M, where N >= 0 and M >= 0.
//Examples:
/*matrix = {{1, 2, 3},
 *  		{4, 5, 7}, 
 *  		{8, 9, 10} }
 */
//target = 7, return {1, 2}
//target = 6, return {-1, -1} to represent the target number does not exist in the matrix.
public class Solution267 {
	public List<Integer> search(int[][] matrix, int target) {
		if(matrix==null || matrix.length<1) {
			return null;
		}
		int rows = matrix.length, cols = matrix[0].length;
		List<Integer> result=new ArrayList<>();
		int i=0, j=cols-1;
		while(i<rows && j>=0) {
			int curr=matrix[i][j];
			if(curr==target) {
				result.add(i);
				result.add(j);
				return result;
			} else if(curr<target) {
				i++;
			} else {
				j--;
			}
		}
		result.add(-1); result.add(-1);
		return result;
	}
	
	Set<String> set = new HashSet<>();
	public List<String> generatePalindromes(String s) {
		int[] map = new int[128];
		char[] st = new char[s.length()];
		if(!canPermute(s, map)) {
			return new ArrayList<>();
		}
		char ch = 0;
		int k = 0;
		for(int i=0; i<map.length; i++) {
			if(map[i]%2==1) {
				ch = (char)i;
			} for(int j=0; j<map[i]/2; j++) {
				st[k] = (char)i;
				k++;
			}
		}
		permute(st, 0, ch);
		return new ArrayList<String>(set);
	}
	
	public boolean canPermute(String s, int[] map) {
		int count = 0;
		for(int i=0; i<s.length(); i++) {
			map[s.charAt(i)]++;
			if(map[s.charAt(i)]%2==0) {
				count--;
			} else {
				count++;
			}
		}
		return count<=1;
	}
	
	void permute(char[] s, int l, char ch) {
		if(l==s.length) {
			set.add(new String(s) + (ch==0?"":ch)+ new StringBuffer(new String(s)).reverse());
		} else {
			for(int i=l; i<s.length; i++) {
				if(s[l]!=s[i] || l==i) {
					swap(s, l, i);
					permute(s, l+1, ch);
					swap(s, l, i);
				}
			}
		}
	}
	
	public void swap(char[] s, int i, int j) {
		char tmp = s[i];
		s[i] = s[j];
		s[j] = tmp;
	}
	public static void main(String[] args) {
		Solution267 ss = new Solution267();
		int[][] matrix = new int[][]{
				{1, 2, 3},
				{4, 5, 7},
				{8, 9, 10}
		};
		System.out.println(ss.search(matrix, 1));
		System.out.println(ss.search(matrix, 2));
		System.out.println(ss.search(matrix, 3));
		System.out.println(ss.search(matrix, 4));
		System.out.println(ss.search(matrix, 5));
		System.out.println(ss.search(matrix, 6));
		System.out.println(ss.search(matrix, 7));
		System.out.println(ss.search(matrix, 8));
		System.out.println(ss.search(matrix, 9));
		System.out.println(ss.search(matrix, 10));
		System.out.println(ss.search(matrix, 11));

	}
}
