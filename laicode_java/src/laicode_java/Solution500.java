package laicode_java;

//VISA rolling string
public class Solution500 {
	static String rollString(String s, String[] operations) {
		StringBuffer sb = new StringBuffer(s);
		for(int i=0; i<operations.length; i++) {
			helper(sb, operations[i]);
		}
		return sb.toString();
	}
	
	private static void helper(StringBuffer sb, String operation) {
		String[] split = operation.split(" ");
		int start = Integer.valueOf(split[0]);
		int end = Integer.valueOf(split[1]);
		String operator = split[2];
		switch(operator.toUpperCase().charAt(0)) {
			case 'L':
				for(int i=start; i<=end; i++) {
					int curr = sb.charAt(i)-'a';
					curr = (curr+26-1)%26;
					sb.setCharAt(i, (char) (curr+'a'));
				}
				break;
			case 'R':
				for(int i=start; i<=end; i++) {
					int curr = sb.charAt(i)-'a';
					curr = (curr+26+1)%26;
					sb.setCharAt(i, (char) (curr+'a'));
				}
				break;
		}
	}
	public static void main(String[] args) {
		String s = "abc";
		String[] operations = {"0 0 L", "2 2 L", "0 2 R"};
		Solution500 ss = new Solution500();
		System.out.println(ss.rollString(s, operations));
	}

}
