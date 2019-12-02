package math;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class NearPrime {
	public static void main(String ars){
		FileInputStream in = new FileInputStream("c:\\a1.input");
		FileOutputStream  out = new FileOutputStream("c:\\a1.output");
		String line = in.readLine();
		while(line != null){
			int n = Integer.valueOf(line);
			int count = nearPrimeNumber(n);
			out.write(count);
		}
	}
	public static int nearPrimeNumber(int n){
		int count = 0;
		int lastPrime = 0;
		for(int i = 2; i < n; i ++){
			//if it's a prime
			//suppose all number are prime
			boolean isPrime = true;
			for(int j =2; j<i/2; j++){
				if(i % j == 0){
					isPrime = false;
					break;
				}			
			}
			
			if(isPrime){
				if(lastPrime != 0 && i-lastPrime == 2)
					count ++;
				lastPrime = i;
			}
		}
		return count;
	}

}
