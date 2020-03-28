package test.ccf;

/*
 * StringTokenizer cannot reset!!!
 * StringTokenizer cannot reset!!!
 * StringTokenizer cannot reset!!!
 */

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;



public class URLMatcher_201803_3 {

	static ArrayList<String> UrlRules = new ArrayList<>(), Paras = new ArrayList<>(), UrlAddrs = new ArrayList<>();
	
	static ArrayList<StringTokenizer> UrlRulesSt = new ArrayList<>(), UrlAddrsSt = new ArrayList<>();
	
	static void init() {
		int n,m;
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();//num of rules, paras
		m = sc.nextInt();//num of addrs
		
		int i = 0;
		while (i++ != n) {
			String x = new String(sc.next());
			if (x.endsWith("<path>")) {
				x+="/<path>/<path>/<path>/<path>/<path>/<path>/<path>/<path>/<path>/<path>/<path>/<path>/<path>/<path>/<path>/<path>/<path>/<path>/<path>/<path>";
				//this is a really bad trick!
			}
			UrlRules.add(x);
			Paras.add(new String(sc.next()));
		}
		i = 0;
		while (i++ != m) {
			UrlAddrs.add(new String(sc.next()));
		}
		
		sc.close();
	}
	
	static void pkgStr() {
		for (String x:UrlRules) {
			UrlRulesSt.add(new StringTokenizer(x, "/"));
		}
		for (String x:UrlAddrs) {
			UrlAddrsSt.add(new StringTokenizer(x, "/"));
		}
	}
	
	static boolean for_match(StringTokenizer rule, StringTokenizer addr,int i,int j) {
		
		rule = new StringTokenizer(UrlRules.get(i), "/");//every time create a new rule tokenizer
		addr = new StringTokenizer(UrlAddrs.get(j), "/");
		while (addr.hasMoreTokens()) {
			
			//String is_rule_path = rule.nextToken();
			
			
			if (!rule.hasMoreTokens()) {
				return false;
			} 
			
			if (!_matcher( rule.nextToken(), addr.nextToken())) {
				
				return false;
			}
		}
		
		
		
		return true;
	}
	
	static boolean for_rules(StringTokenizer addr,int j) {
		int i=0;//the number of rules
		for (StringTokenizer rule : UrlRulesSt) {
			if (for_match(rule, addr,i,j)) {
				System.out.print(Paras.get(i)+' ');
				return true;
			}
			i++;
		}
		return false;
	}
	
	static void for_addrs() {
		int j=0;//number of addrs
		for (StringTokenizer addr : UrlAddrsSt) {
			if (for_rules(addr,j)) {
				
				StringTokenizer st = new StringTokenizer(UrlAddrs.get(j), "/");
				//this is a temp tokenizer. StringTokenizer cannot reset.
				
				st.nextToken();
				
				while (st.hasMoreTokens()) {
					System.out.print(st.nextToken()+' ');
				}
				System.out.println();
				
			}else {
				System.out.println("404");
			}
			
			j++;
		}
		
	}
	
	static boolean _matcher(String rule, String addr) {
		if (rule.charAt(0) != '<') {
			if (rule.equals(addr)) {
				return true;
			} else {
				return false;
			}
		}
		
		switch (rule) {
		case "<int>":
			try {
				Integer.parseInt(addr);
				return true;
			} catch (Exception e) {
				return false;
				// TODO: handle exception
			}
			
		
		case "<str>":
			return true;
		case "<path>":
			return true;
		
		}
		
		return false;
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		init();
		pkgStr();
		
		for_addrs();
		
		
		
		/*
		int a[] = {1,2,3,4,5,6};
		for (int i : a) {
			System.out.println(i);
		}
		
		*/
		/*
		String a = "12345d6";
		int c = Integer.parseInt(a);
		
		System.out.println(c);
		
		*/
	}

}
