package sort_search;

import common.*;

public class QuickSort {
	public static void main(String[] args) {
		int[] nums = { 10, 80, 30, 90, 40, 50, 70 };
		QuickSort o = new QuickSort();
		o.quickSort(nums, 0, nums.length - 1);
		Util.printWholeList(nums);
	}

	/*
	 * This function takes last element as pivot, places the pivot element at
	 * its correct position in sorted array, and places all smaller (smaller
	 * than pivot) to left of pivot and all greater elements to right of pivot
	 */
	public void quickSort(int[] nums, int low, int high) {
		if (high > low) {
			int i = partition(nums, low, high);
			// quick sort for the less part
			quickSort(nums, low, i - 1);
			// quickSort for the large part
			quickSort(nums, i + 1, high);
		}
	}

	
	public int partition(int[] nums, int low, int high) {
		// take last element as the pivot
		int pivot = nums[high];
		// The head of the un-processing part
		int head = low;
		// move the lower parts(number smaller than the pivot) to the head of
		// array
		for (int i = low; i < high; i++) {
			if (nums[i] < pivot) {

				if (head != i) {
					int tmp = nums[head];
					nums[head] = nums[i];
					nums[i] = tmp;
				}

				head++;
			}

		}

		// move the pivot next to the lower part
		int tmp = nums[head];
		nums[head] = nums[high];
		nums[high] = tmp;

		return head;
	}

}
