package laicode_java;
import java.io.*;
import java.util.*;
public class Solution91 {
	//����java�ļ�
	//for i in {3..100}; do cp Solution2.java "Solution$i.java"; done
	//����ĳһ��Ȼ���滻
	//for i in {3..100}; do head -3 "Solution$i.java" | tail -1 $1 | awk '{split($0, a, ' '); print a[3]' ; done
	//sed -i ' ' 's/hi/hello/' file1
	//���ĺ��Ƶ����ļ�
	//awk 'NR==2{gsub("hi", "Hello", $1)}; {print $0}' file1 > newfile
	//�������ͱ���Ҫ�á���˫����
	//for i in {3..100}; do sed -i " " "3s/Solution/Solution$i/" Solution$i.java ; done
	public void printit() {
		System.out.println("aa");
	}
	public static int numDecoding(String s) {
		return numDecoding(s, 0);
	}
	
	private static int numDecoding(String s, int i) {
		if(s==null) {
			return 0;
		}
		if(s.isEmpty() || s.length()==i) {
			return 1;
		}
		if(s.charAt(i)=='0') {
			return 0;
		}
		int result = numDecoding(s, i+1);
		if(i<s.length()-1 && (s.charAt(i)=='1' || (s.charAt(i)=='2' && s.charAt(i+1)<'7'))) {
			result += numDecoding(s, i+2);
		}
		return result;
	}
	
	private static int numDecoding1(String s) {
		if(s==null) {
			return 0;
		}
		if(s.isEmpty() || s.length()==0) {
			return 1;
		}
		if(s.charAt(0)=='0') {
			return 0;
		}
		int[] dp = new int[3];
		dp[0] = 1;
		dp[1] = s.charAt(0)=='0' ? 0 : 1;
		for(int i=2; i<=s.length(); i++) {
			dp[2] = dp[1];
			if(s.charAt(i-2)=='1' || (s.charAt(i-2)=='2' && s.charAt(i-1)<'7')) {
				dp[2] += dp[0];
			}
			dp[0] = dp[1]; dp[1] = dp[2];
		}
		return dp[2];
	}
	
    public int minSubArrayLen(int s, int[] nums) {
        if(nums==null || nums.length<1) {
            return 0;
        }
        int res = Integer.MAX_VALUE;
        
        int sum = 0;
        for(int i=0, j=0; i<nums.length; i++) {
            sum += nums[i];
            while(sum>=s) {
                sum-=nums[j];
                j++;
                if(i-j<res) {
                    res = i-j+1;
                }
            }
        }
        return res;
    }
    
    static class Pair {
        String a;
        String b;
        String c;
        String str;
        public Pair(String a, String b, String c, String str) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.str = str;
        }
    }
    static List<String> getAnswer(List<List<String>> relations, String start, String end) {
        Set<String> visited = new HashSet<>();
        Map<String, List<List<String>>> map = new HashMap<>();
        Queue<Pair> que = new LinkedList<>();
        for(int i=0; i<relations.size(); i++) {
        	String curr = relations.get(i).get(0);
            if(map.containsKey(curr) == false) {
            	List<List<String>> lls = new ArrayList<>();
                map.put(curr, lls);
            }
            List<String> tmp = Arrays.asList(relations.get(i).get(1), relations.get(i).get(2));
            map.get(curr).add(tmp);
            if(curr.equals(start)) {
                que.add(new Pair(relations.get(i).get(0),relations.get(i).get(1),relations.get(i).get(2), ""));
            }
        }
        List<String> output = new ArrayList<>();
        while(!que.isEmpty()) {
            Pair curr = que.poll(); // bart son, homer
            visited.add(curr.a + curr.b + curr.c);
            if(curr.c.equals(end)) {
            	if(curr.str.length()>0) {
            		output.add(curr.str + " " + curr.b + " " + curr.c);
            	} else {
            		output.add(curr.a + " " + curr.b + " "  + curr.c);
            	}
            } else {
                List<List<String>> combo = map.get(curr.c);
                if(combo.size()>0) {
                    for(int j=0; j<combo.size(); j++) {
                    	String str1 = curr.c + combo.get(j).get(0) + combo.get(j).get(1);
						if(visited.contains(str1)==false) {
							String str2 = curr.a + " " + curr.b + " " + curr.c;
					        Pair tmp = new Pair(curr.c, combo.get(j).get(0), combo.get(j).get(1), str2);
					        que.offer(tmp);
						}
                    }
                }
            }
        }
        return output;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(numDecoding1("123"));
		System.out.println(numDecoding("123"));
		System.out.println(numDecoding1("1234567"));
		System.out.println(numDecoding("1234567"));
		List<List<String>> relations = new ArrayList<>();
		List<String> tmp;
		tmp = Arrays.asList("Bart", "son", "Homer");
		relations.add(tmp);
		tmp = Arrays.asList("Bart", "brother", "Lisa");
		relations.add(tmp);
		tmp = Arrays.asList("Marge", "wife", "Homer");
		relations.add(tmp);
		tmp = Arrays.asList("Lisa", "daughter", "Homer");
		relations.add(tmp);
		List<String> res = getAnswer(relations, "Bart", "Homer");
		System.out.println(res);
		return;
	}
}
