package laicode_java;
import java.util.*;

public class Solution726 {
    public static String countOfAtoms(String formula) {
        if(formula == null || formula.length()<1) {
            return formula;
        }
        Map<String, Integer> cur = new TreeMap<String, Integer>();
        cur = counter(formula);
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<String, Integer> entry:cur.entrySet()) {
            //System.out.println(entry.getKey() + entry.getValue());
            if(entry.getValue() == 1) {
                sb.append(entry.getKey());
            } else {
                sb.append(entry.getKey() + entry.getValue());
            }
        }
        return sb.toString();
    }
    private static Map<String, Integer> counter(String formula) {
        if(formula == null || formula.length()<1) {
            Map<String, Integer> cur = new TreeMap<>();
            return cur;
        }
        if(formula.indexOf("(") == -1) {
            return helper(formula);
        } else {
            int left = formula.indexOf("(");
            char[] arr = formula.toCharArray();
            int count=0;
            int index=left;
            for(; index<arr.length; index++) {
                if(arr[index]=='(') {
                    count++;
                } else if(arr[index]==')') {
                    count--;
                    if(count==0) {
                        break;
                    }
                }
            }
            Map<String, Integer> cur = helper(formula.substring(0, left));
            Map<String, Integer> child = counter(formula.substring(left+1, index));
            count = 0;
            index += 1;
            while(index<arr.length && arr[index]>='0' && arr[index]<='9') {
                count = count*10 + arr[index] - '0';
                index++;
            }
            count = count==0 ? 1: count;
            merger(cur, child, count);
            merger(cur, counter(formula.substring(index)), 1);
            return cur;
        }
    }
    
    private static void merger(Map<String, Integer> res, Map<String, Integer> cur, int count) {
        System.out.println(res);
        System.out.println(cur);
        System.out.println(count);
        for(Map.Entry<String, Integer> entry:cur.entrySet()) {
            res.put(entry.getKey(), res.getOrDefault(entry.getKey(), 0) + entry.getValue()*count);
        }
    }
    
    private static Map<String, Integer> helper(String formula) {
        if(formula == null) {
            return null;
        }
        Map<String, Integer> dict = new TreeMap<String, Integer>();
        char[] arr = formula.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<arr.length;) {
            sb = new StringBuilder();
            if(i<arr.length && (arr[i]>='A' && arr[i]<='Z')) {
                sb.append(arr[i]);
                i++;
                while(i<arr.length && (arr[i]>='a' && arr[i]<='z')) {
                    sb.append(arr[i]);
                    i++;
                }
            }
            int num = 0;
            while(i<arr.length && (arr[i]>='0' && arr[i]<='9')) {
                num = num*10 + arr[i] - '0';
                i++;
            }
            num = num==0 ? 1 : num;
            dict.put(sb.toString(), dict.getOrDefault(sb.toString(), 0) + num);
        }
        return dict;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		countOfAtoms("Mg(OH)2");
		countOfAtoms("H50");
	}

}
