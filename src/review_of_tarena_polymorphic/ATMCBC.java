package review_of_tarena_polymorphic;

class ATMCBC implements IUnionPay,IPolice {
	Card card;
	
	ATMCBC(Card card) {
		super();
		this.card = card;
	}

	public boolean checkPwd(String pwd) {
		// TODO Auto-generated method stub
		if(pwd.equals(card.pwd)) {
			return true;
		}else return false;
	}

	public boolean drawMoney(double money) {
		// TODO Auto-generated method stub
		if(money<=card.bal) {
			card.bal -= money;
			return true;
		}else return false;
	}

	public double getBalance() {
		// TODO Auto-generated method stub
		return card.bal;
	}

	public void takePic() {
		// TODO Auto-generated method stub
		System.out.println("smile to camera");
	}

}
