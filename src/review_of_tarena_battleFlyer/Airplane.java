package review_of_tarena_battleFlyer;

import java.util.Random;

class Airplane extends Flyer {
	private int speed = 5;
	private int score = 5;
	/**
	 * 
	 * @return current score
	 */
	int getScore() {
		return score;
	}
	@Override
	void step() {
		// TODO Auto-generated method stub
		y += speed;
	}
	@Override
	boolean outOfBounds() {
		// TODO Auto-generated method stub
		return y>Game.HEIGHT;
	}
	
	Airplane(){
		image = Game.airplane;
		width = image.getWidth();
		height = image.getHeight();
		Random r = new Random();
		x = r.nextInt(Game.WIDTH-width);
		y = -height;
		
	}
}
