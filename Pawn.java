

import java.awt.Color;
import java.awt.Graphics;

public class Pawn extends Piece{
	public boolean hasMoved;
	public Pawn(boolean isBlack){
		this.isBlack=isBlack;
		this.hasMoved=false;		
	}

	@Override
	public void drawYourself(Graphics g, int positionX, int positionY, int squareWidth) {
		// TODO Auto-generated method stub

		if(isBlack)
		{
			g.setColor(Color.black);
		}
		else
		{
			g.setColor(Color.white);
		}
		
		g.fillOval(positionX+(int)(squareWidth*2.0/6.0), 
				positionY+squareWidth/8, 
				squareWidth/3, squareWidth/3);
		g.fillRect(positionX+(int)(squareWidth*4.0/10.0), 
				positionY+squareWidth/4, 
				squareWidth/5, squareWidth/2);
		g.fillRect(positionX+(int)(squareWidth*1.0/4.0), 
				positionY+(int)(squareWidth*3.0/5.0), 
				squareWidth/2, squareWidth/5);
		
	}

	@Override
	public boolean canMove(int ssx, int ssy, int tsx, int tsy) {
		// TODO Auto-generated method stub
		int x=tsx-ssx;
		int y=tsy-ssy;
		if(hasMoved){
			if(!isBlack)
			{
				if(y == 1 && x == 0)
				{
					return true;
				}
				else
				{
					return false;
				}
			}
			else
			{
				if(y == -1 && x == 0)
				{
					return true;
				}
				else
				{
					return false;
				}
			}
		}else{
			if(!isBlack)
			{
				if((y==1|| y==2) && x == 0)
				{
					hasMoved=true;
					return true;
				}
				else
				{
					return false;
				}
			}
			else
			{
				if((y == -1|| y==-2) && x == 0)
				{
					hasMoved=true;
					return true;
				}
				else
				{
					return false;
				}
			}
		}
	}

	@Override
	public boolean canCapture(int ssx, int ssy, int tsx, int tsy) {
		// TODO Auto-generated method stub
		int x=tsx-ssx;
		int y=tsy-ssy;
		if(!isBlack)
		{
			if((x == -1 || x == 1) && y == 1)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			if((x == -1 || x == 1) && y == -1)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
	}

}
