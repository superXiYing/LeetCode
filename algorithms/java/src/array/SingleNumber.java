package array;

import common.*;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Collection;
import java.util.Set;
import java.util.HashSet;

public class SingleNumber {
	public static void main(String[] args){
		int[] nums = {2, 2, 1};
		System.out.println(singleNumber2(nums));
	}
	
	/*
	Iterate through all elements in nums
	Try if hash_tablehas the key for pop
	If not, set up key/value pair
	In the end, there is only one element in hash_table, so use pop item to get it
	Complexity Analysis
	Time complexity : O(n)
	Space complexity : O(n)
	*/
	public static int singleNumber1(int[] nums){
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int result = Integer.MAX_VALUE;
		for(int i = 0; i< nums.length; i++){
			Integer key = nums[i];
			Integer value = map.get(key);
			if(value != null)
				map.remove(key);
			else
				map.put(key, 1);
		}
		
//		Collection<Integer> collection = map.keySet();
//		Iterator<Integer> iterator = collection.iterator();
//		while(iterator.hasNext()){
//			result = iterator.next();
//			break;
//		}
		
		for(Integer value: map.keySet()){
			result = value;
			break;
		}
		
		return result;	
	}
	
	//(a+b+c)*2-(a+a+b+b+c) = c
	public static int singleNumber2(int[] nums){
		Set<Integer> set = new HashSet<Integer>();
		int sumArray = 0;
		int sumSet = 0;
		for(int i = 0; i < nums.length; i++){
			set.add(nums[i]);
			sumArray += nums[i];
		}
		
		for(Integer value: set)
			sumSet += value;
		
		return sumSet*2-sumArray;
	}

}
