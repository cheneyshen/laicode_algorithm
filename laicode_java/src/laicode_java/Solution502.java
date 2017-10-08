package laicode_java;

public class Solution502 {
	public long numsOfSubsetProductLessK(int[] set, long K) {
		if(set==null) {
			return 0;
		}
		int N = set.length;
		long[] prefixProduct = new long[N];
		for(int i=0; i<N; i++) {
			if(i==0) {
				prefixProduct[i] = set[i];
			} else {
				prefixProduct[i] = prefixProduct[i-1] * set[i];
			}
		}
		int result=0;
		/* 1 2 3
		 * 1 2 6
		 * 1       1
		 *   2     2
		 *     3   3
		 * 1 2     2
		 * 1 2 3   6
		 * 	 2 3   6
		 */
		for(int i=0; i<N; i++) {
			int left=i, right=N-1;
			while(left<=right) {
				int mid = (left+right)/2;
				long product = prefixProduct[mid]*set[i]/prefixProduct[i];
				if(product<K) {
					if(mid+1<N) {
						if(prefixProduct[mid+1]/prefixProduct[i]*set[i]>=K) {
							result+=mid-i+1;
							break;
						} else {
							left = mid+1;
						}
					} else {
						result += N-i;
						break;
					}
				} else {	//product >=K
					if(mid-1>=i) {
						if(prefixProduct[mid-1]/prefixProduct[i]*set[i]<K) {
							result+=mid-1-i+1;
							break;
						} else {
							right=mid-1;
						}
					} else {
						result +=0;
						break;
					}
				}
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution502 ss = new Solution502();
		int[] set = new int[]{1,2,3};
		int K = 7;
		System.out.println("6:" + ss.numsOfSubsetProductLessK(set, K));
		System.out.println("4:" + ss.numsOfSubsetProductLessK(set, 6));
		System.out.println("4:" + ss.numsOfSubsetProductLessK(set, 5));
		System.out.println("4:" + ss.numsOfSubsetProductLessK(set, 4));
		System.out.println("3:" + ss.numsOfSubsetProductLessK(set, 3));
		System.out.println("1:" + ss.numsOfSubsetProductLessK(set, 2));
		System.out.println("0:" + ss.numsOfSubsetProductLessK(set, 1));
	}

}
