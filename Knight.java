

import java.awt.Color;
import java.awt.Graphics;

public class Knight extends Piece{
	public Knight(boolean isBlack){
		this.isBlack=isBlack;
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
		g.fillRect(positionX+(int)(squareWidth*2.0/9.0),positionY+(int)(squareWidth*1.0/9.0),(int)(squareWidth*17.0/45.0),(int)(squareWidth*2.0/9.0));
		g.fillRect(positionX+(int)(squareWidth*2.0/9.0),positionY+(int)(squareWidth*3.0/9.0),(int)(squareWidth*1.0/9.0),(int)(squareWidth*1.0/9.0));	
		g.fillRect(positionX+(int)(squareWidth*4.0/9.0),positionY+(int)(squareWidth*3.0/9.0),(int)(squareWidth*7.0/45.0),(int)(squareWidth*17.0/45.0));
		g.fillRect(positionX+(int)(squareWidth*2.0/9.0),positionY+(int)(squareWidth*32.0/45.0),(int)(squareWidth*5.0/9.0),(int)(squareWidth*8.0/45.0));
	}

	@Override
	public boolean canMove(int ssx, int ssy, int tsx, int tsy) {
		// TODO Auto-generated method stub
		int x=tsx-ssx;
		int y=tsy-ssy;
		return ((x*y==-2)||(x*y==2));
	}

	@Override
	public boolean canCapture(int ssx, int ssy, int tsx, int tsy) {
		int x=tsx-ssx;
		int y=tsy-ssy;
		return ((x*y==-2)||(x*y==2));
		// TODO Auto-generated method stub
	}

	

}
