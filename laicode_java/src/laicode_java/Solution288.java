package laicode_java;

import java.util.*;

/*First Non - Repeating Character In Stream
		Given a stream of characters, find the first non - repeating character from stream.You need to tell the first non - repeating character in O(1) time at any moment.
		Implement two methods of the class :
		read() - read one character from the stream
		firstNonRepeating() - return the first non - repeating character from the stream at any time when calling the method, return null if there does not exist such characters
		Examples :
read:
	a   b   c   a   c   c    b
		firstNonRepeating :
	a   a   a   b   b   b   null*/
public class Solution288 {
	
	final static int MAX_CHAR = 256;
	
	public char[] findFirstNonRepeating(char[] array)
	{
		// inDLL[x] contains pointer to a DLL node if x is present 
        // in DLL. If x is not present, then inDLL[x] is NULL
        List<Character> inDLL =new ArrayList<Character>();
         
        // repeated[x] is true if x is repeated two or more times.
        // If x is not seen so far or x is seen only once. then 
        // repeated[x] is false
        boolean[] repeated =new boolean[MAX_CHAR];
        char[] result = new char[array.length];
        // Let us consider following stream and see the process
     
        for (int i=0;i < array.length;i++)
        {
            char x = array[i];
             
            // We process this character only if it has not occurred
            // or occurred only once. repeated[x] is true if x is 
            // repeated twice or more.s
            if(!repeated[x])
            {
                // If the character is not in DLL, then add this at 
                // the end of DLL.
                if(!(inDLL.contains(x)))
                {
                    inDLL.add(x);
                }
                else    // Otherwise remove this character from DLL
                {
                    inDLL.remove((Character)x);
                    repeated[x] = true; // Also mark it as repeated
                }
            }
            
            if(inDLL.size() != 0)
            {
                result[i] = inDLL.get(0);
            } else {
            	result[i] = ' ';
            }
        }
        return result;
	}
	
	public static void main(String[] args) {
		Solution288 ss = new Solution288();
		char[] array = {'a',   'b',   'c',   'a',  'c',   'c',    'b'};
		array  = ss.findFirstNonRepeating(array);
		System.out.println(array);
	}
}
