import java.applet.Applet;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;

public class Menu extends Applet implements ActionListener,KeyListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton b1;
	JButton b2;
	final int HEIGHT=700, WIDTH=900;
   public void init()
	{
		this.resize(WIDTH,HEIGHT);
		this.addKeyListener(this);
		
	}
    public void start()
    {
    	b1=new JButton("SinglePlayer");
    	add(b1);
    	b1.addActionListener(this);
    	b2=new JButton("Multiplayer");
    	add(b2);
    	b2.addActionListener(this);
    }
	public void paint(Graphics g)
	{
		
		Font fnt0= new Font("arial",Font.BOLD,50);
		g.setFont(fnt0);
		g.setColor(Color.blue);
		g.drawString("Pong",250,150);
		Font fnt1= new Font("arial",Font.PLAIN,25);
		g.setFont(fnt1);
		g.setColor(Color.green);
		g.drawString("Press Space to start single game", 150, 300);
		g.drawString("Press Enter  to start the multiplayer game", 150, 400);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
