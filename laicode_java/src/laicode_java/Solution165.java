package laicode_java;

//Compress String
//Given a string, replace adjacent, repeated characters with the character followed by the number of repeated occurrences. If the character does not has any adjacent, repeated occurrences, it is not changed.
//
//Assumptions
//
//The string is not null
//
//The characters used in the original string are guaranteed to be ¡®a¡¯ - ¡®z¡¯
//
//There are no adjacent repeated characters with length > 9
//
//Examples
//
//¡°abbcccdeee¡± ¡ú ¡°ab2c3de3¡±

public class Solution165 {
	public String compress(String input) {
		int leng=input.length();
		if(leng<=1) {
			return input;
		}
		String output = "";
		output+=input.charAt(0);
		int count=1;
		for(int i=1;i<leng;) {
			while(i<leng && input.charAt(i)==input.charAt(i-1)) {
				count++;
				i++;
			}
			if(count>1) {
				output+=String.valueOf(count);
			}
			if(i<leng) {
				output+=input.charAt(i);
			}
			count=1;
			i++;
		}
		return output;
	}
	
	public static void main(String[] args) {
		Solution165 s165=new Solution165();
		String input="abbcccdeee";
		String output=s165.compress(input);
		System.out.println(output);
	}
}
