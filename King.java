

import java.awt.Color;
import java.awt.Graphics;

public class King extends Piece{
	public King(boolean isBlack){
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
		int[] firstTriangleX={positionX+(int)(squareWidth*3.0/9.0), positionX+(int)(squareWidth*17.0/45.0), positionX+(int)(squareWidth*4.0/9.0)};
		int[] firstTriangleY={positionY+(int)(squareWidth*9.0/45.0), positionY+(int)(squareWidth*2.0/45.0), positionY+(int)(squareWidth*7.0/45.0)};
		int[] secondTriangleX={positionX+(int)(squareWidth*4.0/9.0), positionX+(int)(squareWidth*22.0/45.0), positionX+(int)(squareWidth*5.0/9.0)};
		int[] secondTriangleY={positionY+(int)(squareWidth*7.0/45.0), positionY+(int)(squareWidth*2.0/45.0), positionY+(int)(squareWidth*8.0/45.0)};
		int[] thirdTriangleX={positionX+(int)(squareWidth*5.0/9.0), positionX+(int)(squareWidth*27.0/45.0), positionX+(int)(squareWidth*6.0/9.0)};
		int[] thirdTriangleY={positionY+(int)(squareWidth*7.0/45.0), positionY+(int)(squareWidth*2.0/45.0), positionY+(int)(squareWidth*9.0/45.0)};
		g.fillPolygon(firstTriangleX , firstTriangleY, 3);
		g.fillPolygon(secondTriangleX , secondTriangleY, 3);
		g.fillPolygon(thirdTriangleX , thirdTriangleY, 3);
		g.fillOval(positionX+(int)(squareWidth*14.0/45.0),positionY+(int)(squareWidth*7.0/45.0),(int)(squareWidth*18.0/45.0),(int)(squareWidth*8.0/45.0));
		g.fillRect(positionX+(int)(squareWidth*4.0/9.0),positionY+(int)(squareWidth*3.0/9.0),(int)(squareWidth*7.0/45.0),(int)(squareWidth*17.0/45.0));
		g.fillRect(positionX+(int)(squareWidth*2.0/9.0),positionY+(int)(squareWidth*32.0/45.0),(int)(squareWidth*5.0/9.0),(int)(squareWidth*8.0/45.0));
	}

	@Override
	public boolean canCapture(int ssx, int ssy, int tsx, int tsy) {
		// TODO Auto-generated method stub
		int x=tsx-ssx;
		int y=tsy-ssy;
		if(x==0 || x==1 || x==-1){
			return y==1||y==-1;
		}else if(y==0 || y==1 || y==-1){
			return x==1||x==-1;
		}
		else{
			return false;
		}
	}

	@Override
	public boolean canMove(int ssx, int ssy, int tsx, int tsy) {
		// TODO Auto-generated method stub
		int x=tsx-ssx;
		int y=tsy-ssy;
		if(x==0 || x==1 || x==-1){
			return y==1||y==-1;
		}else if(y==0 || y==1 || y==-1){
			return x==1||x==-1;
		}
		else{
			return false;
		}
	}

}
