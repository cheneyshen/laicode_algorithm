package laicode_java;
import java.util.*;

public class Solution76 {
	//����java�ļ�
	//for i in {3..100}; do cp Solution2.java "Solution$i.java"; done
	//����ĳһ��Ȼ���滻
	//for i in {3..100}; do head -3 "Solution$i.java" | tail -1 $1 | awk '{split($0, a, ' '); print a[3]' ; done
	//sed -i ' ' 's/hi/hello/' file1
	//���ĺ��Ƶ����ļ�
	//awk 'NR==2{gsub("hi", "Hello", $1)}; {print $0}' file1 > newfile
	//�������ͱ���Ҫ�á���˫����
	//for i in {3..100}; do sed -i " " "3s/Solution/Solution$i/" Solution$i.java ; done

    public static String minWindow(String s, String t) {
        if(s==null || t==null || s.length()<1 || t.length()<1 || t.length() > s.length()) {
            return "";
        }
        Map<Character, Integer> table = new HashMap<>();
        for(char c:t.toCharArray()) {
            table.put(c, table.getOrDefault(c, 0)+1);
        }
        int minLen = Integer.MAX_VALUE;
        int request = 0;
        int minIndex = 0;
        int left =0, right=0;
        while(right<s.length()) {
            char cur = s.charAt(right);
            if(table.containsKey(cur)) {
                if(table.get(cur)>0) {
                    request++;
                }
                table.put(cur, table.get(cur)-1);
            }
            while(left<=right && request==t.length()) {
                if(minLen >= right-left+1) {
                    minLen = right-left+1;
                    minIndex = left;
                }
                char shrink = s.charAt(left);
                if(table.containsKey(shrink)) {
                    if(table.get(shrink) == 0) {
                        request--;
                    }
                    table.put(shrink, table.get(shrink)+1);
                }
                //System.out.println(s.substring(left, right+1));
                left++;
            }
            right++;
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minIndex, minIndex+minLen);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		minWindow("AAOBECODEBAANC", "AABC");
		return;
	}
}
