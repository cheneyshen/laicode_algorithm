package laicode_java;

import java.util.*;

//Compact Divide
//Given two integers a and b, return the result of a / b in String with compact format. The repeated decimal part should be identified and enclosed by "()".
//Examples
//
//0 / 2 = "0"
//4 / 2 = "2"
//1 / 2 = "0.5"
//-14 / 12 = "-1.1(6)"
//1 / 11 = "0.(09)"
//1 / 0 = "NaN"
//-1 / 0 = "NaN"
public class Solution318 {
	// Function to count number of substrings
    // with exactly k unique characters
    List<String> countkDist(String str, int k)
    {
        // Initialize result
        List<String> result = new ArrayList<String>();
        HashSet<String> map = new HashSet<>(); 
        int n = str.length();
 
        // To store count of characters from 'a' to 'z'
        int cnt[] = new int[26];
 
        // Consider all substrings beginning with
        // str[i]
        for (int i = 0; i <= n-k; i++)
        {
            int dist_count = 0;
 
            // Initializing count array with 0
            Arrays.fill(cnt, 0);
 
            // Consider all substrings between str[i..j]
            for (int j=i; j<n && j<i+k; j++)
            {
                // If this is a new character for this
                // substring, increment dist_count.
                if (cnt[str.charAt(j) - 'a'] == 0)
                    dist_count++;
 
                // Increment count of current character
                cnt[str.charAt(j) - 'a']++;
 
                // If distinct character count becomes k,
                // then increment result.
                if (dist_count == k && map.contains(str.substring(i, i+k))==false) {
                    result.add(str.substring(i, i+k));
                	map.add(str.substring(i, i+k));
                }
            }
        }
 
        return result;
    }
 
    // Driver Program
    public static void main(String[] args)
    {
        Solution318 ob = new Solution318();
        String ch = "abcd";
        int k = 3;
        System.out.println("Total substrings with exactly " +
                           k +  " distinct characters : "
                           + ob.countkDist(ch, k));
    }

}
