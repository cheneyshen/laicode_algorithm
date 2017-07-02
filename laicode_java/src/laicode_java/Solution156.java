package laicode_java;

//Largest SubMatrix Product
//Given a matrix that contains doubles, find the submatrix with the largest product.
//
//Return the product of the submatrix.
//
//Assumptions
//
//The given double matrix is not null and has size of M * N, where M >= 1 and N >= 1
//Examples
//
//{ {1, -0.2, -1},
//
//  {1, -1.5,  1},
//
//  {0,     0,  1} }
//
//the largest submatrix product is 1 * 1 = 1.

public class Solution156 {
	public double largest(double[][] matrix) {
		if(matrix==null || matrix.length==0) {
			return 0.0;
		}
		int M=matrix.length;
		int N=matrix[0].length;
//		{2.0, -1.0,  0.5,  1.0, -3.0},
//		{0.0, -2.0, -1.0,  2.0,  0.1},
//		{3.0,  0.2,  1.0, -3.0, -2.0}
//		2.0 -2.0 -1.0 -1.0  3.0
//		0.0  0.0  0.0  0.0  0.0
//		3.0  0.6  0.6 -1.8  3.6
		double result=matrix[0][0];
		double[][] matrixProduct=new double[M][N];
		//preprocess for all columns
		for(int i=0;i<M;i++) {
			for(int j=0;j<N;j++) {
				if(j==0) {
					matrixProduct[i][j]=matrix[i][j];
				}
				else {
					matrixProduct[i][j]=matrix[i][j]*matrixProduct[i][j-1];
					//Perhaps this value == -0.0
					if(Math.abs(matrixProduct[i][j])==0) {
						matrixProduct[i][j]=0;
					}
				}
			}
		}
		//zip all the rows for [i,j] columns (0<=i<=j<N)
		for(int i=0;i<N;i++) {
			for(int j=i;j<N;j++) {
				double[] testing=new double[M];
				for (int m = 0; m<M; m++) {
					if(matrixProduct[m][j]==0 && matrix[m][j]!=0) {
						testing[m]=1;
						for(int k=i;k<=j;k++) {
							testing[m]=testing[m]*matrix[m][k];
						}
					}
					else if(matrix[m][j]==0) {
						testing[m]=0;
					}
					else {
						testing[m]=matrixProduct[m][j] / matrixProduct[m][i] * matrix[m][i];
					}
					System.out.print(testing[m]+" ");
				}
				System.out.println();
				result = Math.max(result, matrixProductHelper(testing));
			}
		}
		return result;
	}
	
	private double matrixProductHelper(double[] array) {
		if(array==null || array.length==0) {
			return 0;
		}
		double maxProduct=array[0];
		double minCurrent=array[0];
		double maxCurrent=array[0];
		for(int i=1;i<array.length;i++) {
			double a=minCurrent*array[i];
			double b=maxCurrent*array[i];
			minCurrent=Math.min(array[i], Math.min(a, b));
			maxCurrent=Math.max(array[i], Math.max(a, b));
			maxProduct=Math.max(maxProduct, maxCurrent);
		}
		return maxProduct;
	}
	
	public static void main(String[] args) {
		Solution156 s156 = new Solution156();
//		double[][] matrix = new double[][]{{1, -0.2, -1}};
//		double result=s156.largest(matrix);
//		System.out.println(result);
//		matrix = new double[][]{{1}, {1}, {0}};
//		result=s156.largest(matrix);
//		System.out.println(result);
//		matrix = new double[][]{{1, -0.2, -1},
//								{2, -1.5,  1},
//								{0,    0,  1}};
//		result=s156.largest(matrix);
//		System.out.println(result);
		double[][] matrix = new double[][]{{2.0, -1.0,  0.5,  1.0, -3.0},
								{0.0, -2.0, -1.0,  2.0,  0.1},
								{3.0,  0.2,  1.0, -3.0, -2.0}};
		double result=s156.largest(matrix);
		System.out.println(result);
 	}
}