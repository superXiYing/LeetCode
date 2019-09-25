package sort_search;

public class BinarySearch {
	public static void main(String[] args) {
		int nums[] = { 1, 3, 5, 7, 9 };
		int item = 3;
		Integer location = binary_search(nums, item);
		if (location != null)
			System.out.println("The item is at index " + location);
		else
			System.out.println("Can't find the item in the array");
	}

	public static Integer binary_search(int[] sortedNumber, int item) {
		int low, high, mid, guess;
		low = 0;
		high = sortedNumber.length;
		while (high >= low) {
			mid = (low + high) / 2;
			guess = sortedNumber[mid];
			if (item == guess)
				return mid;
			if (item > guess)
				low = mid + 1;
			if (item < guess)
				high = mid - 1;
		}
		return null;
	}

}
