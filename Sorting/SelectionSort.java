package Sorting;

import java.util.Arrays;

public class SelectionSort {

	public static void selectionSort(int nums[]) {
		for(int i=0;i<nums.length-1;i++){
			int minIndex=i;
			for(int j=i+1; j<nums.length;j++)
				if(nums[j]<nums[minIndex])
					minIndex=j;
			int k=nums[i];
			nums[i]=nums[minIndex];
			nums[minIndex]=k;
		}
	}
	
	public static void main(String[] args) {
		int array[] = { 7, 4, 1, 10, 5, 100, 2 };
		selectionSort(array);
		System.out.println(Arrays.toString(array));

	}
}
