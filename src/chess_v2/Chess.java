
package chess_v2;

import java.util.logging.Level;
import java.util.logging.Logger;


public class Chess {
    
    
    public static void main(String args[]){
        try {
            Player white = new Player(Game.Color.WHITE);
            Board board = new Board();
            board.printBoard();
            Move move = new Move(board.getField("b2"), board.getField("b4"));
            System.out.println(board.isMoveValid(move));
            board.move(white.getColor(), move);
            board.printBoard();
        } catch (Exception ex) {
            Logger.getLogger(Chess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
