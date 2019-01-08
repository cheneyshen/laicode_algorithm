package laicode_java;
import java.util.*;

//Find all anagrams of short string in a long string
public class Solution58 {
	//����java�ļ�
	//for i in {3..100}; do cp Solution2.java "Solution$i.java"; done
	//����ĳһ��Ȼ���滻
	//for i in {3..100}; do head -3 "Solution$i.java" | tail -1 $1 | awk '{split($0, a, ' '); print a[3]' ; done
	//sed -i ' ' 's/hi/hello/' file1
	//���ĺ��Ƶ����ļ�
	//awk 'NR==2{gsub("hi", "Hello", $1)}; {print $0}' file1 > newfile
	//�������ͱ���Ҫ�á���˫����
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
		Map<Character, Integer> map2 = new HashMap<>();
		for(int i=0;i<l.length();i++) {
			char tmp=l.charAt(i);
			if(map.containsKey(tmp)) {
				map2.put(tmp, map2.getOrDefault(tmp, 0)+1);
				if(map2.get(tmp)==map.get(tmp)) {
					match++;
				}
			}
			if(i>=s.length()) {
				tmp=l.charAt(i-s.length());
				if(map.containsKey(tmp)) {
					map2.put(tmp, map2.get(tmp)-1);
					if(map2.get(tmp)<map.get(tmp)) {
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
			} else {
				map.put(ch, count+1);
			}
		}
		return map;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Solution58 s58 = new Solution58();
		List<Integer> result=s58.allAnagrams("ab", "ababacbac");
		System.out.println(result);
		final Integer i4=4;
		Integer i5=5;
		int a = 0x000F;
		int b = 0x2222;
		System.out.println(a&b);
		class Inner {
			final Integer i6=6;
			Integer i7=7;
			Inner() {
				System.out.println(i6+i7);
			}
		}
		return;
	}
}
