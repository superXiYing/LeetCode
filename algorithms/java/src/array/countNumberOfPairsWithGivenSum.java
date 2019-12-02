package array;

public class countNumberOfPairsWithGivenSum {
	public static void main(String[] args){
		int[] nums = {1,5,7, -1};
		int sum = 6;
		System.out.println(countNum(nums,6));
	}
	
	public static int countNum(int[] nums, int sum){
		int count  = 0;
		for(int i = 0; i< (nums.length-1); i++){
			int current = nums[i];
			for(int j = i+1; j < nums.length; j++){
				if((current + nums[j]) == sum){
					count ++;
					System.out.println("Wow! Found the " + count + "th pair:[" + current + "," + nums[j] + "]");
				}
			}	
		}
	return count;	    
	}

}
