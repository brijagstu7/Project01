package try01;

import java.util.Arrays;
import java.util.Scanner;

public class input_array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner x=new Scanner(System.in);
	     while(x.hasNext()){
	         int m=x.nextInt();
	       
	         int[] number=new int[m];
	         for(int i=0;i<m;i++){
	             number[i]=x.nextInt();
	             //System.out.println(number[i]);
	         }
	         System.out.println(Arrays.toString(number));

	     }

	}
}
