package laicode_java;
import java.util.*;

//String shuffling
public class Solution54 {
	//复制java文件
	//for i in {3..100}; do cp Solution2.java "Solution$i.java"; done
	//分离某一行然后替换
	//for i in {3..100}; do head -3 "Solution$i.java" | tail -1 $1 | awk '{split($0, a, ' '); print a[3]' ; done
	//sed -i ' ' 's/hi/hello/' file1
	//更改后复制到新文件
	//awk 'NR==2{gsub("hi", "Hello", $1)}; {print $0}' file1 > newfile
	//代变量就必须要用“”双引号
	//for i in {3..100}; do sed -i " " "3s/Solution/Solution$i/" Solution$i.java ; done
	public int[] reorder(int[] array) {
		if(array.length%2==0) {
			reorder(array, 0, array.length-1);
		}
		else {
			reorder(array, 0, array.length-2);
		}
		return array;
	}
	
	private void reorder(int[] array, int left, int right) {
		int length=right-left+1;
		if(length<=2) {
			return;
		}
		int mid=left+length/2;
		int lmid=left+length/4;
		int rmid=left+length*3/4;
		reverse(array, lmid, mid-1);
		reverse(array, mid, rmid-1);
		reverse(array, lmid, rmid-1);
		reorder(array, left, left+(lmid-left)*2-1);
		reorder(array, left+(lmid-left)*2, right);
	}
	
	private void reverse(int[] array, int left, int right) {
		while(left<right) {
			int temp=array[left];
			array[left]=array[right];
			array[right]=temp;
			left++;
			right--;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Solution54 s54 = new Solution54();
		int[] array={1,2,3,4,5,6,7,8,9};
		array=s54.reorder(array);
		System.out.println(Arrays.toString(array));
		return;
	}
}
