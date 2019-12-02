package array;

public class reverseFabonacci {
	public static void main(String[] args){
		printReverseFabonacci(10);
		
		String s = "I am Geek";
		String[] words = s.split(" ");
		String reverseS = "";
		for(int i = (words.length -1); i>=0; i--){
			if(i != 0)
			   reverseS += words[i] + " ";
			else 
			   reverseS +=words[i]; 
		}
		
		System.out.println(reverseS.length() == s.length());
	}
	public static void printReverseFabonacci(int n){
		int[] nums = new int[n];
		nums[0] = 0;
		nums[1] = 1;
		for(int i = 2; i < n; i++){
			nums[i] = nums[i-1] + nums[i-2];
		}
		
		for(int i = (n-1); i>=0; i--){
			System.out.print(nums[i] + " ");
		}
	}

}
