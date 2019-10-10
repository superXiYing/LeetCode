package recursion;

import java.util.Arrays;
public class Sum {
	public static void main(String[] args){
		int[] nums = {1, 2, 3};
		System.out.println(sum_r(nums));
	}
	
	public static void sum(int[] nums){
		int sum = 0;
		for(int i=0; i<nums.length; i++)
			sum += nums[i];
			
	}
	
	public static int sum_r(int[] nums){
	  int length = nums.length;
	  int[] smallNums = Arrays.copyOfRange(nums, 1, length) ;
	  if(length == 1)
		  return nums[0];
	  else
	      return nums[0]+sum_r(smallNums);
	}
	
	

}
