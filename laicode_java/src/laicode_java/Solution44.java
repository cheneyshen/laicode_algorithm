package laicode_java;
import java.util.*;
//Common numbers of two sorted arrays
public class Solution44 {
	//复制java文件
	//for i in {3..100}; do cp Solution2.java "Solution$i.java"; done
	//分离某一行然后替换
	//for i in {3..100}; do head -3 "Solution$i.java" | tail -1 $1 | awk '{split($0, a, ' '); print a[3]' ; done
	//sed -i ' ' 's/hi/hello/' file1
	//更改后复制到新文件
	//awk 'NR==2{gsub("hi", "Hello", $1)}; {print $0}' file1 > newfile
	//代变量就必须要用“”双引号
	//for i in {3..100}; do sed -i " " "3s/Solution/Solution$i/" Solution$i.java ; done
	public List<Integer> common1(int[] a, int[] b) {
		List<Integer> common=new ArrayList<Integer>();
		int i=0,j=0;
		while(i<a.length && j<b.length) {
			if(a[i]==b[j]) {
				common.add(a[i]);
				i++;
				j++;
			}
			else if(a[i]<b[j]) {
				i++;
			}
			else {
				j++;
			}
		}
		return common;
	}
	
	public List<Integer> common2(int[] a, int[] b) {
		List<Integer> common=new ArrayList<Integer>();
		HashMap<Integer, Integer> countA=new HashMap<Integer, Integer>();
		for(int num:a) {
			Integer ct=countA.get(num);
			if(ct!=null) {
				countA.put(num, ct+1);
			}
			else {
				countA.put(num, 1);
			}
		}
		HashMap<Integer, Integer> countB=new HashMap<Integer, Integer>();
		for(int num:b) {
			Integer ct=countB.get(num);
			if(ct!=null) {
				countB.put(num, ct+1);
			}
			else {
				countB.put(num, 1);
			}
		}
		for(Map.Entry<Integer, Integer> entry:countA.entrySet()) {
			Integer ctInb = countB.get(entry.getKey());
			if(ctInb!=null) {
				int appear=Math.min(entry.getValue(), ctInb);
				for(int i=0;i<appear;i++) {
					common.add(entry.getKey());
				}
			}
		}
		return common;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Solution44 s44 = new Solution44();
		int[] a={1,2,3,3,5,5,6,7,7,8,8};
		int[] b={2,3,3,6,6,6,7,7,7,8,8};
		List<Integer> result=s44.common1(a, b);
		System.out.println(result.toString());
		result=s44.common2(a, b);
		System.out.println(result.toString());
		return;
	}
}
