package try01;

//import java.util.Arrays;

public class Ugly_numbers {
	static boolean isUgly(int num) {
	       
		while(num%30==0)num /= 30;
		while(num%6==0)num /= 6;
		while(num%10==0)num /= 10;
		while(num%15==0)num /= 15;
		while(num%2==0)num /= 2;
		while(num%3==0)num /= 3;
		while(num%5==0)num /= 5;
		
		
        return (num==1);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int counter = 6,num = 0, n;
		//boolean flag = true;
		//int a[] = findPrime.exe(1500000);
		for(n=8;counter!=1000;n++) {
			/*if(((n%2==0)||(n%3==0)||(n%5==0))) {
				
				for(i=2;(i<a.length)&&(a[i]<n);i++) {
					flag = true;
					if((n%a[i]!=0)) {
						
					}else {
						flag = false;
						break;
					}
				}
				if(flag) {
					num = n;
					counter++;
				}
			}*/
			if(isUgly(n)) {
				num = n;
				counter++;
			}
		}
		System.out.println("The "+counter+"'th ugly number is "+num);
	}
}



