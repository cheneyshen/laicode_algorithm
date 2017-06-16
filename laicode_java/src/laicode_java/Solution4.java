package laicode_java;

import java.util.Arrays;

public class Solution4 {
	//复制java文件
	//for i in {3..100}; do cp Solution2.java "Solution$i.java"; done
	//分离某一行然后替换
	//for i in {3..100}; do head -3 "Solution$i.java" | tail -1 $1 | awk '{split($0, a, ' '); print a[3]' ; done
	//sed -i ' ' 's/hi/hello/' file1
	//更改后复制到新文件
	//awk 'NR==2{gsub("hi", "Hello", $1)}; {print $0}' file1 > newfile
	//代变量就必须要用“”双引号
	//for i in {3..100}; do sed -i " " "3s/Solution/Solution$i/" Solution$i.java ; done
	public int[] moveZero(int[] array) {
		if (array==null || array.length<=1) {
			return array;
		}
		int left=0, right=array.length-1;
		while (left<=right) {
			if (array[left]!=0) {
				left++;
			}
			else if (array[right]==0) {
				right--;
			}
			else {
				swap(array, left++, right--);
			}
		}
		return array;
	}
	
	private void swap(int[] array, int a, int b) {
		int temp=array[a];
		array[a]=array[b];
		array[b]=temp;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Solution4 s4 = new Solution4();
		int[] array=null;
		array=s4.moveZero(array);
        System.out.println(Arrays.toString(array));
		array = new int[]{0, 1, 0, 3, 4, 5, 6, 0, 0};
		array=s4.moveZero(array);
        System.out.println(Arrays.toString(array));
		return;
	}
}
