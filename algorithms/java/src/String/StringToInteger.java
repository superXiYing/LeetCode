package String;

/*Implement atoi which converts a string to an integer.

 The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.

 The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.

 If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.

 If no valid conversion could be performed, a zero value is returned.
 Time complexity: O(n)
 Space complexity: O(1)
 */

public class StringToInteger {
	public static void main(String[] args) {
		String s = "-91283472332";

		System.out.println(myAtoi(s));

	}

	public static int myAtoi(String str) {
		String trimmed = str.trim();
		if (trimmed.length() == 0 || trimmed == null)
			return 0;

		int sign = 1;
		long result = 0;
		int i = 0;
		char firstChar = trimmed.charAt(0);
		if (firstChar == '-') {
			sign = -1;
			i++;
		}
		if (firstChar == '+') {
			sign = 1;
			i++;
		}

		// (int)'0'=48 and (int)'1'=49
		for (; i < trimmed.length(); i++) {
			char c = trimmed.charAt(i);
			if (Character.isDigit(c)) {
				result = result * 10 + (c - '0');

				if (sign == 1 && result > Integer.MAX_VALUE)
					return Integer.MAX_VALUE;
				if (sign == -1 && result * sign < Integer.MIN_VALUE)
					return Integer.MIN_VALUE;
			} else
				break;
		}

		return (int) result * sign;

	}

	public static int myAtoi1(String str) {
		str = str.trim();
		if (str == null || str.length() == 0)
			return 0;

		char firstChar = str.charAt(0);
		int sign = 1;
		int start = 0;
		long res = 0;
		if (firstChar == '+') {
			sign = 1;
			start++;
		} else if (firstChar == '-') {
			sign = -1;
			start++;
		}

		for (int i = start; i < str.length(); i++) {
			if (!Character.isDigit(str.charAt(i))) {
				return (int) res * sign;
			}
			res = res * 10 + str.charAt(i) - '0';
			if (sign == 1 && res > Integer.MAX_VALUE)
				return Integer.MAX_VALUE;
			if (sign == -1 && res > Integer.MAX_VALUE)
				return Integer.MIN_VALUE;
		}
		return (int) res * sign;
	}

}
