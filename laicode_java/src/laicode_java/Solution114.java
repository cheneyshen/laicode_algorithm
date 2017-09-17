package laicode_java;

import java.util.*;

//    95 Percentile
//    Given a list of integers representing the lengths of urls, find the 95 percentile of all lengths (95% of the urls have lengths <= returned length).
//
//    Assumptions
//
//    The maximum length of valid url is 4096
//
//    The list is not null and is not empty and does not contain null
//
//    Examples
//
//    [1, 2, 3, ..., 95, 96, 97, 98, 99, 100], 95 percentile of all lengths is 95.
public class Solution114 {
	public int percentile95(List<Integer> lengths) {
		int [] count = new int[4097];
		for(int leng : lengths) {
			count[leng]++;
		}
		int sum=0;
		int len=4097;
		while(sum<=0.05 * lengths.size()) {
			sum += count[--len];
		}
		return len;
	}
	
	public static void main(String[] args) {


	}
}
