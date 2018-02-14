package ArraysAndStrings;

import java.util.Arrays;

public class MatrixRotation {

	public static int[][] rotateMatrix(int matrix [][]){
		int k=matrix.length-1;
		int rotatedMatrix  [][]  =new int[matrix.length][matrix[0].length]; 
		for(int j=0;j<matrix.length;j++){
			for(int i=0;i<matrix.length;i++ ){
				rotatedMatrix[i][k]=matrix[j][i];
				
			}
			k--;
		}
		
		return rotatedMatrix;
	}

	public static void main(String[] args) {
	
		int matrix1[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		int matrix2[][] = { { 1, 2, 3 }, { 4,5,6 }, {7,8, 9} };
		for(int i=0; i<matrix1.length;i++)
		System.out.println(Arrays.toString(rotateMatrix(matrix1)[i]));
		
	}

}
