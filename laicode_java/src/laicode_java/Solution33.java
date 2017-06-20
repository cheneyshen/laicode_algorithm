package laicode_java;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

//K smallest in unsorted array
public class Solution33 {
	//复制java文件
	//for i in {3..100}; do cp Solution2.java "Solution$i.java"; done
	//分离某一行然后替换
	//for i in {3..100}; do head -3 "Solution$i.java" | tail -1 $1 | awk '{split($0, a, ' '); print a[3]' ; done
	//sed -i ' ' 's/hi/hello/' file1
	//更改后复制到新文件
	//awk 'NR==2{gsub("hi", "Hello", $1)}; {print $0}' file1 > newfile
	//代变量就必须要用“”双引号
	//for i in {3..100}; do sed -i " " "3s/Solution/Solution$i/" Solution$i.java ; done
	public int[] KSmallestI(int[] array, int k) {
		if(array.length==0 || k==0) {
			return new int[0];
		}
		PriorityQueue<Integer> maxHeap=new PriorityQueue<Integer>(k, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				if(o1.equals(o2)) {
					return 0;
				}
				return o1>o2?-1:1;
			}
		});
		for(int i=0;i<array.length;i++) {
			if(i<k) {
				maxHeap.offer(array[i]);
			}
			else if(array[i]<maxHeap.peek()) {
				maxHeap.poll();
				maxHeap.offer(array[i]);
			}
		}
		int[] result=new int[k];;
		for(int i=k-1;i>=0;i--) {
			result[i]=maxHeap.poll();
		}
		return result;
	}
	
	public int[] kSmallestII(int[] array, int k) {
		if(array.length==0 || k==0) {
			return new int[0];
		}
		quickSelect(array, 0, array.length-1, k-1);
		int[] result=Arrays.copyOf(array, k);
		Arrays.sort(result);
		return result;
	}
	
	private void quickSelect(int[] array, int left, int right, int target) {
		int mid=partition(array, left, right);
		if(mid==target) {
			return;
		}
		else if(target<mid) {
			quickSelect(array, left, mid-1, target);
		}
		else {
			quickSelect(array, mid+1, right, target);
		}
	}
	
	private int partition(int[] array, int left, int right) {
		int pivot=array[right];
		int start=left;
		int end=right-1;
		while(start<=end) {
			if(array[start]<pivot) {
				start++;
			}
			else if(array[end]>=pivot) {
				end--;
			}
			else {
				swap(array, start++, end--);
			}
		}
		swap(array, start, right);
		return start;
	}
	
	private void swap(int[] array, int a, int b) {
		int temp=array[a];
		array[a]=array[b];
		array[b]=temp;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Solution33 s33 = new Solution33();
		int[] array= {3, 4, 1, 2, 5};
		int[] result=s33.KSmallestI(array, 3);
		System.out.println(Arrays.toString(result));
		result=s33.kSmallestII(array, 3);
		System.out.println(Arrays.toString(result));
		return;
	}
}
