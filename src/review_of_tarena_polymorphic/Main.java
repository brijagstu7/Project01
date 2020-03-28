package review_of_tarena_polymorphic;

import java.util.Scanner;

class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		Card card = new Card(IUnionPay.CBC,"123456",10.0);
		
		//ATMCBC atm = new ATMCBC(card);unused.
		//use DMD in the below.
		IUnionPay atm;
		if(card.bank.equals("ATMCBC")) {
			atm = new ATMCBC(card);
			ATMCBC atmm = (ATMCBC)atm;
			//add a cast to call method takePic
			atmm.takePic();
		}else {
			atm = new ATMABC(card);
			ATMABC atmm = (ATMABC)atm;
			atmm.takePic();
		}
		
		//System.out.println(atmm instanceof ATMABC);
		//HINT atmm is not visible outside if block
		
		System.out.println("please enter ur password");
		//@SuppressWarnings("resource")//?
		Scanner sc = new Scanner(System.in);
		
		if(atm.checkPwd(sc.next())) {
			System.out.println("enter the amount to draw");
			sc = new Scanner(System.in);
			
			if(atm.drawMoney(sc.nextDouble())) {
				System.out.println("draw completely.");
			}else{
				System.out.println("lack of cash.");
			}
		}else System.out.println("wrong password");
		
	}

}
