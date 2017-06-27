package laicode_java;

//Remove Adjacent Repeated Characters III
//Remove adjacent, repeated characters in a given string, leaving no character for each group of such characters. The characters in the string are sorted in ascending order.
//
//Assumptions
//
//Try to do it in place.
//Examples
//
//¡°aaaabbbc¡± is transferred to ¡°c¡±
//Corner Cases
//
//If the given string is null, we do not need to do anything.

public class Solution146 {
	public String deDup(String input) {
		int leng=input.length();
		if(leng<=1) {
			return input;
		}
		else {
			StringBuilder sb=new StringBuilder();
			sb.append(input.charAt(0));
			for(int i=1;i<leng;) {
				if(sb.length()>0 && input.charAt(i)==sb.charAt(sb.length()-1)) {
					while(i<leng && input.charAt(i)==sb.charAt(sb.length()-1)) {
						i++;
					}
					sb.deleteCharAt(sb.length()-1);
				}
				else {
					sb.append(input.charAt(i));
					i++;
				}
			}
			return sb.toString();
		}
	}
	
	public static void main(String[] args) {
		Solution146 s146 = new Solution146();
		String result=s146.deDup("aaaabbbcccc");
		System.out.println(result);
	}
}
