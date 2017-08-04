

import java.awt.Color;
import java.awt.Graphics;

public class Queen extends Piece {
	public Queen(boolean isBlack){
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
		g.fillRect(positionX+(int)(squareWidth*20.0/45.0), positionY+(int)(squareWidth*4.0/45.0), (int)(squareWidth*6.0/45.0), (int)(squareWidth*2.0/45.0));
		g.fillRect(positionX+(int)(squareWidth*22.0/45.0), positionY+(int)(squareWidth*2.0/45.0), (int)(squareWidth*2.0/45.0), (int)(squareWidth*7.0/45.0));
		g.fillOval(positionX+(int)(squareWidth*14.0/45.0),positionY+(int)(squareWidth*7.0/45.0),(int)(squareWidth*18.0/45.0),(int)(squareWidth*8.0/45.0));
		g.fillRect(positionX+(int)(squareWidth*4.0/9.0),positionY+(int)(squareWidth*3.0/9.0),(int)(squareWidth*7.0/45.0),(int)(squareWidth*17.0/45.0));
		g.fillRect(positionX+(int)(squareWidth*2.0/9.0),positionY+(int)(squareWidth*32.0/45.0),(int)(squareWidth*5.0/9.0),(int)(squareWidth*8.0/45.0));
	}

	@Override
	public boolean canCapture(int ssx, int ssy, int tsx, int tsy) {
		// TODO Auto-generated method stub
		int x=tsx-ssx;
		int y=tsy-ssy;
		if(Math.abs(x)==Math.abs(y)){
			int diffx=x/Math.abs(x);
			int diffy=y/Math.abs(y);
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
		}else if(x==0 && y!=0){
			int diffy=y/Math.abs(y);
			ssy+=diffy;
			while(ssy!=tsy){
				if(ChessFrame.pieces[ssx][ssy]!=null){
					return false;
				}
				ssy+=diffy;
			}
			return true;
		}else if(y==0&&x!=0){
			int diffx=x/Math.abs(x);
			ssx+=diffx;
			while(ssx!=tsx){
				if(ChessFrame.pieces[ssx][ssy]!=null){
					return false;
				}
				ssx+=diffx;
			}
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean canMove(int ssx, int ssy, int tsx, int tsy) {
		// TODO Auto-generated method stub
		int x=tsx-ssx;
		int y=tsy-ssy;
		if(Math.abs(x)==Math.abs(y)){
			int diffx=x/Math.abs(x);
			int diffy=y/Math.abs(y);
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
		}else if(x==0 && y!=0){
			int diffy=y/Math.abs(y);
			ssy+=diffy;
			while(ssy!=tsy){
				if(ChessFrame.pieces[ssx][ssy]!=null){
					return false;
				}
				ssy+=diffy;
			}
			return true;
		}else if(y==0 &&x!=0){
			int diffx=x/Math.abs(x);
			ssx+=diffx;
			while(ssx!=tsx){
				if(ChessFrame.pieces[ssx][ssy]!=null){
					return false;
				}
				ssx+=diffx;
			}
			return true;
		}else{
			return false;
		}
	}

	

}
