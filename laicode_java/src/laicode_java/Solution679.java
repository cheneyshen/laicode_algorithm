package laicode_java;
import java.util.*;

public class Solution679 {
    static boolean res = false;
    static double eps = 0.00001;
    public static boolean judgePoint24(int[] nums) {
        if(nums==null || nums.length!=4) {
            return false;
        }
        List<Double> arr = new ArrayList<>();
        for(int i:nums) {
            arr.add((double)i);
        }
        helper(arr);
        return res;
    }
    
    private static void helper(List<Double> arr) {
        if(res) {
            return;
        }
        if(arr.size()==1) {
            if(Math.abs(arr.get(0)-24) <=eps) {
                res = true;
            }
            return;
        }
        for(int i=0; i<arr.size(); i++) {
            for(int j=0; j<i; j++) {
                double a = arr.get(i), b = arr.get(j);
                List<Double> vals = new ArrayList<Double>();
                vals.add(a+b);
                vals.add(a-b);
                vals.add(a*b);
                vals.add(b-a);
                if(Math.abs(a)>eps) {
                    vals.add(b/a);
                }
                if(Math.abs(b)>eps) {
                    vals.add(a/b);
                }
                for(double nxt: vals) {
                    arr.remove(i);
                    arr.remove(j);
                    arr.add(nxt);
                    helper(arr);
                    arr.remove(arr.size()-1);
                    arr.add(j, b);
                    arr.add(i, a);
                }
            }
        }
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(judgePoint24(new int[]{4, 1, 8, 7}));
	}

}
