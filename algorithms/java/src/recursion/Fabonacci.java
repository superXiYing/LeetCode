package recursion;

//1,1,2,3,5,8,13,21....
public class Fabonacci {
	public static void main(String[] args) {
		int n = 6;
		System.out.println("The " + n + "th in fabonacci sequence is "
				+ fabonacci(n));
	}

	public static int fabonacci(int n) {
		if (n == 1 || n == 2)
			return 1;
		else
			return fabonacci(n - 1) + fabonacci(n - 2);
	}

}
