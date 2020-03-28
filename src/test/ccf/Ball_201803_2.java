package test.ccf;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

class ball {
	int speed = 1;// 1 or -1; 1:right
	int pos;// position

	ball(int pos) {
		this.pos = pos;
	}
}

public class Ball_201803_2 {

	static ArrayList<ball> balls = new ArrayList<ball>();

	static int epoch;

	static int line;

	static void init() {
		int amount, tmp;
		Scanner sc;

		sc = new Scanner(System.in);
		amount = Integer.parseInt(sc.next());
		line = Integer.parseInt(sc.next());
		epoch = Integer.parseInt(sc.next());

		while (amount-- != 0) {
			tmp = Integer.parseInt(sc.next());
			balls.add(new ball(tmp));

		}

		sc.close();
	}
	
	static void move() {
		for (ball x : balls) {
			x.pos += x.speed;
		}
	}
	
	static void collision() {
		for (Iterator<ball> iterator = balls.iterator(); iterator.hasNext();) {
			ball x = (ball) iterator.next();
			
			if (x.pos == line || x.pos == 0) {
				x.speed = -x.speed;
			}
			
			
			//The following pass through an existing iterator
			//just like "iterator2 = iterator + 1" in C++
			
			
			Iterator<ball> iterator2 = balls.iterator();
			while (iterator2.hasNext()&&(iterator2.next()!=x)) {
				
			}
			
			for (; iterator2.hasNext();) {
				
				
				
				ball y = (ball) iterator2.next();
				
				if (x==y) {
					continue;
				}
				
				if (x.pos == y.pos) {
					x.speed = -x.speed;
					y.speed = -y.speed;
				}
			}
			
		}
		
	}
	
	static void print() {
		for (ball x : balls) {
			System.out.print(x.pos+" ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		init();
		
		while (epoch-- != 0) {
			move();
			collision();
			
		}
		print();
	}

}
