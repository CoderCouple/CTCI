package Searching;

public class LinearSearch {

	public static int linearSearch(int nums [],int key){
		for(int index=0;index<nums.length;index++)
			if(nums[index] == key)
				return index;
		return -1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int array [] ={5,1,2,3,4,5,6,7,8,9};
		int key=5;
		System.out.println(linearSearch(array, key));
	}

}
