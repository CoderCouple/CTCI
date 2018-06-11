package Sorting;

import java.util.Arrays;

public class BubbleSort {

	public static void bubbleSort(int [] nums){
		for(int i=0;i<nums.length-1;i++)
			for(int j=i+1;j<nums.length;j++){
				if(nums[j]<nums[i]){
					int temp=nums[i];
					nums[i]=nums[j];
					nums[j]=temp;
				}
			}
	}
	
	public static void modifiedBubbleSort(int [] nums){
		boolean isSorted=false;
		int range= nums.length-1;
		while(!isSorted){
			isSorted=true;
			for(int i=0;i<range;i++){
				if(nums[i]>nums[i+1]){
					int temp = nums[i+1];
					nums[i+1]=nums[i];
					nums[i]=temp;
					isSorted=false;
				}
			}
			range--;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int array []={7,4,1,10,5,100,2};
		//bubbleSort(array);
		modifiedBubbleSort(array);
		System.out.println(Arrays.toString(array));

	}

}
