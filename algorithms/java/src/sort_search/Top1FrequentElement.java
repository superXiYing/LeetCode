package sort_search;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class Top1FrequentElement {
	public static int top1Frequent(int[] nums){
		Map<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();  
		
		//Get the frequency number for each element in the array
		for(int i = 0; i<nums.length; i++){
			Integer key = nums[i];
			Integer value = map.get(key);
			if(value == null)
				map.put(key, 1);
			else
				map.put(key, value+1);
		}
		
		//iterate on the map to get the key with maximum value
		Collection<Integer> keys = map.keySet();
//		Collection<Integer> values = map.values();
		Iterator<Integer> iterator = keys.iterator();
		Integer maxKey, maxValue;
		maxKey = 0;
		maxValue = Integer.MIN_VALUE;
		while(iterator.hasNext()){
			Integer key = iterator.next();
			Integer value = map.get(key);
			if(value > maxValue){
				maxKey = key;
				maxValue = value;
			}
				
		}
		
		return maxKey;
		
	}
	
	public static void main(String[] args){
		int[] nums = {1,1,1,2,2,2,2,1,3};
		System.out.println("The most frequent element is: " + top1Frequent(nums));
	}

}
