package ArraysAndStrings;

public class StringCompression {

	public static String getCompressedString(String inputString) {

		if (inputString.length() == 1)
			return inputString;

		int count = 1;
		int i = 0;
		StringBuilder sb = new StringBuilder();
		for (; i < inputString.length() - 1;) {
			if (inputString.charAt(i) == inputString.charAt(i + 1)) {
				count++;
				i++;
			} else {
				sb.append(inputString.charAt(i) + "" + count);
				count = 1;
				i++;
			}

		}

		sb.append(inputString.charAt(i) + "" + count);

		System.out.println(sb.toString());
		if (sb.toString().length() >= inputString.length())
			return inputString;

		return sb.toString();
	}

	public static void main(String[] args) {
		String str = "aabcccccaab";

		System.out.println("Cmpressed String : " + getCompressedString(str));

	}

}
