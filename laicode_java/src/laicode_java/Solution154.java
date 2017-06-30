package laicode_java;

//Largest SubArray Product
//Given an unsorted array of doubles, find the subarray that has the greatest product. Return the product.
//
//Assumptions
//
//The given array is not null and has length of at least 1.
//Examples
//
//{2.0, -0.1, 4, -2, -1.5}, the largest subarray product is 4 * (-2) * (-1.5) = 12

public class Solution154 {
	public double largestProduct(double[] array) {
	    int leng=array.length;
	    if(leng==0) {
	    	return 0;
	    }
	    else if(leng==1) {
	    	return array[0];
	    }
	    else if(leng==2) {
	    	return Math.max(array[0]*array[1], Math.max(array[0], array[1]));
	    }
	    else {
	//    	  0 2.0
	//    	  1 -0.1
	//    	  2 4
	//    	  3 1.6
	//    	  4 12
	    	double resultmax=Double.MIN_VALUE;
	    	for(int i=0;i<leng;i++) {
	    		double loopmax=array[i];
	    		double current=array[i];
	    		resultmax=Math.max(resultmax, current);
	    		for(int j=i;j>=0;j--) {
	    			if(j==i) {
	    				continue;
	    			}
	    			else {
	    				current=current*array[j];
	    				loopmax=Math.max(current, loopmax);
	    				resultmax=Math.max(resultmax, loopmax);
	    			}
	    		}
	    	}
	    	return resultmax;
		}
	}
  
	public static void main(String[] args) {
		Solution154 s154 = new Solution154();
		double[] array={2.0, -0.1, 4, -2, -1.5};
		array=new double[]{2.0, -0.1};
		double result=s154.largestProduct(array);
		System.out.println(result);
		array=new double[]{2.0, -0.1, 4};
		result=s154.largestProduct(array);
		System.out.println(result);
		array=new double[]{2.0, -0.1, 4, -2};
		result=s154.largestProduct(array);
		System.out.println(result);
		array=new double[]{2.0, -0.1, 4, -2, -1.5};
		result=s154.largestProduct(array);
		System.out.println(result);
	}
}

