package common;

import list.ListNode;

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
	
	public static void printWholeList(int[] nums) {

			for (int i = 0; i < nums.length; i++) {
				System.out.print(nums[i]);
				if (i != (nums.length - 1))
					System.out.print(", ");
			}
			
			System.out.println();

		}
	
	public static void printWholeList(char[] items){
		for(int i = 0; i<items.length;i++){
			System.out.print(items[i]);
			if (i != (items.length - 1))
				System.out.print(", ");
		}
		
	}
	
	public static void printWholeList(ListNode head) {
		while (head != null) {
			System.out.print(head.getVal() + " ");
			head = head.next();
		}

	}

}
