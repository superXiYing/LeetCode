package String;

//Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
import org.junit.Assert;
public class StrStr {
	public static void main(String[] args){
		String haystack = "hello";
		String needle = "ll";
		System.out.println(strStr(haystack, needle));
		Assert.assertEquals(2,strStr(haystack,needle));
		
		String haystack1 = "hello";
		String needle1 = "el";
		System.out.println(strStr(haystack1, needle1));
		Assert.assertEquals(1,strStr(haystack1,needle1));
		
		String haystack2 = "hello";
		String needle2 = "elp";
		System.out.println(strStr(haystack2, needle2));
		Assert.assertEquals(-1,strStr(haystack2,needle2));
		
		String haystack3 = "hello";
		String needle3 = "";
		System.out.println(strStr(haystack3, needle3));
		Assert.assertEquals(0,strStr(haystack3,needle3));
		
		String haystack4 = "mississippi";
		String needle4 = "issip";
		System.out.println(strStr(haystack4, needle4));
		Assert.assertEquals(4,strStr(haystack4,needle4));
		
	}
	
	public static int strStr(String haystack, String needle){
		if (needle.equals(""))
			return 0;

		int i, j;
		i = 0;
		j = 0;
		boolean tag = false;
		int firstIdx = 0;
		int trueCount = 0;
		while (i < haystack.length() && j < needle.length()) {
			if (haystack.charAt(i) == needle.charAt(j)) {
				tag = true;
				trueCount++;
				if (trueCount == 1)
					firstIdx = i;

				j++;
				i++;
			} else {
				if (tag == true) {
					i = firstIdx + 1;
					j = 0;
					trueCount = 0;
				} else
					i++;

				tag = false;
			}

		}

		if (tag == true && j == (needle.length()))
			return firstIdx;
		else
			return -1;
	}

}
