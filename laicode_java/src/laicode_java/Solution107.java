package laicode_java;

import java.util.*;

//    Largest SubMatrix Product
//    Given a matrix that contains doubles, find the submatrix with the largest product.
//
//    Return the product of the submatrix.
//
//    Assumptions
//
//    The given double matrix is not null and has size of M * N, where M >= 1 and N >= 1
//    Examples
//
//    {   {1, -0.2, -1},
//        {1, -1.5,  1},
//        {0,    0,  1} }
//
//    the largest submatrix product is 1 * 1 = 1.
public class Solution107 {
	public double largest(double[][] matrix) {
		if(matrix==null || matrix.length==0) {
			return 0.0;
		}
		int M=matrix.length,N=matrix[0].length;
//		{2.0, -1.0,  0.5,  1.0, -3.0},
//		{0.0, -2.0, -1.0,  2.0,  0.1},
//		{3.0,  0.2,  1.0, -3.0, -2.0}
//		2.0 -2.0 -1.0 -1.0  3.0
//		0.0  0.0  0.0  0.0  0.0
//		3.0  0.6  0.6 -1.8  3.6
		double result=matrix[0][0];
		double[][] matrixProduct=new double[M][N];
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				if(j==0) {
					matrixProduct[i][j]=matrix[i][j];
				}
				else {
					matrixProduct[i][j]=matrix[i][j]*matrixProduct[i][j-1];
					//Perhaps this value==-0.0
					if(Math.abs(matrixProduct[i][j])==0) {
						matrixProduct[i][j]=0;
					}
				}
			}
		}
		//zip all the rows for i, j columns (0<=i<=j<<N)
		for(int i=0; i<N; i++) {
			for(int j=i; j<N; j++) {
				double[] tests = new double[M];
				for(int k=0; k<M; k++) {
					if(matrixProduct[k][j]==0 && matrix[k][j]!=0) {
						tests[k]=1;
						for(int m=i; m<=j; m++) {
							tests[k]=tests[k]*matrix[k][m];
						}
					} else if(matrix[k][j]==0) {
						tests[k]=0;
					} else {
						tests[k]=matrixProduct[k][j]/matrixProduct[k][i]*matrix[k][i];
					}
				}
				result = Math.max(result, helper(tests));
			}
		}
		return result;
	}
	
	private double helper(double[] array) {
		if(array==null || array.length==0) {
			return 0;
		}
		double maxProduct=array[0];
		double minCurrent=array[0];
		double maxCurrent=array[0];
		for(int i=1; i<array.length; i++) {
			double a=minCurrent*array[i];
			double b=maxCurrent*array[i];
			minCurrent=Math.min(array[i], Math.min(a, b));
			maxCurrent=Math.max(array[i], Math.max(a, b));
			maxProduct=Math.max(maxCurrent, maxProduct);
		}
		return maxProduct;
	}
	
	public static void main(String[] args) {
		Solution107 ss = new Solution107();
		double [][] matrix = {	{1, -0.2, -1},
				  				{1, -1.5,  1},
				  				{0,    0,  1} };
		System.out.println(ss.largest(matrix));
	}
}
