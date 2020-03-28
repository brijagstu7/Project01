package review_of_tarena_polymorphic;

class Card {
	String bank;
	String pwd;
	double bal;
	
	Card(String bank, String pwd, double bal) {
		super();
		this.bank = bank;
		this.pwd = pwd;
		this.bal = bal;
	}
	
	Card(){
		this(null, null, 0.0);
	}
	//a smart way to replace this.bank = null;...
	//for it invokes the former constructor.
}
