
import java.awt.Color;
import java.awt.Graphics;

public class AIPaddle implements Paddle
{
	double y,yVel;
	boolean upAccel,downAccel;
	int i,x;
	final double GRAVITY = 0.94;
	Ball b1;

	public AIPaddle(int player,Ball b)
	{
		b1=b;
		y=310;//y=210;
		yVel=0;
		upAccel= false;
		downAccel=false;
		if(player==1)
		x=10;	//x=20;
		else
			x=870;//x=660;
	}

	public void draw(Graphics g) {
		g.setColor(Color.white);
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
		y=b1.getY()-40;
		if(yVel>=5)
			yVel=5;
		else if(yVel<=-5)
			yVel=-5;
		y +=yVel;
		if(y<0)
			y=0;
		if(y>620)//if(y>420)
			y=620;//y=420;
		
	}

	public int getY() {
		return (int) y;
		// TODO Auto-generated method stub
		
	}

}
