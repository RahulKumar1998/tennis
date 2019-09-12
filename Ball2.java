import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;



public class Ball2 {

	int count1,count2;
	double xVel,yVel,x,y;
	public Ball2()
	{
		count1=0;
		count2=0;
		x=300;
		y=450;
		xVel=-3;
		yVel=-3;
		
		//xVel=getRandomSpeed()* getRandomDirection();
		//yVel=getRandomSpeed()* getRandomDirection() ;
	}
	public void setX(int a)
	{
		this.x=a;
		xVel=-3;
		yVel=-3;
	}
	public double getRandomSpeed()
	{
		return (Math.random()*3 +2);
	}
	public int getRandomDirection()
	{
		int rand =(int)(Math.random()*2);
		if(rand==1)
			return 1;
		else
			return -1;
	}
	public void draw(Graphics g)
	{
		g.setColor(Color.red);
		g.fillOval((int)x-10, (int)y-10,20,20);
		Font fon2= new Font("arial",Font.BOLD,20);
		g.setFont(fon2);
		g.drawString("Score : "+count1, 20, 20);
		g.drawString("Score : " +count2, 780, 20);
	/*	if(Tennis.gamemode==GAMEMODE.MULTIPLAYER)
		{
			g.drawString("Score 2 :"+count2, 20, 500);
		}*/
			
	}
	
	/*public Circle bounds()
	{
		new Circle(x,y,20,20);
	}*/
	/*public int getScore(){
        return 1; 
     }
	private boolean isScored = false;



    public boolean isScored(){
        return isscored;
    }

    public void setScored(){
        isscored = true;
    }*/
	public void checkPaddleCollision(Paddle p1, Paddle p2)
	{
		//boolean collision1 =false;
		//boolean collision2 =false;
		if(x<=30)//50
		{
			if(y>=p1.getY() && y <=p1.getY()+80)
				{
				 	xVel= -xVel;
				 		count1++;
				 		//collision1 =true;
				}
				else
				{ 
					//collision1=false;
				}
		}
			
		else if(x>=860)//650
		{
			if(y>=p2.getY() && y <=p2.getY()+80)
			{	
				xVel=-xVel;
				count2++;
						  		//collision2=true;
			}
			else
				{
				   	//collision2 =false;
				}
			
		}
		/*if(collision1)
			count1++;
		else if(collision2)
			count2++;
		*/
		
	}
	public void move()
	{
		x += xVel;
		y += yVel;
		if(y<10)
			yVel= -yVel;
		if(y>690)//490
			yVel = -yVel;
	}
	public int getX()
	{
		return (int) x;
	}
	public int getY()
	{
		return (int) y;
	}
}
