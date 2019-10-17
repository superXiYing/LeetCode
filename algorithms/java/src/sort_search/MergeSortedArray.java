package sort_search;

import java.util.Arrays;
import common.*;

public class MergeSortedArray {

	// Time Complexity = O((n+m)*log(n+m))
	public static void mergeSort1(int[] nums1, int m, int[] nums2, int n) {
		System.arraycopy(nums2, 0, nums1, m, n);
		Arrays.sort(nums1);
	}

	// Time Complexity = O(n+m)
	// Space Complexity = O(m)
	public static void mergeSort(int[] nums1, int m, int[] nums2, int n) {
		// Make a copy of nums1
		int[] nums1_copy = new int[m];
		System.arraycopy(nums1, 0, nums1_copy, 0, m);

		// set pointer for nums1_copy, nums2, nums1
		int i, j, k;
		i = 0;
		j = 0;
		k = 0;

		// compare elements from nums2_copy and nums2 and add the smallest one
		// into nums1
		while (i < m && j < n) {

			/*if (nums1_copy[i] < nums2[j]) {
				nums1[k] = nums1_copy[i];
				k++;
				i++;
			} else {
				nums1[k] = nums2[j];
				k++;
				j++;
			}
          */
			nums1[k++] = (nums1_copy[i]<nums2[j]) ? nums1_copy[i++]:nums2[j++];
		}

		//if there are still elements to add
		while (i < m) {
			nums1[k++] = nums1_copy[i++];
		}

		while (j < n) {
			nums1[k++] = nums2[j++];
		}

	}

	public static void main(String[] args) {
		int[] arr1 = { 1, 2, 3, 0, 0, 0 };
		int[] arr2 = { 2, 5, 6 };
		mergeSort(arr1, 3, arr2, 3);
		Util.printWholeList(arr1);
	}

}
