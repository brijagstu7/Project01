package review_of_tarena_battleFlyer;
/**
 * 
 * @author brija
 *
 */
class Hero extends Flyer{
	private int doubleFire;
	private int life;
	private int score;
	/**
	 * 
	 * @return life of plane
	 */
	int getLife() {
		return life;
	}
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
		
	}
	@Override
	boolean outOfBounds() {
		// TODO Auto-generated method stub
		return false;
	}
	/**
	 * hero follows the cursor
	 * @param x
	 * @param y
	 */
	void move(int x, int y) {
		this.x = x - width/2;
		this.y = y - height/2;
	}
	void getScore_Award(Flyer f) {
		if(f instanceof Airplane) {
			score += ((Airplane)f).getScore();
		}else {
			if(((Bee)f).getAwardType()==Bee.DOUBLE_FIRE) {
				doubleFire += 40;
			}else {
				life += 1;
			}
		}
	}
	/**
	 * hero shoot with one or two bullets
	 * @return
	 */
	Bullet[]/*return a Bullet[]*/ shoot() {
		Bullet bullets[] = null;
		if(doubleFire!=0) {
			bullets = new Bullet[2];
			bullets[0] = new Bullet(x+width/4, y-Game.bullet.getHeight());
			bullets[1] = new Bullet(x+width*3/4, y-Game.bullet.getHeight());
			doubleFire -= 2;
		}else {
			bullets = new Bullet[1];
			bullets[0] = new Bullet(x+width/2, y-Game.bullet.getHeight());
		}
		return bullets;
		
	}
	/**
	 * check if hero were hit
	 * @return
	 */
	boolean hit(Flyer f) {
		boolean r = Flyer.bang(this, f);
		if(r) {
			life--;
			doubleFire = 0;
		}
		return r;
	}
	
	Hero(){
		image = Game.hero0;
		width = image.getWidth();
		height = image.getHeight();
		x = 150;
		y = 450;
		doubleFire = score = 0;
		life = 3;
	}
}
