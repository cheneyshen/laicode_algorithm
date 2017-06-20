package laicode_java;

import java.util.Arrays;

//Merge Sort
public class Solution2 {
	//复制java文件
	//for i in {3..100}; do cp Solution2.java "Solution$i.java"; done
	//分离某一行然后替换
	//for i in {3..100}; do head -3 "Solution$i.java" | tail -1 $1 | awk '{split($0, a, ' '); print a[3]' ; done
	//sed -i ' ' 's/hi/hello/' file1
	//更改后复制到新文件
	//awk 'NR==2{gsub("hi", "Hello", $1)}; {print $0}' file1 > newfile
	//代变量就必须要用“”双引号
	//for i in {3..100}; do sed -i " " "3s/Solution/Solution$i/" Solution$i.java ; done

    public int[] mergeSort(int[] array) {
        if (array==null) {
            return array;
        }
        int[] helper=new int[array.length];
        mergeSort(array, helper, 0, array.length-1);
        return array;
    }
    
    private void mergeSort(int[] array, int[] helper, int left, int right) {
    	if (left>=right) {
    		return;
    	}
    	int mid=left+(right-left)/2;
    	mergeSort(array, helper, left, mid);
    	mergeSort(array, helper, mid+1, right);
    	merge(array, helper, left, mid, right);
    }
    
    private void merge(int[] array, int[] helper, int left, int mid, int right) {
    	for (int i=left; i<=right; i++) {
    		helper[i]=array[i];
    	}
    	int lefti=left;
    	int righti=mid+1;
    	while (lefti<=mid && righti<=right) {
    		if (helper[lefti]<=helper[righti]) {
    			array[left++]=helper[lefti++];
    		}
    		else {
    			array[left++]=helper[righti++];
    		}
    	}
    	while (lefti<=mid) {
    		array[left++]=helper[lefti++];
    	}
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Solution2 s2 = new Solution2();
		int[] array=null;
		array=s2.mergeSort(array);
        System.out.println(Arrays.toString(array));
        array=new int[0];
		array=s2.mergeSort(array);
        System.out.println(Arrays.toString(array));
        array=new int[]{1,2,3,4};
		array=s2.mergeSort(array);
        System.out.println(Arrays.toString(array));
        array=new int[]{4,3,2,1};
		array=s2.mergeSort(array);
        System.out.println(Arrays.toString(array));
        array=new int[]{4,3,5,2,1};
		array=s2.mergeSort(array);
        System.out.println(Arrays.toString(array));
		return;
	}
}
