
package chess_v2;

import java.util.List;

/**
 *
 * @author atila29
 */
public class Board {
    private Field[][] state = new Field[8][8];
    
    private List<Move> legalWhiteMoves;
    private List<Move> legalBlackMoves;

    private List<Move> validWhiteMoves;
    private List<Move> validBlackMoves;
    
    public Board() {
        
    }
    
    public boolean isMoveValid(Move move) {
        return false;
    }
    
    public List<Move> getValidMoves(Player player) {
        return null;
    }
    
    public void move(Move move) {
        
    }
    
    
    
    
}
