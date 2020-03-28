package AWT;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class labels extends Frame{

	labels(){
		setLayout(new FlowLayout());
		setBackground(Color.cyan);
		
		add(new Label("one"));
		add(new Label("two"));
		add(new Button("three"));
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		labels l = new labels();
		
		
		l.setSize(300, 100);
		l.setTitle("demo");
		l.setVisible(true);
		l.setLocationRelativeTo(null);
	}

}
