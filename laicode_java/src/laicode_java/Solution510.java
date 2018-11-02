package laicode_java;

import java.util.*;
import java.io.*;
/*
 * Orbital Insight
 */
public class Solution510 {
	class Pair{
		char c;
		int freq;
		public Pair(char c, int freq) {
			this.c = c;
			this.freq = freq;
		}
	}

	public List<Character> getMost(String str, int k) {
		List<Character> result = new ArrayList<>();
		
		if(str==null || str.length()<1) {
			return result;
		}
		char[] array  = str.toCharArray();
		PriorityQueue<Pair> pq = new PriorityQueue<>(k, new Comparator<Pair>() {
			public int compare(Pair a, Pair b) {
				return b.freq - a.freq;
			}
		});
		Map<Character, Integer> dict = new HashMap<>();
		for(int i = 0; i<array.length; i++) {
			dict.put(array[i], dict.getOrDefault(array[i], 0)+1);
		}
		for(Map.Entry<Character, Integer>  entry:dict.entrySet()) {
			pq.offer(new Pair(entry.getKey(), entry.getValue()));
		}
		for(int i=0; i<k; i++) {
			if(pq.isEmpty()==false) {
				result.add(pq.poll().c);
			}
		}
		return result;
	}
	int calculates(String s) {
		Stack<Integer> stk1 = new Stack<>();
		Stack<String> stk2 = new Stack<>();
		int num = 0;
		int sign = 1;
		String opr = "";
		char[] array = s.toCharArray();
		for(int i=0; i<array.length; i++) {
			char c = array[i];
			if(c>='0' && c<='9') {
				num = num*10 + c-'0';
			} else if(c=='+' || c=='-') {
				sign = c=='+' ? 1 : -1;
			} else if(c>='a' && c<='z') {
				opr += c;
			} else if(c=='(') {
				if(opr.equals("sub")==false && opr.equals("add")==false) {
					System.out.println("error at index:" + s.indexOf(opr));
					return -1;
				}
				stk2.push(opr);
				opr = "";
			} else if(c == ',') {
				if(num!=0) {
					num = sign * num;
					stk1.push(num);
				}
				sign = 1;
				num = 0;
			} else if(c == ')') {
				int res = 0;
				if(stk1.empty()==false) {
					res = stk1.pop();
				} else {
					System.out.println("error");
					return -1;
				}
				String tmp = stk2.peek();
				if(tmp.equals("add")) {
					res += num*sign;
					stk1.push(res);
				} else if(tmp.equals("sub")) {
					res -= num*sign;
					stk1.push(res);
				}
				num = 0;
				sign = 1;
				stk2.pop();
			}
		}
		return stk1.empty()==false ? stk1.peek() : -1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution510 s = new Solution510();
		String input = "ABCBCC";
		System.out.println(s.getMost(input, 2));
		input = "sub( add( 3, -1),  2 )";
		System.out.println(s.calculates(input));
	}

}
