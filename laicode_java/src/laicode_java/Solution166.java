package laicode_java;

//Decompress String I
//Given a string in compressed form, decompress it to the original string. The adjacent repeated characters in the original string are compressed to have the character followed by the number of repeated occurrences. If the character does not have any adjacent repeated occurrences, it is not compressed.
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
//¡°acb2c4¡± ¡ú ¡°acbbcccc¡±

public class Solution166 {
	public String decompress(String input) {
	    int leng=input.length();
	    if(leng<=1) {
	    	return input;
	    }
	    String output="";
	    char current=input.charAt(0);
	    for(int i=0;i<leng;++i) {
	    	if(input.charAt(i)>'9') {
	    		current=input.charAt(i);
	    		output+=current;
	    	}
	    	else {
	    		for(char j='2';j<=input.charAt(i);j++) {
	    			output+=current;
	    		}
	    	}
	    }
	    return output;
	}
	
	public static void main(String[] args) {
		Solution166 s166=new Solution166();
		String result=s166.decompress("acb2c4");
		System.out.println(result);
	}
}