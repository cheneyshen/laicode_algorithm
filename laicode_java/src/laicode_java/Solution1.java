package laicode_java;

import java.util.Arrays;

public class Solution1 {
	//复制java文件
	//for i in {3..100}; do cp Solution2.java "Solution$i.java"; done
	//分离某一行然后替换
	//for i in {3..100}; do head -3 "Solution$i.java" | tail -1 $1 | awk '{split($0, a, ' '); print a[3]' ; done
	//sed -i ' ' 's/hi/hello/' file1
	//更改后复制到新文件
	//awk 'NR==2{gsub("hi", "Hello", $1)}; {print $0}' file1 > newfile
	//代变量就必须要用“”双引号
	//for i in {3..100}; do sed -i " " "3s/Solution/Solution$i/" Solution$i.java ; done

    public void swap(int[] array, int left, int right) {
        int temp=array[left];
        array[left]=array[right];
        array[right]=temp;
    }
    public int[] selectionSort(int[]  array) {
        if (array==null || array.length<=1) {
            return array;
        }
        for (int i=0;i<array.length-1;i++) {
            int min=i;
            for (int j=i+1;j<array.length;j++) {
                if (array[j]<array[min]) {
                    min=j;
                }
            }
            swap(array, i, min);
        }
        return array;
    }
    public static void main(String[] args) {
        // write your code here
    	Solution1 solu1 = new Solution1();
        int[] array=null;
        array=solu1.selectionSort(array);
        System.out.println(Arrays.toString(array));
        array=new int[0];
        array=solu1.selectionSort(array);
        System.out.println(Arrays.toString(array));
        array=new int[]{1,2,3,4};
        array=solu1.selectionSort(array);
        System.out.println(Arrays.toString(array));
        array=new int[]{4,3,2,1};
        array=solu1.selectionSort(array);
        System.out.println(Arrays.toString(array));
        array=new int[]{4,3,5,2,1};
        array=solu1.selectionSort(array);
        System.out.println(Arrays.toString(array));
    }
}
