package laicode_java;

//Remove Adjacent Repeated Characters II
//Remove adjacent, repeated characters in a given string, leaving only two characters for each group of such characters. The characters in the string are sorted in ascending order.
//
//Assumptions
//
//Try to do it in place.
//Examples
//
//¡°aaaabbbc¡± is transferred to ¡°aabbc¡±
//Corner Cases
//
//If the given string is null, we do not need to do anything.

public class Solution145 {
	public String deDup(String input) {
		char[] array=input.toCharArray();
		int leng=input.length();
		if(leng<=2) {
			return input;
		}
		else {
			StringBuilder sb=new StringBuilder();
			sb.append(array[0]);
			sb.append(array[1]);
			for(int i=2;i<leng;i++) {
				if(array[i]==array[i-2]) {
					continue;
				}
				else {
					sb.append(array[i]);
				}
			}
			return sb.toString();
		}
	}
	
	public static void main(String[] args) {
		Solution145 s145 = new Solution145();
		String result=s145.deDup("aaaaaabbbbbbbbbcccccc");
		System.out.println(result);
	}
}