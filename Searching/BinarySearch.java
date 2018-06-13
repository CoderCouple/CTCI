package Searching;

public class BinarySearch {

	public static int binarySearch(int nums [],int key){
		int start=0;
		int end=nums.length;
		
		while(start<=end){
			int mid=start+(end-start)/2;
			if(nums[mid]==key)
				return mid;
			else if(nums[mid]<key)
				start=mid+1;
			else end =mid-1;
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int array [] ={1,2,3,4,5,6,7,8,9};
		int key=5;
		System.out.println(binarySearch(array, key));
	}

}
