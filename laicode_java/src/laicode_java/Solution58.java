package laicode_java;
import java.util.*;

//Find all anagrams of short string in a long string
public class Solution58 {
	//复制java文件
	//for i in {3..100}; do cp Solution2.java "Solution$i.java"; done
	//分离某一行然后替换
	//for i in {3..100}; do head -3 "Solution$i.java" | tail -1 $1 | awk '{split($0, a, ' '); print a[3]' ; done
	//sed -i ' ' 's/hi/hello/' file1
	//更改后复制到新文件
	//awk 'NR==2{gsub("hi", "Hello", $1)}; {print $0}' file1 > newfile
	//代变量就必须要用“”双引号
	//for i in {3..100}; do sed -i " " "3s/Solution/Solution$i/" Solution$i.java ; done
	public List<Integer> allAnagrams(String s, String l) {
		List<Integer> result=new ArrayList<Integer>();
		if(l.length()==0) {
			return result;
		}
		if(s.length()>l.length()) {
			return result;
		}
		Map<Character, Integer> map=countMap(s);
		int match=0;
		for(int i=0;i<l.length();i++) {
			char tmp=l.charAt(i);
			Integer count=map.get(tmp);
			if(count!=null) {
				map.put(tmp, count-1);
				if(count==1) {
					match++;
				}
			}
			if(i>=s.length()) {
				tmp=l.charAt(i-s.length());
				count=map.get(tmp);
				if(count!=null) {
					map.put(tmp, count+1);
					if(count==0) {
						match--;
					}
				}
			}
			if(match==map.size()) {
				result.add(i-s.length()+1);
			}
		}
		return result;
	}
	
	private Map<Character, Integer> countMap(String s) {
		Map<Character, Integer> map=new HashMap<Character, Integer>();
		for(char ch:s.toCharArray()) {
			Integer count=map.get(ch);
			if(count==null) {
				map.put(ch, 1);
			}
			else {
				map.put(ch, count+1);
			}
		}
		return map;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Solution58 s58 = new Solution58();
		List<Integer> result=s58.allAnagrams("ab", "abcbac");
		System.out.println(result);
		return;
	}
}
