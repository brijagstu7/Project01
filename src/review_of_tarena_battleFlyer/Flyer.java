package review_of_tarena_battleFlyer;

import java.awt.image.BufferedImage;

abstract class Flyer {
	protected int x; 
	protected int y;
	protected int width;
	protected int height;
	protected BufferedImage image;
	/**
	 * make a move
	 */
	abstract void step();
	/**
	 * check if an object is out of bound
	 * @return 
	 */
	abstract boolean outOfBounds();
	/**
	 * check if a collision occurs
	 * @param f1
	 * @param f2
	 * @return
	 */
	static boolean bang(Flyer f1, Flyer f2) {
		//this computes the center point of f1, f2
		int f1x = f1.x+f1.width;
		//x coordinate locates the left-top endpoint of the object
		int f1y = f1.y+f1.height;
		int f2x = f2.x+f2.width;
		int f2y = f2.y+f2.height;
		
		boolean H = Math.abs(f1x-f2x)<(f1.width+f2.width)/2;
		boolean V = Math.abs(f1y-f2y)<(f1.height+f2.height)/2;
		
		return H&V;
	}
}
