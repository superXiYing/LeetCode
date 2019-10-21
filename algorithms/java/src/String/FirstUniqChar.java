package String;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

/*
 Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

 Examples:
 s = "leetcode"
 return 0.

 s = "loveleetcode",
 return 2.

Time complexity : O(N) since we go through the string of length N two times.
Space complexity : O(N) since we have to keep a hash map with N elements.
*/
public class FirstUniqChar {
	public static void main(String[] args) {
		String s = "leetcode";
		String s1 = "loveleetcode";
		System.out.println(firstUniqChar(s1));
	}

	public static int firstUniqChar(String s) {
		Map<Character, Integer> m = new LinkedHashMap<Character, Integer>();
		// build hash map: Character and how ofen it appears
		for (int i = 0; i < s.length(); i++) {
			Character key = s.charAt(i);
			Integer value = m.get(key);
			
			/*if (value == null)
				m.put(key, 1);
			else
				m.put(key, value + 1);*/
			//use simpler method instead of above
			m.put(key, m.getOrDefault(key,0)+1);
		}

		// find the index
		for (int i = 0; i < s.length(); i++) {
			Character key = s.charAt(i);
			if (m.get(key) == 1)
				return i;
		}

		return -1;
	}

}
