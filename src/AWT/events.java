package AWT;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
//import java

public class events extends Frame implements MouseMotionListener, MouseListener {
	String msg = "";
	int x=100,y=100;
	
	events()  {
		//super();
		addMouseListener(this);
		addMouseMotionListener(this);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		msg = "mouse clicked";
		repaint();
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}
	
	public void paint(Graphics g) {
		g.drawString(msg, x, y);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		events appwin = new events();
		
		appwin.setSize(300, 300);
		appwin.setTitle("123");
		appwin.setVisible(true);
		
	}

}
