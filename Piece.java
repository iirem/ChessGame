

import java.awt.Graphics;

public abstract class Piece {
	public boolean isBlack;
	public abstract void drawYourself(Graphics g, int positionX, int positionY, int squareWidth);
	//public abstract boolean canMove(int x, int y);
	//public abstract boolean canCapture(int x, int y);
	public abstract boolean canCapture(int ssx,int ssy, int tsx, int tsy);
	public abstract boolean canMove(int ssx, int ssy, int tsx, int tsy);
}
