
/* ADVICE:canMove and canCapture methods are basically the same for all pieces except pawn. So these methods can be written in the same method with making a little difference
 * in pawn's method. And about the parameters of canMove and canCapture, instead of giving diffX and diffY as parameters, if we give the coordinates of selected and target squares 
 * it would be a lot easier to write these methods. So I did it that way. 
 */

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChessFrame theFrame = new ChessFrame();
		theFrame.setVisible(true);
	}

}
