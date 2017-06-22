package laicode_java;
import java.util.*;

//All permutations II(with duplicate chars)
public class Solution55 {
	//复制java文件
	//for i in {3..100}; do cp Solution2.java "Solution$i.java"; done
	//分离某一行然后替换
	//for i in {3..100}; do head -3 "Solution$i.java" | tail -1 $1 | awk '{split($0, a, ' '); print a[3]' ; done
	//sed -i ' ' 's/hi/hello/' file1
	//更改后复制到新文件
	//awk 'NR==2{gsub("hi", "Hello", $1)}; {print $0}' file1 > newfile
	//代变量就必须要用“”双引号
	//for i in {3..100}; do sed -i " " "3s/Solution/Solution$i/" Solution$i.java ; done
	public List<String> permutations(String set) {
		List<String> result=new ArrayList<String>();
		if(set==null) {
			return result;
		}
		char[] array=set.toCharArray();
		helper(array, 0, result);
		return result;
	}
	
	private void helper(char[] array, int index, List<String> result) {
		if(index==array.length) {
			result.add(new String(array));
			return;
		}
		Set<Character> used = new HashSet<Character>();
		for(int i=index;i<array.length;i++) {
			if(used.add(array[i])) {
				swap(array, i, index);
				helper(array, index+1, result);
				swap(array, i, index);
			}
		}
	}
	
	private void swap(char[] array, int left, int right) {
		char tmp=array[left];
		array[left]=array[right];
		array[right]=tmp;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Solution55 s55 = new Solution55();
		List<String> result=s55.permutations("hello");
		System.out.println(result);
		return;
	}
}
