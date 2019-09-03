package array;

import common.*;

public class RemoveDuplicateFromArray{
  public static void main(String[] args){
	int[] nums = {0,0,1,1,2,2,2,3,3};
	int newLen = removeDuplicateFromSortedArray(nums);

	Util.printList(nums, newLen);
  }
  
  public static int removeDuplicateFromSortedArray(int[] nums){
		int tail = 0;
		for(int i=1; i<nums.length;i++){
			if(nums[i] != nums[tail]){
				tail = tail + 1;
			    if(tail != i)
			    	nums[tail] = nums[i];
			}
				
		}
		
		return tail+1;	
	}
  
  
}
