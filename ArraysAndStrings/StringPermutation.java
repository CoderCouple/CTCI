package ArraysAndStrings;

import java.util.Arrays;

public class StringPermutation {

	public static boolean isPermutation(String str1, String str2) {

		int frequency1[] = new int[128];
		int frequency2[] = new int[128];

		for (int i = 0; i < str1.length(); i++) {
			int index = str1.charAt(i);
			frequency1[index] = frequency1[index] + 1;
		}

		for (int i = 0; i < str2.length(); i++) {
			int index = str2.charAt(i);
			frequency2[index] = frequency2[index] + 1;
		}

		if (Arrays.equals(frequency1, frequency2))
			return true;

		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str1 = "abcda";
		String str2 = "aabcd";
		System.out.println("Is permutation : " + isPermutation(str1, str2));

	}

}
