package review_of_tarena_polymorphic;

class ATMABC extends ATMCBC{

	ATMABC(Card card) {
		super(card);
		// TODO Auto-generated constructor stub
	}//this step is must only for constructors
	
	public boolean drawMoney(double money, int flag) {
		// TODO Auto-generated method stub
			card.bal -= money;
			return true;
	}
}
