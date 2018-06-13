package Searching;

public class BinarySearchRecusion {

	public static int BinarySearchRecursion(int[] nums, int key, int start, int end) {
		if (start > end)
			return -1;

		int mid = start + (end - start) / 2;

		if (nums[mid] == key)
			return mid;
		else if (nums[mid] < key)
			return BinarySearchRecursion(nums, key, mid + 1, end);
		else
			return BinarySearchRecursion(nums, key, start, mid - 1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int array[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int key = 5;
		System.out.println(BinarySearchRecursion(array, key, 0, array.length - 1));
	}

}
