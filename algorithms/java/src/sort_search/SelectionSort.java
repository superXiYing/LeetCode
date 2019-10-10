package sort_search;

import common.Util;

public class SelectionSort {

	public static void main(String[] args) {
		int[] nums = { 7, 2, 3, 8 };
		selectionSort(nums);
		Util.printWholeList(nums);
	}

	public static void selectionSort(int[] nums) {
		int length = nums.length;
		// One by one move the boundary of unsorted array
		for (int i = 0; i < length - 1; i++) {
			
			// find the smallest element in the unsorted array
			int smallest_idx = i;
			for (int j = i + 1; j < length; j++) {
				if (nums[j] < nums[smallest_idx])
					smallest_idx = j;
			}

			// swap the smallest element with the first element in the unsorted
			// array
			if (i != smallest_idx) {
				int tmp = nums[i];
				nums[i] = nums[smallest_idx];
				nums[smallest_idx] = tmp;
			}

		}
	}
}
