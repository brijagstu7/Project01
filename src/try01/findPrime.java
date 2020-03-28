package try01;

import java.util.Arrays;


class findPrime {
/**
 * give an array of primes under n(excluding 2,3,5)
 * @param n
 * @return
 */
	static int[] exe(int n) {
		int primes[] = new int[0];
		boolean flag = true;
	
		for(int i=3;i<=n;i+=2) {
			flag = true;
			if(i%2!=0) {
				for(int j=3;j*j<=i;j+=2) {
					if(i%j!=0) {
					
					}else {
						flag = false;
						break;
					}
				}
			}else {
				flag = false;
			}
			if(flag) {
				primes = Arrays.copyOf(primes, primes.length+1);
				primes[primes.length-1] = i;
			}
		}
		return primes;
	}
	
	
	static int[] find(int n) {
		int buffer[] = new int[0];
		for(int i=7;i<=n;i++) {
			if((n%2==0)||(n%3==0)||(n%5==0)) {
				
			}else {
				buffer = Arrays.copyOf(buffer, buffer.length+1);
				buffer[buffer.length-1] = i;
			}
		}
		return buffer;
	}
	
	


}