
import java.awt.Color;
import java.awt.Graphics;

public class HumanPaddle implements Paddle
{
	double y,yVel;
	boolean upAccel,downAccel;
	int i,x;
	final double GRAVITY = 0.94;

	public HumanPaddle(int player)
	{
		y=310;//y=210;
		yVel=0;
		upAccel= false;
		downAccel=false;
		if(player==1)
			x=10;//x=20;
		else
			x=870;	//x=660;
	}
/*	public Rectangle bounds()
	{
		return Rectangele(x,y,20,80);
	}
*/	
	public void draw(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(x, (int) y, 20,80);
		// TODO Auto-generated method stub
		
	}
	public void setUpAccel(boolean input)
	{
		upAccel=input;
	}
	public void setDownAccel(boolean input)
	{
		downAccel=input;
	}


	public void move() {
		if(upAccel)
		{
			yVel -= 2;
		}
		else if(downAccel)
		{
			yVel += 2;
		}
		else if(!upAccel && !downAccel)
		{
			yVel *= GRAVITY;
		}
		if(yVel>=5)
			yVel=5;
		else if(yVel<=-5)
			yVel=-5;
		y +=yVel;
		if(y<0)
			y=0;
		if(y>620)//if(y>420)
			y=620;//y=420;
		// TODO Auto-generated method stub
		
	}

	public int getY() {
		return (int) y;
		// TODO Auto-generated method stub
		
	}

}
