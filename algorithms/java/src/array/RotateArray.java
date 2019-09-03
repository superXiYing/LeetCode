package array;

import common.*;

public class RotateArray {
	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
		int k = 3;
		rotate3(nums, 3);
		Util.printList(nums, nums.length);

		int[] nums1 = { -1, -100, 3, 99 };
		int k1 = 2;
		rotate1(nums1, k1);
		Util.printList(nums1, nums1.length);

	}

	// time complexity = O(k*n)
	// space complexity = 1
	public static void rotate1(int[] nums, int k) {
		int tmp;
		int length = nums.length;
		for (int j = 0; j < k; j++) {
			tmp = nums[length - 1];
			for (int i = length - 1; i > 0; i--) {
				nums[i] = nums[i - 1];
			}
			nums[0] = tmp;
		}

	}
	
    //time complexity = o(n)
	//space complexity = n
	public static void rotate2(int[] nums, int k) {
		int length = nums.length;
		int[] tmp_array = new int[length];
		
		for(int i=0; i<length; i++){
			tmp_array[(i+k)%length] = nums[i];
		}
		
		for(int i = 0; i < length; i++){
			nums[i] = tmp_array[i];
		}
		
		
	}	
	
	/*This approach is based on the fact that when we rotate the array k times, k elements from the back end of the array come to the front and the rest of the elements from the front shift backwards.

	In this approach, we firstly reverse all the elements of the array. Then, reversing the first k elements followed by reversing the rest n−k elements gives us the required result.

	Let n=7 and k=3

	Original List                   : 1 2 3 4 5 6 7
	After reversing all numbers     : 7 6 5 4 3 2 1
	After reversing first k numbers : 5 6 7 4 3 2 1
	After revering last n-k numbers : 5 6 7 1 2 3 4 --> Result
*/
	//Time complexity = O(n). n elements are reversed a total of three times
	//Space complexity = O(1). No extra space is used
	public static void rotate3(int[] nums, int k) {
		int length = nums.length;
		k = k%length;
		reverse(nums, 0, length-1);
		reverse(nums, 0, k-1);
		reverse(nums, k, length-1);
	}
	
	public static void reverse(int[] nums, int start, int end){
		while(start < end){
			int tmp = nums[start];
			nums[start] = nums[end];
			nums[end] = tmp;
			
			start = start + 1;
			end = end - 1;
		}
	}
	
}
