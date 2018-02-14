package ArraysAndStrings;

import java.util.Arrays;

public class ZeroMatrix {

	public static int[][] getZeroMatrix(int matrix[][]) {

		int zeroMatrix[][] = new int[matrix.length][matrix[0].length];

		for (int i = 0; i < matrix.length; i++) {
			System.arraycopy(matrix[i], 0, zeroMatrix[i], 0, matrix[i].length);
		}

		for (int j = 0; j < matrix.length; j++) {
			for (int i = 0; i < matrix.length; i++) {
				if (matrix[j][i] == 0)
					for (int k = 0; k < matrix.length; k++) {
						zeroMatrix[j][k] = 0;
						zeroMatrix[k][i] = 0;
					}

			}
		}

		return zeroMatrix;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int matrix1[][] = { { 1, 0, 3, 4 }, { 5, 6, 7, 0 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		int matrix2[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		for (int i = 0; i < matrix1.length; i++)
			System.out.println(Arrays.toString(matrix1[i]));

		System.out.println("");

		for (int i = 0; i < matrix1.length; i++)
			System.out.println(Arrays.toString(getZeroMatrix(matrix1)[i]));
	}

}
