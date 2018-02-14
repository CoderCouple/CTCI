package ArraysAndStrings;

import java.util.Arrays;

public class PalindromePermutation {

	public static boolean isPalindromPermutation(String inputString) {

		int count = 0;
		int frequency[] = new int[128];

		inputString = inputString.replaceAll(" ", "").toLowerCase();

		if (inputString == null || inputString == "")
			return true;

		for (int i = 0; i < inputString.length(); i++) {
			int index = inputString.charAt(i);
			frequency[index] = frequency[index] + 1;
		}

		for (int j = 0; j < frequency.length; j++) {
			if (frequency[j] % 2 != 0)
				count++;

			// System.out.println(Arrays.toString(frequency));
			if (count > 1)
				return false;
		}

		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPalindromPermutation("Tact Coa"));

	}

}
