package recursion;

//1,1,2,3,5,8,13,21....
public class Fabonacci {
	public static void main(String[] args) {
		int n = 6;
		System.out.println("The " + n + "th in fabonacci sequence is "
				+ fabonacciRec(n));
	}

	// Time complexity: O(2^n)
	// Space complexity: O(n)
	public static int fabonacciRec(int n) {
		if (n == 1 || n == 2)
			return 1;
		else
			return fabonacciRec(n - 1) + fabonacciRec(n - 2);
	}

	// Time complexity: O(n)
	// Space complexity: O(n)
	public static int fabonacci(int n) {
		// Declare an array to store fabonacci numbers
		int[] f = new int[n + 2]; // 1 extra space to handle case, n=0

		// 0th and 1st number of series are 0 and 1
		f[0] = 0;
		f[1] = 1;

		for (int i = 2; i <= n; i++) {
			// add the previous 2 numbers in the series and store it
			f[i] = f[i - 1] + f[i - 2];
		}

		return f[n];
	}

	// Time complexity: O(n)
	// Space complexity: O(1)
	public static int fabonacci_improveSpace(int n) {
		int a = 0, b = 1, c;
		if (n == 0)
			return a;
		if (n == 1)
			return b;

		for (int i = 2; i <= n; i++) {
			c = a + b;
			a = b;
			b = c;
		}
		return b;
	}

}
