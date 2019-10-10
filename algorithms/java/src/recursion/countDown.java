package recursion;

public class countDown {
	public static void main(String[] args){
		final int n = 10;
		countDownRecursion(n);
	}
	
	public static void countDown(int n){
		for(int i=n; i>0; i--)
			System.out.println(i);
	}
	
	public static void countDownRecursion(int n){
		
			 System.out.println(n);
			 if(n<=1)
				 return;
			 else
		     countDownRecursion(n-1);

		 
	}

}
