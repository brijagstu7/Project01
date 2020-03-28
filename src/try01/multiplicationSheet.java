package try01;

class multiplicationSheet {
	//construction method cannot initialize alone
	static void getSheet(){
		outer:for(int i=1;i<10;i++) {
			for(int j=1;j<10;j++) {
				if(i < j) {
					System.out.println();
					continue outer;
					//usage of continue
				}
				System.out.print(" "+(i * j));
			}
		}
	}
}
