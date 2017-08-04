

import java.awt.Color;
import java.awt.Graphics;

public class Bishop extends Piece {
	public Bishop(boolean isBlack){
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
		g.fillOval(positionX+(int)(squareWidth*19.0/45.0),positionY+(int)(squareWidth*2.0/45.0),(int)(squareWidth*8.0/45.0),(int)(squareWidth*7.0/45.0));
		g.fillOval(positionX+(int)(squareWidth*14.0/45.0),positionY+(int)(squareWidth*7.0/45.0),(int)(squareWidth*18.0/45.0),(int)(squareWidth*8.0/45.0));
		g.fillRect(positionX+(int)(squareWidth*4.0/9.0),positionY+(int)(squareWidth*3.0/9.0),(int)(squareWidth*7.0/45.0),(int)(squareWidth*17.0/45.0));
		g.fillRect(positionX+(int)(squareWidth*2.0/9.0),positionY+(int)(squareWidth*32.0/45.0),(int)(squareWidth*5.0/9.0),(int)(squareWidth*8.0/45.0));
	}

	@Override
	public boolean canCapture(int ssx, int ssy, int tsx, int tsy) {
		// TODO Auto-generated method stub
		if(Math.abs(tsx-ssx)!=Math.abs(tsy-ssy)){
			return false;
		}else{
			int diffx=(tsx-ssx)/Math.abs(tsx-ssx);
			int diffy=(tsy-ssy)/Math.abs(tsy-ssy);
			ssx+=diffx;
			ssy+=diffy;
			while(ssx!=tsx && ssy!=tsy){
				if(ChessFrame.pieces[ssx][ssy]!=null){
					return false;
				}
				ssx+=diffx;
				ssy+=diffy;
			}
			return true;
		}
	}

	@Override
	public boolean canMove(int ssx, int ssy, int tsx, int tsy) {
		// TODO Auto-generated method stub
		if(Math.abs(tsx-ssx)!=Math.abs(tsy-ssy)){
			return false;
		}else{
			int diffx=(tsx-ssx)/Math.abs(tsx-ssx);
			int diffy=(tsy-ssy)/Math.abs(tsy-ssy);
			ssx+=diffx;
			ssy+=diffy;
			while(ssx!=tsx && ssy!=tsy){
				if(ChessFrame.pieces[ssx][ssy]!=null){
					return false;
				}
				ssx+=diffx;
				ssy+=diffy;
			}
			return true;
		}
	}

	

}
