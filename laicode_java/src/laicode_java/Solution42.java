package laicode_java;
import java.util.*;

//Top k frequent words
public class Solution42 {
	//复制java文件
	//for i in {3..100}; do cp Solution2.java "Solution$i.java"; done
	//分离某一行然后替换
	//for i in {3..100}; do head -3 "Solution$i.java" | tail -1 $1 | awk '{split($0, a, ' '); print a[3]' ; done
	//sed -i ' ' 's/hi/hello/' file1
	//更改后复制到新文件
	//awk 'NR==2{gsub("hi", "Hello", $1)}; {print $0}' file1 > newfile
	//代变量就必须要用“”双引号
	//for i in {3..100}; do sed -i " " "3s/Solution/Solution$i/" Solution$i.java ; done
	public String[] topKFrequent(String[] combo, int k) {
		if(combo.length==0) {
			return new String[0];
		}
		Map<String, Integer> freqMap=getFreqMap(combo);
		PriorityQueue<Map.Entry<String, Integer>> minHeap=new PriorityQueue<>(k, new Comparator<Map.Entry<String, Integer>>() {
			@Override
			public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
				return e1.getValue().compareTo(e2.getValue());
			}
		});
		for(Map.Entry<String, Integer> entry:freqMap.entrySet()) {
			if(minHeap.size()<k) {
				minHeap.offer(entry);
			}
			else if(entry.getValue()>minHeap.peek().getValue()) {
				minHeap.poll();
				minHeap.offer(entry);
			}
		}
		return freqArray(minHeap);
	}
	
	private Map<String, Integer> getFreqMap(String[] combo) {
		Map<String, Integer> freqMap=new HashMap<>();
		for(String s:combo) {
			Integer freq=freqMap.get(s);
			if(freq==null) {
				freqMap.put(s, 1);
			}
			else {
				freqMap.put(s, freq+1);
			}
		}
		return freqMap;
	}
	
	private String[] freqArray(PriorityQueue<Map.Entry<String, Integer>> minHeap) {
		String[] result=new String[minHeap.size()];
		for(int i=minHeap.size()-1;i>=0;i--) {
			result[i]=minHeap.poll().getKey();
		}
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Solution42 s42 = new Solution42();
		String[] words= {"a", "a", "b", "b", "b", "b", "c", "c", "c", "d"};
		String[] result=s42.topKFrequent(words, 6);
		System.out.println(Arrays.toString(result));
		return;
	}
}
