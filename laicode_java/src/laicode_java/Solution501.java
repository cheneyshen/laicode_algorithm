package laicode_java;

public class Solution501 {
	public long numsOfSubsetSumLessK(int[] set, int K) {
		if(set==null) {
			return 0;
		}
		int N = set.length;
		int[] prefixSum = new int[N];
		for(int i=0; i<N; i++) {
			if(i==0) {
				prefixSum[i] = set[i];
			} else {
				prefixSum[i] = prefixSum[i-1] + set[i];
			}
		}
		int result=0;
		/* 1 2 3
		 * 1 3 6
		 * 1       1
		 *   2     2
		 *     3   3
		 * 1 2     3
		 * 1 2 3   6
		 * 	 2 3   5
		 */
		for(int i=0; i<N; i++) {
			int left=i, right=N-1;
			while(left<=right) {
				int mid = (left+right)/2;
				int sum = prefixSum[mid]-prefixSum[i]+set[i];
				if(sum<K) {
					if(mid+1<N) {
						if(prefixSum[mid+1]-prefixSum[i]+set[i]>=K) {
							result+=mid-i+1;
							break;
						} else {
							left = mid+1;
						}
					} else {
						result += N-i;
						break;
					}
				} else {	//sum >=K
					if(mid-1>=i) {
						if(prefixSum[mid-1]-prefixSum[i]+set[i]<K) {
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
		Solution501 ss = new Solution501();
		int[] set = new int[]{1,2,3};
		int K = 7;
		System.out.println("6:" + ss.numsOfSubsetSumLessK(set, K));
		System.out.println("5:" + ss.numsOfSubsetSumLessK(set, 6));
		System.out.println("4:" + ss.numsOfSubsetSumLessK(set, 5));
		System.out.println("4:" + ss.numsOfSubsetSumLessK(set, 4));
		System.out.println("2:" + ss.numsOfSubsetSumLessK(set, 3));
		System.out.println("1:" + ss.numsOfSubsetSumLessK(set, 2));
		System.out.println("0:" + ss.numsOfSubsetSumLessK(set, 1));
	}

}
