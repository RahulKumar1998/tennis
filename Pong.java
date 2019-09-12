
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Pong extends Applet implements Runnable, KeyListener
{
	/**
	 * 
	 */
	//AudioClip clip;
	
	private static final long serialVersionUID = 1L;
	public enum STATE
	{
		MENU,
		GAME,
		GAMEOVER
	};
	public enum GAMEMODE
	{
		SINGLE,
		MULTIPLAYER,
	
	};
	int highscore;
	public static GAMEMODE gamemode;
	private STATE state ;
	final int HEIGHT=700, WIDTH=900;
	//private Menu menu;
	Thread thread;
	HumanPaddle p1;
	HumanPaddle p2;
	//Ball2 b2;
	AIPaddle p3;
	Ball b1;
	Ball2 b2;
	File file;
	BufferedReader br;
	static FileWriter fileWriter;
	Graphics gfx;
	int restart=0;
	Image img;
	public void init()
	{
		b2=new Ball2();
		
		highscore=0;
		 file = new File("D:\\java\\Tennis\\src\\score.txt");
		 try {
			br = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		 try {
			fileWriter = new FileWriter(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		state = STATE.MENU;
		//menu =new Menu();
		//clip = getAudioClip(getDocumentBase(), "kabira.au");
		b1 =new Ball();
		p1=new HumanPaddle(1);
		img = createImage(WIDTH,HEIGHT);
		gfx=img.getGraphics();
		thread=new Thread(this);
		thread.start();
		this.resize(WIDTH,HEIGHT);
		this.addKeyListener(this);
	}
	public void draw1(Graphics g)
	{
	/*	gfx.setColor(Color.green);
		gfx.fillRect(0,0,WIDTH,HEIGHT);
		Font fnt0= new Font("arial",Font.BOLD,50);
		gfx.setFont(fnt0);
		gfx.setColor(Color.blue);
		gfx.drawString("Pong",250,50);
		Font fnt1= new Font("arial",Font.PLAIN,25);
		g.setFont(fnt1);
		g.setColor(Color.black);
		g.drawString("Press Enter to start single game", 150, 300);
		g.drawString("Press Space  to start the multiplayer game", 150, 400);
		//restart=0;*/
		
	}
	public void draw2(Graphics g)
	{
		
	/*	Font fnt0= new Font("arial",Font.BOLD,25);
		g.setFont(fnt0);
		g.setColor(Color.blue);
		g.drawString("Game over, press R to restart.",250,150); */
	}
	public static void usingFileWriter(String d) throws IOException
	{
	    String fileContent = d;//"Hello Learner !! Welcome to howtodoinjava.com.";
	     
	   // FileWriter fileWriter = new FileWriter("D:\\java\\Tennis\\src\\score.txt");
	    fileWriter.write(fileContent);
	    fileWriter.close();
	}
	public void paint(Graphics g)
	{
		if(state==STATE.GAME)
		{
		
			Font fnt1= new Font("arial",Font.BOLD,25);
			gfx.setFont(fnt1);
			gfx.setColor(Color.black);
			gfx.fillRect(0,0,WIDTH,HEIGHT);
			if(b1.getX()<17 || b1.getX() >910 || b2.getX()<17 || b2.getX() >910 ) //710
			{
				
				gfx.setColor(Color.red);
				//gfx.drawString("Game Over!", 250, 250);
				if(gamemode==GAMEMODE.SINGLE)
				{
					String st = null; 
					  try {
						while ((st = br.readLine()) != null) 
							highscore=Integer.parseInt(st);
						if(highscore<=b1.count1)
						{	//System.out.println("NEW HIGH SCORE CREATED!");
							highscore=b1.count1;
						try {
							usingFileWriter(""+highscore);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					  
				gfx.drawString("Your Score is "+ b1.count1, 250, 350);
				gfx.drawString("Highest Score :"+highscore,250,450);
				}
				else if(gamemode==GAMEMODE.MULTIPLAYER)
					{
					
					gfx.drawString("Player 1 Score : "+ (b1.count1+b2.count1), 250, 350);
					gfx.drawString("Player 2 Score : "+ (b1.count2+b2.count2), 250, 450);
					}
				//b1.count1=0;
				//b1.count2=0;
				//gfx.drawString("Game over", 200, 200);
				b1.setX(450);
				b2.setX(400);
			   state=STATE.GAMEOVER;
			  // restart=1;
			
				
			}
			else
			{
			p1.draw(gfx);
			b1.draw(gfx);
			
			if(gamemode==GAMEMODE.MULTIPLAYER)
				{
				p2.draw(gfx);
				b2.draw(gfx);
				}
			else if(gamemode==GAMEMODE.SINGLE)
				{
					p3.draw(gfx);
				}
		    }
			g.drawImage(img,0,0,this);
		}
		else if(state==STATE.MENU)
		{
			//draw1(g);
			gfx.setColor(Color.black);
			gfx.fillRect(0,0,WIDTH,HEIGHT);
			Font fnt0= new Font("arial",Font.BOLD,50);
			gfx.setFont(fnt0);
			gfx.setColor(Color.white);
			gfx.drawString("CLASSIC PONG",230,100);
			Font fnt1= new Font("arial",Font.PLAIN,25);
			gfx.setFont(fnt1);
			gfx.setColor(Color.red);
			gfx.drawString("Press ENTER to start single game", 200, 300);
			gfx.drawString("Press SPACE  to start the multiplayer game", 150, 400);
			g.drawImage(img,0,0,this);
			
		}
		else if(state==STATE.GAMEOVER)
		{
			//draw2(g);
			Font fnt0= new Font("arial",Font.BOLD,25);
			gfx.setFont(fnt0);
			gfx.setColor(Color.blue);
			gfx.drawString("Game over, press R to restart.",250,150); 
			b1.count1=0;
			b1.count2=0;
			g.drawImage(img,0,0,this);
		}
	/*	else if(state==STATE.MENU && restart==0)
		{
		//   menu.init();
		  // menu.start();
		   //menu.paint(g);
		draw1(g);
		}
		else if(state==STATE.MENU&&restart==1) 
		{
			draw2(g);
		}*/
	}
	public void run()
	{
		
			//clip.play();
			while(true)
			{
				
				//Graphics g;
				if(state==STATE.GAME)
				{
					//b1.setX(50);
					//b2.setX(100);
				p1.move();
				b1.move();
				
				if(gamemode==GAMEMODE.MULTIPLAYER)
				{
					p2.move();
					b2.move();
					b1.checkPaddleCollision(p1, p2);
					b2.checkPaddleCollision(p1, p2);
					
				}
				else if(gamemode==GAMEMODE.SINGLE)
				{
					if(p3==null)
						p3=new AIPaddle(1,b1);
					p3.move();
					b1.checkPaddleCollision(p1, p3);
					
				}
				repaint();
				}
				else if(state==STATE.MENU)
				{
					repaint();
				}
				else if(state==STATE.GAMEOVER)
				{
				  repaint();
				}
				
				
				try 
				{
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			}
				
			}
		
	}
	public void update(Graphics g)
	{
		paint(g);
	}
	@Override
	public void keyPressed(KeyEvent e) {
		if(state==STATE.GAME)
		 {
				if(e.getKeyCode()==KeyEvent.VK_UP)
				{
					p1.setUpAccel(true);
				}
				
				else if(e.getKeyCode()==KeyEvent.VK_DOWN)
				{
					p1.setDownAccel(true);
				}
				else if(e.getKeyCode()==KeyEvent.VK_W)
				{
				  p2.setUpAccel(true);
				}
				
				else if(e.getKeyCode()==KeyEvent.VK_S)
				{
					p2.setDownAccel(true);
				}
				else if(e.getKeyCode()==KeyEvent.VK_R)
				{
					state=STATE.MENU;
					
				}
		}
		else if(state==STATE.MENU)
		{
		 if(e.getKeyCode()==KeyEvent.VK_SPACE)
		{
			gamemode=GAMEMODE.MULTIPLAYER;
			state=STATE.GAME;
			p2=new HumanPaddle(2);
		}
		 else if(e.getKeyCode()==KeyEvent.VK_ENTER)
		 {
			 
        	 gamemode=GAMEMODE.SINGLE;
        	 state=STATE.GAME;
        	 p3=new AIPaddle(2,b1);
     //   repaint();
			 
		 }
		}
		else if(state==STATE.GAMEOVER)
		{
			if(e.getKeyCode()==KeyEvent.VK_R)
			{
				state=STATE.MENU;
				new Pong();
			}
		}
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		if(state==STATE.GAME)
		{
			
				if(e.getKeyCode()==KeyEvent.VK_UP)
				{
					p1.setUpAccel(false);
				}
				else if(e.getKeyCode()==KeyEvent.VK_DOWN)
				{
					p1.setDownAccel(false);
				}
				else if(e.getKeyCode()==KeyEvent.VK_W)
				{
				p2.setUpAccel(false);
				}
				else if(e.getKeyCode()==KeyEvent.VK_S)
				{
					p2.setDownAccel(false);
				}
		
		}
		else if(state==STATE.MENU)
		{	
				 if(e.getKeyCode()==KeyEvent.VK_SPACE)
						{
							state=STATE.GAME;
							//gamemode=GAMEMODE.MULTIPLAYER;
							
						}
				 /*else if(e.getKeyCode()==KeyEvent.VK_ENTER)
						 {
							 state=STATE.GAME;
							 
						 }*/
		}
		else if(state==STATE.GAMEOVER)
		{
			if(e.getKeyCode()==KeyEvent.VK_R)
			{
				state=STATE.MENU;
				//start();
			}
		}
		
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public void stop()
	{
		
	}
}

