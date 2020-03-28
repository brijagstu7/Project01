package try01;


import java.util.ArrayList;

class Blank implements Cloneable {

	@Override
	protected Blank clone()  {

		Blank b = new Blank(this);

		return b;

	}

	public Blank(String str) {
		origin = str;
		uradix = str.length();

		String strn = str.replaceAll("_","0");
		existed = Integer.parseInt(strn);


		for (int i = 0; i < uradix; i++) {

			int radix = uradix - i;

			if (str.charAt(i) == '_'){
				not_existed.add(radix-1);
			}

		}

	}

	public Blank(Blank b){
		this.origin = b.origin;
		this.uradix = b.uradix;
		this.existed = b.existed;

		for (Integer i :
				b.not_existed) {
			int k = i;
			this.not_existed.add(k);
		}
	}

	String origin;
	int uradix;
	int existed;
	ArrayList<Integer> not_existed = new ArrayList<>();//remain sequence: ->, i.e. left to right
}

public class Program {



	static Blank[] copy(Blank[] ts){

		Blank[] theCopy = new Blank[ts.length];

		for (int i=0;i<ts.length;i++) {
			theCopy[i] = ts[i].clone();
		}


		return theCopy;
	}

	public static void main(String[] args) {

		Blank[] blanks = {new Blank("1_2"),new Blank("_2"),new Blank("_2_")};
		Blank[] oldBlanks = copy(blanks);

		StringBuilder sb = new StringBuilder(blanks[0].origin);

		System.out.println("before the change");
		System.out.println(blanks[0].origin+", "+blanks[0].not_existed);
		System.out.println(oldBlanks[0].origin+", "+oldBlanks[0].not_existed);

		int index = 1;
		sb.replace(index,index+1,"9");
		blanks[0] = new Blank(sb.toString());

		System.out.println("after the change");
		System.out.println(blanks[0].origin+", "+blanks[0].not_existed);
		System.out.println(oldBlanks[0].origin+", "+oldBlanks[0].not_existed);
	}

}
