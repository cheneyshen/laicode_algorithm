package laicode_java;

import java.util.*;

//Integer to Roman
//Given an integer, convert it to a roman numeral. Input is guaranteed to be within the range from 1 to 3999.
public class Solution247 {
	public String intToRoman(int i) {
		/*	2345
		 *  last=5, i=234, idx=0, 
		 */
		String result="";
		int idx=0;
		while(i>0) {
			int lastDigit=i%10;
			i = i/10;
			switch(idx) {
			case 0:
				switch(lastDigit) {
				case 0:
					break;
				case 1:
					result = "I"+result;
					break;
				case 2:
					result = "II"+result;
					break;
				case 3:
					result = "III"+result;
					break;
				case 4:
					result = "IV"+result;
					break;
				case 5:
					result = "V"+result;
					break;
				case 6:
					result = "VI"+result;
					break;
				case 7:
					result = "VII"+result;
					break;
				case 8:
					result = "VIII"+result;
					break;
				case 9:
					result = "IX"+result;
					break;
				}
				idx++;
				break;
			case 1:
				switch(lastDigit) {
				case 0:
					break;
				case 1:
					result = "X"+result;
					break;
				case 2:
					result = "XX"+result;
					break;
				case 3:
					result = "XXX"+result;
					break;
				case 4:
					result = "XL"+result;
					break;
				case 5:
					result = "L"+result;
					break;
				case 6:
					result = "LX"+result;
					break;
				case 7:
					result = "LXX"+result;
					break;
				case 8:
					result = "LXXX"+result;
					break;
				case 9:
					result = "XC"+result;
					break;
				}
				idx++;
				break;
			case 2:
				switch(lastDigit) {
				case 0:
					break;
				case 1:
					result = "C"+result;
					break;
				case 2:
					result = "CC"+result;
					break;
				case 3:
					result = "CCC"+result;
					break;
				case 4:
					result = "CD"+result;
					break;
				case 5:
					result = "D"+result;
					break;
				case 6:
					result = "DC"+result;
					break;
				case 7:
					result = "DCC"+result;
					break;
				case 8:
					result = "DCCC"+result;
					break;
				case 9:
					result = "CM"+result;
					break;
				}
				idx++;
				break;
			case 3:
				switch(lastDigit) {
				case 0:
					break;
				case 1:
					result = "M"+result;
					break;
				case 2:
					result = "MM"+result;
					break;
				case 3:
					result = "MMM"+result;
					break;
				default:
					result = "MMMM"+result;
					break;
				}
				idx++;
				break;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		Solution247 ss = new Solution247();
		System.out.println(ss.intToRoman(3999));

	}
}
