package ArraysAndStrings;

import java.util.Arrays;

public class URLify {

	public static String urlify(String inputString, int length) {

		if (inputString == null || inputString == "")
			return inputString;

		char inputArray[] = inputString.toCharArray();

		int j= inputArray.length-1;
		for (int i = length-1; i >= 0; i--) {
			if(inputArray[i]==' '){
				inputArray[j--]='0';
				inputArray[j--]='2';
				inputArray[j--]='%';
				
			}else {
				inputArray[j]=inputArray[i];
				j--;
			}
			
		}

		return String.valueOf(inputArray);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = "Mr John Smith    ";
		System.out.println(urlify(str,13));
		
	}

}
