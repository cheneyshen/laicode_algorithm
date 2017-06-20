package laicode_java;

public class Solution6 {
	//复制java文件
	//for i in {3..100}; do cp Solution2.java "Solution$i.java"; done
	//分离某一行然后替换
	//for i in {3..100}; do head -3 "Solution$i.java" | tail -1 $1 | awk '{split($0, a, ' '); print a[3]' ; done
	//sed -i ' ' 's/hi/hello/' file1
	//更改后复制到新文件
	//awk 'NR==2{gsub("hi", "Hello", $1)}; {print $0}' file1 > newfile
	//代变量就必须要用“”双引号
	//for i in {3..100}; do sed -i " " "3s/Solution/Solution$i/" Solution$i.java ; done
	public long fibonacci(int K) {
		if (K<=0) {
			return 0;
		}
		if (K==1) {
			return 1;
		}
		return fibonacci(K-1)+fibonacci(K-2);
	}
	public long fibonacci1(int K) {
		if(K<=0) {
			return 0;
		}
		long[] array=new long[K+1];
		array[1]=1;
		for(int i=2;i<=K;i++) {
			array[i]=array[i-2]+array[i-1];
		}
		return array[K];
	}
	public long fibonacci2(int K) {
		long a=0;
		long b=1;
		if (K<=0) {
			return a;
		}
		while(K>1) {
			long temp=a+b;
			a=b;
			b=temp;
			K--;
		}
		return b;
	}
	
	public static final long[][] seed={{1, 1}, {1,0}};
	
	public long fibonacci3(int K) {
		if (K<=0) {
			return 0;
		}
		if (K<=1) {
			return 1;
		}
		long[][] matrix= {{1L,1L}, {1L, 0L}};
		pow(matrix, K-1);
		return matrix[0][0];
	}
	private void pow(long[][] matrix, int pow) {
		if (pow==1) {
			return;
		}
		pow(matrix, pow/2);
		multiply(matrix, matrix);
		if (pow%2!=0) {
			multiply(matrix, seed);
		}
	}
	
	private void multiply(long[][] matrix, long[][] multiplier) {
		long topleft=matrix[0][0]*multiplier[0][0]+matrix[0][1]*multiplier[1][0];
		long topright=matrix[0][0]*multiplier[0][1]+matrix[0][1]*multiplier[1][1];
		long bottomleft=matrix[1][0]*multiplier[0][0]+matrix[1][1]*multiplier[1][0];
		long bottomright=matrix[1][0]*multiplier[0][1]+matrix[1][1]*multiplier[1][1];
		matrix[0][0]=topleft;
		matrix[0][1]=topright;
		matrix[1][0]=bottomleft;
		matrix[1][1]=bottomright;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Solution6 s6 = new Solution6();
		long result6 = s6.fibonacci(6);
		System.out.println(result6);
		result6=s6.fibonacci1(0);
		System.out.println(result6);
		result6=s6.fibonacci2(1000);
		System.out.println(result6);
		result6=s6.fibonacci3(1000);
		System.out.println(result6);
		return;
	}
}
