package laicode_java;

import java.util.Arrays;

//K closest in sorted array
public class Solution13 {
	//复制java文件
	//for i in {3..100}; do cp Solution2.java "Solution$i.java"; done
	//分离某一行然后替换
	//for i in {3..100}; do head -3 "Solution$i.java" | tail -1 $1 | awk '{split($0, a, ' '); print a[3]' ; done
	//sed -i ' ' 's/hi/hello/' file1
	//更改后复制到新文件
	//awk 'NR==2{gsub("hi", "Hello", $1)}; {print $0}' file1 > newfile
	//代变量就必须要用“”双引号
	//for i in {3..100}; do sed -i " " "3s/Solution/Solution$i/" Solution$i.java ; done
	public int[] kCloset(int[] array, int target, int k) {
		if(array==null || array.length==0) 
			return array;
		if(k==0) {
			return new int[]{0};
		}
		int left=largestSmallerEqual(array, target);
		int right=left+1;
		int[] result=new int[k];
		for(int i=0;i<k;i++) {
			if(right>=array.length || left>0 && target-array[left]<=array[right]-target) {
				result[i]=array[left--];
			}
			else {
				result[i]=array[right++];
			}
		}
		return result;
	}
	
	private int largestSmallerEqual(int[] array, int target) {
		int left=0, right=array.length-1;
		while(left<right-1) {
			int mid=left+(right-left)/2;
			if(array[mid]<=target) {
				left=mid;
			}
			else {
				right=mid;
			}
		}
		if(array[right]<=target) {
			return right;
		}
		if(array[left]<=target) {
			return left;
		}
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Solution13 s13 = new Solution13();
		int[] matrix={1,2,3};
		int target=2, k=3;
		int[] result=s13.kCloset(matrix, target, k);
		System.out.println(Arrays.toString(result));
		return;
	}
}
