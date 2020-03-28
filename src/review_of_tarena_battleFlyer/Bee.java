package review_of_tarena_battleFlyer;

import java.util.Random;

class Bee extends Flyer {
	private int xspeed = 3;
	private int yspeed = 5;
	private byte awardType;
	static final byte DOUBLE_FIRE = 0;
	static final byte LIFE = 1;
	
	@Override
	void step() {
		// TODO Auto-generated method stub
		x += xspeed; y += yspeed;
		if(x<0||x>(Game.WIDTH-width)) {
			xspeed *= -1;
		}
	}
	@Override
	boolean outOfBounds() {
		// TODO Auto-generated method stub
		return y>Game.HEIGHT;
	}
	
	Bee(){
		image = Game.bee;
		width = image.getWidth();
		height = image.getHeight();
		y = -height;
		Random r = new Random();
		x = r.nextInt(Game.WIDTH-width);
		//in Java, low bound<=r.nextInt(x)<upper bound
		awardType = (byte) r.nextInt(2);
	}
	byte getAwardType() {
		return awardType;
	}
}
