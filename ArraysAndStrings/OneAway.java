package ArraysAndStrings;

public class OneAway {

	public static boolean isOneAway(String str1, String str2) {
		if (str1.length() == str2.length()) {

			int count = 0;
			for (int i = 0; i < str1.length(); i++) {
				if (str1.charAt(i) != str2.charAt(i))
					count++;
				if (count > 1)
					return false;
			}
		} else if (Math.abs(str1.length() - str2.length()) > 1) {
			return false;
		} else {

			String max;
			String min;
			if (str1.length() > str2.length()) {
				max = str1;
				min = str2;
			} else {
				max = str2;
				min = str1;
			}

			int k = 0;
			int count = 0;

			for (int j = 0; j < min.length(); j++) {
				if (max.charAt(k) == min.charAt(j)) {
					k++;
				} else {
					count++;
					k = k + 2;
				}

				if (count > 1)
					return false;
			}

		}
		return true;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "pale";
		String str2 = "bake";

		System.out.println("Is it one away : " + isOneAway(str1, str2));

	}

}
