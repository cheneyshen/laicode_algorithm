package laicode_java;

import java.util.Arrays;

interface Dictionary {
	public Integer get(int index);
}

class DictImpl implements Dictionary {
	private int[] array;
	public DictImpl(int[] array) {
		this.array=array;
	}
	@Override
	public Integer get(int index) {
		if(array==null || index>=array.length) {
			return null;
		}
		return array[index];
	}
	
	@Override
	public String toString() {
		if(array==null) {
			return String.valueOf(null);
		}
		if(array.length<=0) {
			return Arrays.toString(array);
		}
		StringBuilder sb=new StringBuilder("[");
		for(int i=0;i<5;i++) {
			sb.append(array[i]).append(", ");
		}
		sb.append(".......,");
		for(int i=array.length-4;i<array.length;i++) {
			sb.append(array[i]);
			if(i!=array.length-1) {
				sb.append(", ");
			}
		}
		sb.append("]");
		return sb.toString();
	}
}
public class Solution14 {
	//复制java文件
	//for i in {3..100}; do cp Solution2.java "Solution$i.java"; done
	//分离某一行然后替换
	//for i in {3..100}; do head -3 "Solution$i.java" | tail -1 $1 | awk '{split($0, a, ' '); print a[3]' ; done
	//sed -i ' ' 's/hi/hello/' file1
	//更改后复制到新文件
	//awk 'NR==2{gsub("hi", "Hello", $1)}; {print $0}' file1 > newfile
	//代变量就必须要用“”双引号
	//for i in {3..100}; do sed -i " " "3s/Solution/Solution$i/" Solution$i.java ; done
	public int search(Dictionary dictionary, int target) {
		if(dictionary==null) {
			return -1;
		}
		int left=0, right=1;
		while(dictionary.get(right)!=null && dictionary.get(right)<target) {
			left=right;
			right=2*right;
		}
		return binarySearch(dictionary, target, left, right);
	}
	private int binarySearch(Dictionary dict, int target, int left, int right) {
		while(left<=right) {
			int mid=left+(right-left)/2;
			if(dict.get(mid)==null || dict.get(mid)>target) {
				right=mid-1;
			}
			else if(dict.get(mid)<target) {
				left=mid+1;
			}
			else {
				return mid;
			}
		}
		return -1;
	}
	
	public static int[] largeArray(int size) {
		int[] array=new int[size];
		for(int i=0;i<size;i++) {
			array[i]=i;
		}
		return array;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Solution14 s14 = new Solution14();
		DictImpl dict=new DictImpl(new int[0]);
		int target=0;
		System.out.println("Expect:-1, Actual:" + s14.search(dict, target));
		dict=new DictImpl(new int[]{1});
		target=0;
		System.out.println("Expect:-1, Actual:" + s14.search(dict, target));
		dict=new DictImpl(new int[]{1});
		target=0;
		System.out.println("Expect:-1, Actual:" + s14.search(dict, target));
		dict=new DictImpl(new int[]{1});
		target=1;
		System.out.println("Expect:0, Actual:" + s14.search(dict, target));
		dict=new DictImpl(new int[]{1});
		target=2;
		System.out.println("Expect:-1, Actual:" + s14.search(dict, target));
		dict=new DictImpl(new int[]{1});
		target=2;
		System.out.println("Expect:-1, Actual:" + s14.search(dict, target));
		dict=new DictImpl(new int[]{1,3});
		target=0;
		System.out.println("Expect:-1, Actual:" + s14.search(dict, target));
		dict=new DictImpl(new int[]{1,3});
		target=3;
		System.out.println("Expect:1, Actual:" + s14.search(dict, target));
		dict=new DictImpl(new int[]{1,3});
		target=2;
		System.out.println("Expect:-1, Actual:" + s14.search(dict, target));
		dict=new DictImpl(new int[]{1,3});
		target=4;
		System.out.println("Expect:-1, Actual:" + s14.search(dict, target));
		dict=new DictImpl(new int[]{1,3,4,4,6,10,11,12,15,15});
		target=0;
		System.out.println("Expect:-1, Actual:" + s14.search(dict, target));
		dict=new DictImpl(new int[]{1,3,4,4,6,10,11,12,15,15});
		target=6;
		System.out.println("Expect:4, Actual:" + s14.search(dict, target));
		dict=new DictImpl(new int[]{1,3,4,4,6,10,11,12,15,15});
		target=8;
		System.out.println("Expect:-1, Actual:" + s14.search(dict, target));
		dict=new DictImpl(largeArray(100000));
		target=99999;
		System.out.println("Expect:99999, Actual:" + s14.search(dict, target));
		target=100001;
		System.out.println("Expect:-1, Actual:" + s14.search(dict, target));
		return;
	}
}
