package laicode_java;

public class Solution548 {

    public static boolean splitArray(int[] nums) {
        // i=1 n-6
        //     j=i+2 n-4
        //         k=j+2 n-2
        if(nums==null || nums.length<7) {
            return false;
        }
        int leng=nums.length;
        
        int sum[] = new int[nums.length];
        for(int i=0; i<leng; i++) {
            if(i==0) {
                sum[i] = nums[i];
            } else {
                sum[i] = sum[i-1]+nums[i];
            }
        }
        boolean res = false;
        for(int i=1; i<=leng-6; i++) {
            int curr = sum[i-1];
            if(helper(nums, sum, i, 3, curr)) {
                res=true;
            }
        }
        System.out.println(res);
        return res;
    }
    
    private static boolean helper(int[] nums, int[] sum, int end, int k, int prev) {
        if(k==1) {
            int curr = sum[sum.length-1]-sum[end];
            return prev == curr;
        }
        boolean result=false;
        for(int i=end+2; i<=nums.length-(k-1)*2; i++) {
            if(sum[i-1]-sum[end] == prev) {
                result |= helper(nums, sum, i, k-1, prev);
            }
        }
        return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[] {1,2,2,1,2,2,1,2,2,1};
		splitArray(arr);
	}

}
