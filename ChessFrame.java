

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

public class ChessFrame extends JFrame implements MouseListener{
	public static final int SQUARE_WIDTH = 45;
	public static final int BOARD_MARGIN = 50;
	int selectedSquareX = -1;
	int selectedSquareY = -1;
	public static Piece pieces[][] = new Piece[8][8];
	boolean yourTurn=false;
	public ChessFrame()
	{
		initializeChessBoard();
		setTitle("Chess Game");
		//let the screen size fit the board size
		setSize(SQUARE_WIDTH*8+BOARD_MARGIN*2, SQUARE_WIDTH*8+BOARD_MARGIN*2);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addMouseListener(this);
		
	}
	
	public void initializeChessBoard()
	{
		for(int i = 0; i<8; i++)
		{
			for(int j = 0; j<8; j++)
			{
				if(j == 1)
				{
					pieces[i][j] = new Pawn(false);
				}
				else if(j == 6)
				{
					pieces[i][j] = new Pawn(true);
				}
				else
				{
					pieces[i][j] = null;
				}
			}
			pieces[7][7]=new Rook(true);
			pieces[6][7]=new Knight(true);
			pieces[5][7]=new Bishop(true);
			pieces[4][7]=new Queen(true);
			pieces[3][7]=new King(true);
			pieces[2][7]=new Bishop(true);
			pieces[1][7]=new Knight(true);
			pieces[0][7]=new Rook(true);
			pieces[7][0]=new Rook(false);
			pieces[6][0]=new Knight(false);
			pieces[5][0]=new Bishop(false);
			pieces[4][0]=new Queen(false);
			pieces[3][0]=new King(false);
			pieces[2][0]=new Bishop(false);
			pieces[1][0]=new Knight(false);
			pieces[0][0]=new Rook(false);
		}
	}
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		//print the board 's lines to show squares
		for(int i = 0; i<=8; i++)
		{
			g.drawLine(BOARD_MARGIN, 
					BOARD_MARGIN+(i)*SQUARE_WIDTH, 
					BOARD_MARGIN+8*SQUARE_WIDTH, 
					BOARD_MARGIN+(i)*SQUARE_WIDTH);
			g.drawLine(BOARD_MARGIN+(i)*SQUARE_WIDTH, 
					BOARD_MARGIN, 
					BOARD_MARGIN+(i)*SQUARE_WIDTH, 
					BOARD_MARGIN+8*SQUARE_WIDTH);
		}
		//print the pieces
		for(int i = 0; i<8; i++)
		{
			for(int j = 0; j<8; j++)
			{
				if(pieces[i][j] != null)
				{
					pieces[i][j].drawYourself(g, i*SQUARE_WIDTH+BOARD_MARGIN, 
							j*SQUARE_WIDTH+BOARD_MARGIN, SQUARE_WIDTH);
				}
			}
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		//System.out.println("Clicked");
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		//System.out.println("Pressed");
		//calculate which square is selected 
		selectedSquareX = (e.getX()-BOARD_MARGIN)/SQUARE_WIDTH;
		selectedSquareY = (e.getY()-BOARD_MARGIN)/SQUARE_WIDTH;
		System.out.println(selectedSquareX+","+selectedSquareY);
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		//System.out.println("Released");
		//calculate which square is targeted
		int targetSquareX = (e.getX()-BOARD_MARGIN)/SQUARE_WIDTH;
		int targetSquareY = (e.getY()-BOARD_MARGIN)/SQUARE_WIDTH;
		System.out.println(targetSquareX+","+targetSquareY+"\n");
		//if these are inside the board
		if(selectedSquareX >= 0 && selectedSquareY >= 0 &&
				selectedSquareX < 8 && selectedSquareY < 8 &&
				targetSquareX >= 0 && targetSquareY >= 0 &&
						targetSquareX < 8 && targetSquareY < 8)
		{
			System.out.println("inside");
			if(pieces[selectedSquareX][selectedSquareY] != null && pieces[selectedSquareX][selectedSquareY].isBlack==yourTurn)
			{
				System.out.println("selected");
				/*
				int diffX = targetSquareX - selectedSquareX;
				int diffY = targetSquareY - selectedSquareY;*/
				if(pieces[targetSquareX][targetSquareY] != null)
				{
					System.out.println("a target");
					
					if(pieces[selectedSquareX][selectedSquareY].canCapture(selectedSquareX, selectedSquareY, targetSquareX, targetSquareY) && pieces[targetSquareX][targetSquareY].isBlack!=yourTurn)
					{
						System.out.println("can capture");
						pieces[targetSquareX][targetSquareY] = 
								pieces[selectedSquareX][selectedSquareY];
						pieces[selectedSquareX][selectedSquareY] = null;
						yourTurn= !yourTurn;
					}
				}
				else
				{
					System.out.println("no target");
					if(pieces[selectedSquareX][selectedSquareY].canMove(selectedSquareX, selectedSquareY, targetSquareX, targetSquareY))
					{
						System.out.println("can move");
						pieces[targetSquareX][targetSquareY] = 
								pieces[selectedSquareX][selectedSquareY];
						pieces[selectedSquareX][selectedSquareY] = null;
						yourTurn= !yourTurn;
					}
				}
			}
		}
		
		repaint();
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		//System.out.println("Entered");
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		//System.out.println("Exited");
		
	}
}
