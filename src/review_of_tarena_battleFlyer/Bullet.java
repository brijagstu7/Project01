package review_of_tarena_battleFlyer;

class Bullet extends Flyer {
	private int speed = 3;

	@Override
	void step() {
		// TODO Auto-generated method stub
		y -= speed;
	}

	@Override
	boolean outOfBounds() {
		// TODO Auto-generated method stub
		return (y + height)<0;
	}
	
	Bullet(int x, int y){
		image = Game.bullet;
		width = image.getWidth();
		height = image.getHeight();
		this.x = x;
		this.y = y;
	}
	
}
