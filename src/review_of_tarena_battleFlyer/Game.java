package review_of_tarena_battleFlyer;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

class Game extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//the size of window
	static final int WIDTH = 400;
	static final int HEIGHT = 700;
	//define a time meter for method action
	private int runTimes = 0;
	
	static BufferedImage background,start,pause,gameover,airplane,bee,bullet,hero0,hero1;
	
	static {
		try {
			background = ImageIO.read(Game.class.getResource("background.png"));
			airplane = ImageIO.read(Game.class.getResource("airplane.png"));
			bullet = ImageIO.read(Game.class.getResource("bullet.png"));
			bee = ImageIO.read(Game.class.getResource("bee.png"));
			hero0 = ImageIO.read(Game.class.getResource("hero0.png"));
			hero1 = ImageIO.read(Game.class.getResource("hero1.png"));
			pause = ImageIO.read(Game.class.getResource("pause.png"));
			gameover = ImageIO.read(Game.class.getResource("gameover.png"));
			start = ImageIO.read(Game.class.getResource("start.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//define characters for the game
	Hero hero = new Hero();
	Flyer flyers[] = {};
	Bullet bullets[] = {};
	
	private int state = START;
	static final int START = 0;
	static final int RUNNING = 1;
	static final int PAUSE = 2;
	static final int GAME_OVER = 3;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame("fly");
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		//frame to be central
		Game game = new Game();
		frame.add(game);
		frame.setVisible(true);
		//a frame is default to be invisible
		game.action();
	}
	void nextOne() {
		flyers = Arrays.copyOf(flyers, flyers.length+1);
		
		Random r = new Random();
		if(r.nextInt(20)==0) {
			flyers[flyers.length-1] = new Bee();
		}else {
			flyers[flyers.length-1] = new Airplane();
		}
	}
	/**
	 * scripts about the outset
	 */
	void action() {
		//this shows after a mouse move is detected
		MouseAdapter l = new MouseAdapter() {

			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				if(state==RUNNING)hero.move(e.getX(), e.getY());
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if(state==START) state = RUNNING;
				if(state==GAME_OVER) {
					state = START;
					hero = new Hero();
					bullets = new Bullet[0];
					flyers = new Flyer[0];
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				if(state==PAUSE) state = RUNNING;
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				if(state==RUNNING) state = PAUSE;
			}
			
			
		};
		//this detect a mouse motion
		this.addMouseMotionListener(l);
		//this detect a mouse click
		this.addMouseListener(l);
		
		
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			//method run must be overridden
			//for a script
			@Override
			public void run() {
				// TODO Auto-generated method stub
				//input what to do in this method
				if(state==RUNNING) {
				
					runTimes++;
					if(runTimes%20==0) {
						nextOne();
					}
					for(int i=0;i<flyers.length;i++) {
						flyers[i].step();
					}
					if(runTimes%20==0) {
						shoot();
					}
					for(int i=0;i<bullets.length;i++) {
						bullets[i].step();
					}
					bang();
					hit();
					outOfBounds();
				}
				repaint();
				//must whenever screen alters
			}
			
		}, 10,10);
	}
	/**
	 * this method paint the window
	 */
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(background, 0, 0, null);
		paintHero(g);
		paintFlyers(g);
		paintBullets(g);
		paintLines(g);
		
		switch(state) {
		case START:g.drawImage(start, 0, 0, null);break;
		case PAUSE:g.drawImage(pause, 0, 0, null);break;
		case GAME_OVER:g.drawImage(gameover, 0, 0, null);break;
		}
	}
	void paintHero(Graphics g) {
		g.drawImage(hero0, hero.x, hero.y, null);
	}
	void paintFlyers(Graphics g){
		for(int i=0;i<flyers.length;i++) {
			g.drawImage(flyers[i].image, flyers[i].x, flyers[i].y, null);
		}
		
	}
	void paintBullets(Graphics g) {
		for(int i=0;i<bullets.length;i++) {
			g.drawImage(bullets[i].image, bullets[i].x, bullets[i].y, null);
		}
	}
	void paintLines(Graphics g) {
		int x = 10;
		int y = 15;
		
		//here shows how to alter fonts.
		Font font = new Font(Font.SANS_SERIF,Font.BOLD,16);
		g.setFont(font);
		
		g.drawString("SCORE: "+hero.getScore(), x, y);
		y += 20;
		g.drawString("LIFE: "+hero.getLife(), x, y);
	}
	/**
	 * get bullets from method shoot in Hero.java
	 */
	void shoot() {
		Bullet[] newBullets = hero.shoot();
		bullets = Arrays.copyOf(bullets, bullets.length+newBullets.length);
		System.arraycopy(newBullets, 0, bullets, bullets.length-newBullets.length, newBullets.length);
	}
	/**
	 * shows what to do after a collision
	 */
	void bang() {
		for(int i=0;i<bullets.length;i++) {
			for(int j=0;j<flyers.length;j++) {
				if(Flyer.bang(flyers[j], bullets[i])) {
					hero.getScore_Award(flyers[j]);
					flyers[j] = flyers[flyers.length-1];
					flyers = Arrays.copyOf(flyers, flyers.length-1);
					bullets[i] = bullets[bullets.length-1];
					bullets = Arrays.copyOf(bullets, bullets.length-1);
					i--;
					break;
				}
			}
		}
	}
	void outOfBounds() {
		Bullet[] Blives = new Bullet[bullets.length];
		int index = 0;
		for(int i=0;i<bullets.length;i++) {
			if(!bullets[i].outOfBounds()) {
				Blives[index] = bullets[i];
				index++;
			}
		}
		bullets = Arrays.copyOf(Blives, index);//index+1 ?
		
		
		Flyer[] Flives = new Flyer[flyers.length];
		index = 0;
		for(int i=0;i<flyers.length;i++) {
			if(!flyers[i].outOfBounds()) {
				Flives[index] = flyers[i];
				index++;
			}
		}
		flyers = Arrays.copyOf(Flives, index);//index+1 ?
		//??? why not flyers = Flives
	}
	void hit() {//why cannot merely call method hit
		Flyer lives[] = new Flyer[flyers.length];
		int index = 0;
		for(int i=0;i<flyers.length;i++) {
			if(!hero.hit(flyers[i])) {
				lives[index] = flyers[i];
				index++;
			}
		}
		if(hero.getLife()<=0)state = GAME_OVER;
		
		flyers = Arrays.copyOf(lives, index);
	}
}
