package laicode_java;
import java.util.*;

//Missing number I
public class Solution43 {
	//复制java文件
	//for i in {3..100}; do cp Solution2.java "Solution$i.java"; done
	//分离某一行然后替换
	//for i in {3..100}; do head -3 "Solution$i.java" | tail -1 $1 | awk '{split($0, a, ' '); print a[3]' ; done
	//sed -i ' ' 's/hi/hello/' file1
	//更改后复制到新文件
	//awk 'NR==2{gsub("hi", "Hello", $1)}; {print $0}' file1 > newfile
	//代变量就必须要用“”双引号
	//for i in {3..100}; do sed -i " " "3s/Solution/Solution$i/" Solution$i.java ; done
	public int missing1(int[] array) {
		int n=array.length+1;
		HashSet<Integer> set=new HashSet<Integer>();
		for(int number:array) {
			set.add(number);
		}
		for(int i=1;i<n;i++) {
			if(!set.contains(i)) {
				return i;
			}
		}
		return n;
	}
	
	public int missing2(int[] array) {
		int n=array.length+1;
		long targetSum=(n+0L)*(n+1)/2;
		long actualSum=0L;
		for(int num:array) {
			actualSum+=num;
		}
		return (int)(targetSum-actualSum);
	}
	
	public int missing3(int[] array) {
		int n=array.length+1;
		int xor=0;
		for(int i=1;i<=n;i++) {
			xor^=i;
		}
		for(int num:array) {
			xor^=num;
		}
		return xor;
	}
	
	public int missing4(int[] array) {
		for(int i=0;i<array.length;i++) {
			while(array[i]!=i+1 && array[i]!=array.length+1) {
				swap(array, i, array[i]-1);
			}
		}
		for(int i=0;i<array.length;i++) {
			if(array[i]!=i+1) {
				return i+1;
			}
		}
		return array.length+1;
	}
	
	private void swap(int[] array, int i, int j) {
		int temp=array[i];
		array[i]=array[j];
		array[j]=temp;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Solution43 s43=new Solution43();
		int[] array={2, 1, 4};
		int result=s43.missing1(array);
		System.out.println(result);
		result=s43.missing2(array);
		System.out.println(result);
		result=s43.missing3(array);
		System.out.println(result);
		result=s43.missing4(array);
		System.out.println(result);
		return;
	}
}
