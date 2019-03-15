package laicode_java;

import java.util.*;

//    Top K Frequent Words
//    Given a composition with different kinds of words, return a list of the top K most frequent words in the composition.
//
//    Assumptions
//
//    the composition is not null and is not guaranteed to be sorted
//    K >= 1 and K could be larger than the number of distinct words in the composition, in this case, just return all the distinct words
//    Return
//
//    a list of words ordered from most frequent one to least frequent one (the list could be of size K or smaller than K)
//    Examples
//
//    Composition = ["a", "a", "b", "b", "b", "b", "c", "c", "c", "d"], top 2 frequent words are [“b”, “c”]
//    Composition = ["a", "a", "b", "b", "b", "b", "c", "c", "c", "d"], top 4 frequent words are [“b”, “c”, "a", "d"]
//    Composition = ["a", "a", "b", "b", "b", "b", "c", "c", "c", "d"], top 5 frequent words are [“b”, “c”, "a", "d"]
public class Solution067 {
	public String[] topKFrequent(String[] combo, int k) {
		Map<String, Integer> freq = new HashMap<>();
		for(String cur : combo) {
			freq.put(cur, freq.getOrDefault(cur, 0)+1);
		}
		PriorityQueue<Node> minHeap=new PriorityQueue<>(k, 
				new Comparator<Node>() {
			@Override
			public int compare(Node a, Node b) {
				if(a.cnt == b.cnt) {
					return a.str.compareTo(b.str);
				} else {
					return b.cnt - a.cnt;
				}
			}
		});
		for(Map.Entry<String, Integer> entry : freq.entrySet()) {
			minHeap.offer(new Node(entry.getKey(), entry.getValue()));
		}
		k = Math.min(k, freq.size());
		String[] res = new String[k];
		for(int i=0; i<k; i++) {
			res[i] = minHeap.poll().str;
		}
		return res;
	}
	
	class Node {
		String str;
		int cnt;
		public Node(String str, int cnt) {
			this.str = str;
			this.cnt = cnt;
		}
	}
	
	public static void main(String[] args) {


	}
}
