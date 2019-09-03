package common;

public class Util {
	public static void printList(int[] nums, int length) {
		if (nums.length >= length) {
			for (int i = 0; i < length; i++) {
				System.out.print(nums[i]);
				if (i != (length - 1))
					System.out.print(", ");
			}
			
			System.out.println();

		}
	}

}
