package laicode_java;

import java.io.File;
import java.util.*;
import java.util.regex.Pattern;

/*Simplify Path
		Given an absolute path for a file(Unix - style), simplify it.

		Input: path = ¡° / home / ¡±

		Output : ¡° / home¡±

		Input : path = ¡° / a / . / b / .. / .. / c / ¡±

		Output : ¡° / c¡±*/
public class Solution159 {
	public String simplify(String path) {
		String[] array = path.split("/");
//		System.out.println(Arrays.toString(array));
//		return array[0];
		Stack<String> ss = new Stack<String>();
		for(int i=0; i<array.length; i++) {
			if(array[i].isEmpty() || array[i].length()==0 ) {
				continue;
			}
			else if (array[i].length()==1 && array[i].charAt(0)=='.') {
				continue;
			}
			else if(array[i].startsWith("..") == true && ss.isEmpty()==false) {
				ss.pop();
			}
			else if(array[i].startsWith("..") == false) {
				ss.push(array[i]);
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<ss.size(); i++) {
			sb.append("/"+ss.get(i));
		}
		if(sb.length()==0) {
			sb.append("/");
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		Solution159 ss = new Solution159();
		String result;
		result = ss.simplify("/a/./b/../../c/");
		System.out.println(result);
		result = ss.simplify("/home/");
		System.out.println(result);
		result = ss.simplify("/");
		System.out.println(result);
		result = ss.simplify("");
		System.out.println(result);
	}
}
