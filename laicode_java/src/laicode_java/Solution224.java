package laicode_java;

import java.util.*;

//Reverse Integer
//Reverse digits of an integer.
//
//Assumptions
//If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100.
//Did you notice that the reversed integer might overflow? Assume the input is a 32-bit integer, then the reverse of 1000000003 overflows. How should you handle such cases?
//For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
//Examples
//Input:      23
//Output:   32
//
//Input:     -14
//Output:  -41
public class Solution224 {
	public int reverseInt(int i) {
		long result=0;
		while(i!=0) {
			result=result*10+i%10;
			i=i/10;
		}
		if(result>Integer.MAX_VALUE || result<Integer.MIN_VALUE) {
			return 0;
		}
		return (int) (result);
	}
	

    public int calculate(String s) {
        Stack<Integer> igers = new Stack<>();
        int sign=1;
        int num=0;
        int ans=0;
        igers.push(1);
        for(char c:s.toCharArray()) {
            if(c>='0'&&c<='9') {
                num=num*10+c-'0';
            } else if(c=='+'||c=='-') {
                ans=ans+sign*num;//already have two numbers, compute
                num=0;//back to 0
                sign=(c=='+'?1:-1);//ready to meet next number
            } else if(c=='(') {
                igers.push(ans);
                igers.push(sign);
                sign=1;//back to '+'
                ans=0;
            } else if(c==')') {
                ans=ans+sign*num; // sign mean + or -
                num=0;
                ans=ans*igers.pop();//reverse, firstly times sign, -1 or 1
                ans=ans+igers.pop();//secondly + or - ans
            }
        }
        if(num!=0)
            ans=ans+num*sign;
        return ans;
    }
    
	public static void main(String[] args) {
		Solution224 ss = new Solution224();
		System.out.println(ss.calculate("(1+(4+5+2)-3)+(6+8)"));
		System.out.println(ss.reverseInt(-32));
		System.out.println(ss.reverseInt(1000000003));
	}
}
