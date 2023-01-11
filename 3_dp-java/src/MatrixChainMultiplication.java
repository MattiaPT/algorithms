import java.lang.Math;
import VectorMatrix.*;

/*
 * Author: Mattia
 * Date: 11.01.23
 * 
 * In this class an algorithm calculating partitions
 * to make a matrix chain multiplication more efficient.
 */

public class MatrixChainMultiplication {
	public static void main(String[] args) {
		Matrix m1 = new Matrix(new int[][] {new int[] {1, 0, 0}, new int[] {0, 1, 0}, new int[] {0, 0, 1}});
		Matrix m2 = new Matrix(new int[][] {new int[] {1}, new int[] {0}, new int[] {1}});
		Matrix m3 = new Matrix(new int[][] {new int[] {2, 2, 2}});
		
		MatrixChainMultiplication test1 = new MatrixChainMultiplication();
		test1.matrices = new Matrix[] {m1, m2, m3};
		test1.minimalCalculations();
	}
	
	
	Matrix[] matrices;
	
	public int minimalCalculations() {
		int[][] DP_table = new int[matrices.length][matrices.length];
		for (int i = 0; i < matrices.length; i++)
			DP_table[i][i] = 0;
		
		for (int i = 1; i < matrices.length; i++) {
			for (int j = 0; j < matrices.length - i + 1; j++) {
				int l = j + i - 1;
				if (l == matrices.length)
					continue;
				DP_table[i][j] = Integer.MAX_VALUE;
				for (int k = j; k <= l - 1; k++) {
					int temp = DP_table[j][k] + DP_table[k + 1][l] + 
							matrices[i - 1].dimension.rows * matrices[k].dimension.cols * matrices[l].dimension.cols;
					DP_table[i][j] = Math.min(DP_table[i][j], temp);
				}
			}
		}
		System.out.println(new Matrix(DP_table));
		return DP_table[0][matrices.length-1];
	}
}