package laicode_java;
import java.util.*;

//Determine if one string is another's substring
public class Solution49 {
	//复制java文件
	//for i in {3..100}; do cp Solution2.java "Solution$i.java"; done
	//分离某一行然后替换
	//for i in {3..100}; do head -3 "Solution$i.java" | tail -1 $1 | awk '{split($0, a, ' '); print a[3]' ; done
	//sed -i ' ' 's/hi/hello/' file1
	//更改后复制到新文件
	//awk 'NR==2{gsub("hi", "Hello", $1)}; {print $0}' file1 > newfile
	//代变量就必须要用“”双引号
	//for i in {3..100}; do sed -i " " "3s/Solution/Solution$i/" Solution$i.java ; done
	public int strstr1(String large, String small) {
		if(large.length()<small.length()) {
			return -1;
		}
		if(small.length()==0) {
			return 0;
		}
		for(int i=0;i<=large.length()-small.length();i++) {
			if(equals(large, i, small)) {
				return i;
			}
		}
		return -1;
	}
	
	public boolean equals(String large, int start, String small) {
		for(int i=0;i<small.length();i++) {
			if(large.charAt(i+start)!=small.charAt(i)) {
				return false;
			}
		}
		return true;
	}
	
	public int strstr2(String large, String small) {
		if(large.length()<small.length()) {
			return -1;
		}
		if(small.length()==0) {
			return 0;
		}
		int largePrime=101;
		int prime=31;
		int seed=1;
		int targetHash=small.charAt(0)%largePrime;
		for(int i=1;i<small.length();i++) {
			seed=moduleHash(seed, 0, prime, largePrime);
			targetHash=moduleHash(targetHash, small.charAt(i), prime, largePrime);
		}
		int hash=0;
		for(int i=0;i<small.length();i++) {
			hash=moduleHash(hash, large.charAt(i), prime, largePrime);
		}
		if(hash==targetHash && equals(large, 0, small)) {
			return 0;
		}
		for(int i=1;i<=large.length()-small.length();i++) {
			hash=nonNegative(hash-seed*large.charAt(i-1)%largePrime, largePrime);
			hash=moduleHash(hash, large.charAt(i+small.length()-1), prime, largePrime);
			if(hash==targetHash && equals(large, i, small)) {
				return i;
			}
		}
		return -1;
	}
	
	public int moduleHash(int hash, int addition, int prime, int largePrime) {
		return (hash*prime%largePrime+addition)%largePrime;
	}
	
	public int nonNegative(int hash, int largePrime) {
		if(hash<0) {
			hash+=largePrime;
		}
		return hash;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Solution49 s49 = new Solution49();
		int result=s49.strstr1("bcabc", "ab");
		System.out.println(result);
		result=s49.strstr2("bcabc", "aab");
		System.out.println(result);
		return;
	}
}
