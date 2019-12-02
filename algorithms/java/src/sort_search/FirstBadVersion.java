package sort_search;

/*You are a product manager and currently leading a team to develop a new product. 
 * Unfortunately, the latest version of your product fails the quality check. 
 * Since each version is developed based on the previous version, 
 * all the versions after a bad version are also bad.
 Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one,
 which causes all the following ones to be bad.
 You are given an API bool isBadVersion(version) which will return whether version is bad. 
 Implement a function to find the first bad version.
 You should minimize the number of calls to the API.*/

public class FirstBadVersion {
	public static void main(String[] args){
		int lastBadVersion = 9;
		System.out.println(firstBadVersion1(lastBadVersion));
	}

	/*
	 * Doing linear scan from end
	 * 
	 * Time complexity : O(n). Assume that isBadVersion(version) takes constant
	 * time to check if a version is bad. It takes at most n−1 checks, therefore
	 * the overall time complexity is O(n).
	 * 
	 * Space complexity : O(1).
	 */
	public static int firstBadVersion(int n) {
		int lastGood = -1;
		int currentBad = n;
		for (int i = (n - 1); i > 0; i--) {
			if (isBadVersion(i) == true) {
				currentBad = i;
			} else {
				lastGood = i;
				break;
			}

		}
		if (lastGood != -1)
			return lastGood + 1;
		if (currentBad < n)
			return currentBad;
		return n;
	}

	/*
	 * The straight forward way is to brute force it by doing a linear scan from
	 * head.
	 */
	public static int firstBadVersion1(int n) {
		for (int i = 1; i < n; i++) {
			if (isBadVersion(i))
				return i;
		}
		return n;
	}

	/*
	 * Approach #2 (Binary Search) [Accepted]
	 * 
	 * It is not difficult to see that this could be solved using a classic
	 * algorithm - Binary search. Let us see how the search space could be
	 * halved each time below.
	 * 
	 * Scenario #1: isBadVersion(mid) => false
	 * 
	 * 1 2 3 4 5 6 7 8 9 
	 * G G G G G G B B B 
	 * G= Good, B = Bad | left mid right
	 * 
	 * Let us look at the first scenario above where isBadVersion(mid)⇒false. We
	 * know that all versions preceding and including mid are all good. So we
	 * set left=mid+1 to indicate that the new search space is the interval
	 * [mid+1,right](inclusive).
	 * 
	 * Scenario #2: isBadVersion(mid) => true
	 * 
	 * 1 2 3 4 5 6 7 8 9 
	 * G G G B B B B B B 
	 * G = Good, B = Bad | left mid right
	 * 
	 * The only scenario left is where isBadVersion(mid)⇒true. This tells us
	 * that mid may or may not be the first bad version, but we can tell for
	 * sure that all versions after mid can be discarded. Therefore we set
	 * right=mid as the new search space of interval [left,mid] (inclusive).
	 * 
	 * In our case, we indicate left and right as the boundary of our search
	 * space (both inclusive). This is why we initialize left=1 and right=n. How
	 * about the terminating condition? We could guess that left and right
	 * eventually both meet and it must be the first bad version, but how could
	 * you tell for sure?
	 * 
	 * The formal way is to prove by induction, which you can read up yourself
	 * if you are interested. Here is a helpful tip to quickly prove the
	 * correctness of your binary search algorithm during an interview. We just
	 * need to test an input of size 2. Check if it reduces the search space to
	 * a single element (which must be the answer) for both of the scenarios
	 * above. If not, your algorithm will never terminate.
	 * 
	 * If you are setting mid=(left+right)/2, you have to be very careful.
	 * Unless you are using a language that does not overflow such as Python,
	 * (left+right)/2 could overflow. One way to fix this is to use
	 * left+(right−left)/2​ instead.
	 * 
	 * If you fall into this subtle overflow bug, you are not alone. Even Jon
	 * Bentley's own implementation of binary search had this overflow bug and
	 * remained undetected for over twenty years.
	 */

	/*
	 * Time complexity : O(log⁡n). The search space is halved each time, so the
	 * time complexity is O(log⁡n).
	 * 
	 * Space complexity : O(1).
	 */
	public static int firstBadVersion2(int n) {
		int left = 1;
		int right = n;
		int mid;
		while (right > left) {
			//The current method avoid integer overflow, instead of using (left+right)/2
			mid = left + (right - left) / 2;
			if (isBadVersion(mid) == false)
				left = mid + 1;
			if (isBadVersion(mid) == true)
				right = mid;
		}
		return left;

	}

	private static boolean isBadVersion(int i) {
		String[] storage = { "G", "G", "G", "G", "G", "G", "B", "B", "B" };
		if (storage[i - 1].equalsIgnoreCase("B"))
			return true;
		else
			return false;
	}

}
