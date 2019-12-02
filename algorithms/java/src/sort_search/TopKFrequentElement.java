package sort_search;
import java.util.*;

public class TopKFrequentElement { 
	public static List<Integer> topKFrequent(int[] nums, int k){
		List<Integer> result = new LinkedList<Integer>();
		Map<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();
		int i;
		
		/*for(i = 0; i<nums.length; i++){
			if(map.containsKey(nums[i]))
				map.put(nums[i], map.get(nums[i])+1);
			else
				map.put(nums[i], 1);
		}*/
		
		for(int n: nums){
			map.put(n, map.getOrDefault(n, 0)+1);
		}
		
		Map<Integer, Integer> sortedMap = new TreeMap<Integer, Integer>(new Comparator<Integer>(){
			public int compare(Integer n1, Integer n2){
				return map.get(n2)-map.get(n1);
			}
		});
		
		for(Map.Entry<Integer, Integer> entry: map.entrySet()){
			sortedMap.put(entry.getKey(), entry.getValue());
		}
		
		i = 0; 
		for(Map.Entry<Integer, Integer> entry: sortedMap.entrySet()){
			result.add(entry.getKey());
			i ++;
			if(i == k)
				break;
		}
		
		return result;
		
		
	}
	
	public static List<Integer> topKFrequent1(int[] nums, int k){
		Map<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();
		int i;
		
		for(i = 0; i<nums.length; i++){
			if(map.containsKey(nums[i]))
				map.put(nums[i], map.get(nums[i])+1);
			else
				map.put(nums[i], 1);
		}
		
		Queue<Integer> heap = new PriorityQueue<Integer>(new Comparator<Integer>(){
			public int compare(Integer n1, Integer n2){
				return map.get(n1)-map.get(n2);
			}
		});
		
		for(Map.Entry<Integer, Integer> entry: map.entrySet()){
			heap.add(entry.getKey());
			
			if(heap.size() >k)
				heap.poll();
		}
		List<Integer> result = new LinkedList<Integer>();
		while(!heap.isEmpty())
			result.add(heap.poll());
		Collections.reverse(result);
		
		
		
		return result;
		
		
	}
	
	
	public static List<Integer> topKFrequentSelectionSort(int[] nums, int k){
		//count the frequency for each value in the array nums
		Map<Integer, Integer> counts = new LinkedHashMap<Integer, Integer>();
		for(Integer n: nums)
			counts.put(n, counts.getOrDefault(n,0)+1);
		
		//Integer maxKey, maxValue;
		//maxKey = 0;
		
		List<Element> list = new LinkedList<Element>();
		
		while(!counts.isEmpty()){
		 Integer maxKey, maxValue;
		 maxKey = 0;
		 maxValue = Integer.MIN_VALUE;
		 //find the entry with maximum value in the map, add the entry into a list, then remove the entry from map	
		 for(Map.Entry<Integer, Integer> entry: counts.entrySet()){
			if(entry.getValue()>maxValue){
				maxKey = entry.getKey();
				maxValue = entry.getValue();
			}
		}
		counts.remove(maxKey);
		list.add(new Element(maxKey, maxValue));
		}
		
		List<Integer> result = new LinkedList<Integer>();
		int i = 0;
		for(Element e: list){
		  result.add(e.key);
		  i ++;
		  
		  if(i == k)
			  break;
		}
		
		return result;
	}
	
	public static List<Integer> topKFrequentInsertionSort(int[] nums, int k){
		//count the frequency for each value in the array nums
		Map<Integer, Integer> counts = new LinkedHashMap<Integer, Integer>();
		for(Integer n: nums)
			counts.put(n, counts.getOrDefault(n,0)+1);
		
		int i;
		List<Element> sortedList = new LinkedList<Element>();
		for(Map.Entry<Integer, Integer> entry: counts.entrySet()){
			for(i =0; i<sortedList.size();i++){
				if(entry.getValue() > sortedList.get(i).value)
						break;
			}
			sortedList.add(i, new Element(entry.getKey(), entry.getValue()));
		}
		
		List<Integer> result = new LinkedList<Integer>();
		i = 0;
		for(Element e: sortedList){
			result.add(e.key);
			i++;
			
			if(i==k)
				break;
		}
		return result;
	}
	
	public static void main(String[] args){
		int[] nums = {1,2};
		int[] nums1 = {5,3,1,1,1,3,73,1};
		List<Integer> result = topKFrequent(nums1, 2);
		System.out.println(result);
		
		
	}
		
}



class Element {
	public int key;
	public int value;
	
	public Element(int key, int value) {
		this.key = key;
		this.value = value;
	}
}
