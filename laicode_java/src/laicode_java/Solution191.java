package laicode_java;

import java.util.*;

//Largest Product Of Length
//Given a dictionary containing many words, find the largest product of two words鈥� lengths, such that the two words do not share any common characters.
//  
//  Assumptions
//  The words only contains characters of 'a' to 'z'
//  The dictionary is not null and does not contains null string, and has at least two strings
//  If there is no such pair of words, just return 0
//  Examples
//  dictionary = [“abcde”, “abcd”, “ade”, “xy”], the largest product is 5 * 2 = 10 (by choosing “abcde” and “xy”)
public class Solution191 {
	static class Pair {
		public String o1;
		public int i1;
		public String o2;
		public int i2;
		public Pair(String o1, int i1, String o2, int i2) {
			this.o1 = o1;
			this.i1 = i1;
			this.o2 = o2;
			this.i2 = i2;
		}
	}
	
	public int largestProduct(String[] dict) {
		if(dict.length<2) {
			return 0;
		}
		Arrays.sort(dict, new Comparator<String>(){
			@Override
			public int compare(String o1, String o2) {
				return o2.length()-o1.length();
			}
		});
		int[] result=new int[1];
		result[0]=0;
		PriorityQueue<Pair> queue = new PriorityQueue<Pair>(11);
		helper(dict, 0, 1, queue, result);
		return result[0];
	}
	
	private void helper(String[] dict, int m, int n, PriorityQueue<Pair> queue, int[] result) {
		int leng=dict.length;
		Pair e = new Pair(dict[m], m, dict[n], n);
		queue.add(e);
		while(!queue.isEmpty() && result[0]==0) {
			Pair curr = queue.poll();
			if(allUnique(curr.o1, curr.o2)) {
				result[0] = curr.o1.length()*curr.o2.length();
				return;
			}
			if(m+1<n && n<leng) {
				helper(dict, m+1, n, queue, result);
			}
			if(m<n && n+1<leng) {
				helper(dict, m, n+1, queue, result);
			}
		}
		return;
	}
	
	private boolean allUnique(String o1, String o2) {
		int[] checker = new int[8];
		for(int i=0; i<o1.length(); i++) {
			int aa=o1.charAt(i)/32;
			int bb=o1.charAt(i)%32;
			checker[aa] |= (1<<bb);
		}
		for(int j=0; j<o2.length(); j++) {
			int aa=o2.charAt(j)/32;
			int bb=o2.charAt(j)%32;
			if(checker[aa]>>>bb!=0) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		Solution191 ss = new Solution191();
		String[] dict = new String[]{"abcde", "abcd", "ade", "xy"};
		int result;
		result = ss.largestProduct(dict);
		System.out.println(result);
	}
}
