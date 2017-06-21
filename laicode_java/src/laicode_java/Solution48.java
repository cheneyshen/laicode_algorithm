package laicode_java;
import java.util.*;

//Remove adjacent repeated characters IV
public class Solution48 {
	//复制java文件
	//for i in {3..100}; do cp Solution2.java "Solution$i.java"; done
	//分离某一行然后替换
	//for i in {3..100}; do head -3 "Solution$i.java" | tail -1 $1 | awk '{split($0, a, ' '); print a[3]' ; done
	//sed -i ' ' 's/hi/hello/' file1
	//更改后复制到新文件
	//awk 'NR==2{gsub("hi", "Hello", $1)}; {print $0}' file1 > newfile
	//代变量就必须要用“”双引号
	//for i in {3..100}; do sed -i " " "3s/Solution/Solution$i/" Solution$i.java ; done
	public String deDup(String input) {
		if(input==null || input.length()<=1) {
			return input;
		}
		char[] array=input.toCharArray();
		int end=0;
		for(int i=1;i<array.length;i++) {
			if(end==-1 || array[i]!=array[end]) {
				array[++end]=array[i];
			}
			else {
				end--;
				while(i+1<array.length && array[i]==array[i+1]) {
					i++;
				}
			}
		}
		return new String(array, 0, end+1);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Solution48 s48 = new Solution48();
		String result=s48.deDup("abbbaaccz");
		System.out.println(result);
		return;
	}
}
