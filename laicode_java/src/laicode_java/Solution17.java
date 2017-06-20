package laicode_java;

import java.util.Arrays;
import java.util.LinkedList;

public class Solution17 {
	//复制java文件
	//for i in {3..100}; do cp Solution2.java "Solution$i.java"; done
	//分离某一行然后替换
	//for i in {3..100}; do head -3 "Solution$i.java" | tail -1 $1 | awk '{split($0, a, ' '); print a[3]' ; done
	//sed -i ' ' 's/hi/hello/' file1
	//更改后复制到新文件
	//awk 'NR==2{gsub("hi", "Hello", $1)}; {print $0}' file1 > newfile
	//代变量就必须要用“”双引号
	//for i in {3..100}; do sed -i " " "3s/Solution/Solution$i/" Solution$i.java ; done
	public void sort(LinkedList<Integer> s1) {
		LinkedList<Integer> s2=new LinkedList<Integer>();
		LinkedList<Integer> s3=new LinkedList<Integer>();
		sort(s1, s2, s3, s1.size());
	}
	private void sort(LinkedList<Integer> s1, LinkedList<Integer> s2, LinkedList<Integer> s3, int length) {
		if(length<=1) {
			return ;
		}
		int mid1=length/2;
		int mid2=length-mid1;
		for(int i=0;i<mid1;i++) {
			s2.offerFirst(s1.pollFirst());
		}
		sort(s2, s3, s1, mid1);
		sort(s1, s3, s2, mid2);
		int i=0,j=0;
		while(i<mid1 && j<mid2) {
			if(s2.peekFirst()<s1.peekFirst()) {
				s3.offerFirst(s2.pollFirst());
				i++;
			}
			else  {
				s3.offerFirst(s1.pollFirst());
				j++;
			}
		}
		while(i<mid1) {
			s3.offerFirst(s2.pollFirst());
			i++;
		}
		while(j<mid2) {
			s3.offerFirst(s1.pollFirst());
			j++;
		}
		for(int index=0;index<length;index++) {
			s1.offerFirst(s3.pollFirst());
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Solution17 s17 = new Solution17();
		Integer[] nums={111,13,54,53,62,28,19,10,11};
		LinkedList<Integer> array=new LinkedList<Integer>(Arrays.asList(nums));
		s17.sort(array);
		System.out.println(array);
		return;
	}
}
