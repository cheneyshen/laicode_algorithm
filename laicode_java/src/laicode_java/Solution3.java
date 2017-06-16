package laicode_java;

import java.util.Arrays;

public class Solution3 {
	//复制java文件
	//for i in {3..100}; do cp Solution2.java "Solution$i.java"; done
	//分离某一行然后替换
	//for i in {3..100}; do head -3 "Solution$i.java" | tail -1 $1 | awk '{split($0, a, ' '); print a[3]' ; done
	//sed -i ' ' 's/hi/hello/' file1
	//更改后复制到新文件
	//awk 'NR==2{gsub("hi", "Hello", $1)}; {print $0}' file1 > newfile
	//代变量就必须要用“”双引号
	//for i in {3..100}; do sed -i " " "3s/Solution/Solution$i/" Solution$i.java ; done
	public int[] quickSort(int[] array) {
		if (array==null) {
			return array;
		}
		quickSort(array, 0, array.length-1);
		return array;
	}
	
	public void quickSort(int[] array, int left, int right) {
		if (left>=right) {
			return;
		}
		int pivot=partition(array, left, right);
		quickSort(array, left, pivot-1);
		quickSort(array, pivot+1, right);
	}
	
	private int partition(int[] array, int left, int right) {
		int pivotIndex=pivotIndex(left, right);
		int pivot=array[pivotIndex];
		swap(array, pivotIndex, right);
		int leftb=left;
		int rightb=right-1;
		while (leftb<=rightb) {
			if (array[leftb]<pivot) {
				leftb++;
			}
			else if(array[rightb]>=pivot) {
				rightb--;
			}
			else {
				swap(array, leftb++, rightb--);
			}
		}
		swap(array, leftb, right);
		return leftb;
	}
	
	private int pivotIndex(int left, int right) {
		return left+(right-left+1)*(int)Math.random();
	}
	
	private void swap(int[] array, int left, int right) {
		int temp=array[left];
		array[left]=array[right];
		array[right]=temp;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Solution3 s3 = new Solution3();
		int[] array=null;
		array=s3.quickSort(array);
        System.out.println(Arrays.toString(array));
        array=new int[0];
		array=s3.quickSort(array);
        System.out.println(Arrays.toString(array));
        array=new int[]{1,2,3,4};
		array=s3.quickSort(array);
        System.out.println(Arrays.toString(array));
        array=new int[]{4,3,2,1};
		array=s3.quickSort(array);
        System.out.println(Arrays.toString(array));
        array=new int[]{4,3,5,2,1};
		array=s3.quickSort(array);
        System.out.println(Arrays.toString(array));
		return;
	}
}
