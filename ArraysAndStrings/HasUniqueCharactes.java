package ArraysAndStrings;

import java.util.HashSet;
import java.util.Set;

public class HasUniqueCharactes {

	public static boolean firstUniqChar(String s) {

		int frequency[] = new int[128];
		Set uniqueList = new HashSet();
		for (int i = 0; i < s.length(); i++) {
			int index = s.charAt(i);
			// System.out.println(frequency[index]);
			frequency[index] = frequency[index] + 1;
		}

		// System.out.println(Arrays.toString(frequency));
		for (int j = 0; j < frequency.length; j++) {
			if (frequency[j] == 1)
				return true;
		}
		return false;
	}

	public static void main(String[] args) {
		String test = "hhhha";
		System.out.println("Has unique characte ? = "+firstUniqChar(test));

	}

}
