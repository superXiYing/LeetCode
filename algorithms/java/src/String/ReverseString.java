package String;

/*Write a function that reverses a string. The input string is given as an array of characters char[].

 Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

 You may assume all the characters consist of printable ascii characters.*/
public class ReverseString {
	public static void main(String[] args) {
		char[] s = { '1', '2', '3', '4' };
		reverseStringRecursion(s);
		common.Util.printWholeList(s);
	}

	/*
	 * In this approach, two pointers are used to process two array elements at
	 * the same time. Usual implementation is to set one pointer in the
	 * beginning and one at the end and then to move them until they both meet.
	 * Time complexity : O(N) to swap N/2 element. Space compexity : O(1),
	 * constant space solution
	 */
	public static void reverseString(char[] s) {
		int left = 0;
		int right = s.length - 1;
		while (left < right) {
			char tmp = s[left];
			s[left++] = s[right];
			s[right--] = tmp;
		}
	}

	/*
	 * Time complexity : O(N) time to perform N/2 swaps. Space complexity : O(N)
	 * to keep the recursion stack.
	 */
	public static void reverseStringRecursion(char[] s) {
		helper(s, 0, s.length - 1);
	}

	public static void helper(char[] s, int left, int right) {
		if (left < right) {
			// swap
			char c = s[left];
			s[left] = s[right];
			s[right] = c;

			helper(s, left + 1, right - 1);
		}
	}

	public static void reverseStringSlow(char[] s) {
		int n = s.length;
		for (int j = n - 1; j > 0; j++) {
			char head = s[0];
			for (int i = 0; i < j; i++) {
				s[i] = s[i + 1];
			}
			s[j] = head;
		}
	}

}
