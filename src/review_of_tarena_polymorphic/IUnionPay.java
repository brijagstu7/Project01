package review_of_tarena_polymorphic;

interface IUnionPay /*extends IPolice*/{
	//if u input this, no need for a cast in main
	//for calling method takePic.
	String ABC = "ATMABC";//it's forcibly a constant
	String CBC = "ATMCBC";//in an interface
	
	boolean checkPwd(String pwd);
	boolean drawMoney(double money);
	double getBalance();
}
