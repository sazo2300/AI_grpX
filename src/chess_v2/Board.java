
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
        for(int i = 0 ; i < 8 ; i++){
            state[1][i] = new Field(1, i, new Piece(Game.Color.WHITE, Piece.Type.PAWN));
            state[6][i] = new Field(6, i, new Piece(Game.Color.BLACK, Piece.Type.PAWN));
        }
        for(int i = 2 ; i < 6 ; i++){
            for(int j = 0 ; j < 8 ; j++){
                state[i][j] = new Field(i, j, new Piece((i+j)%2==0? Game.Color.WHITE : Game.Color.BLACK, Piece.Type.BLANK));
            }
            
        }
 
        state[0][0] = new Field("a1", new Piece(Game.Color.WHITE, Piece.Type.ROOK));
        state[0][1] = new Field("b1", new Piece(Game.Color.WHITE, Piece.Type.KNIGHT));
        state[0][2] = new Field("c1", new Piece(Game.Color.WHITE, Piece.Type.BISHOP));
        state[0][3] = new Field("d1", new Piece(Game.Color.WHITE, Piece.Type.QUEEN));
        state[0][4] = new Field("e1", new Piece(Game.Color.WHITE, Piece.Type.KING));
        state[0][5] = new Field("f1", new Piece(Game.Color.WHITE, Piece.Type.BISHOP));
        state[0][6] = new Field("g1", new Piece(Game.Color.WHITE, Piece.Type.KNIGHT));
        state[0][7] = new Field("h1", new Piece(Game.Color.WHITE, Piece.Type.ROOK));
        
        state[7][0] = new Field("a8", new Piece(Game.Color.BLACK, Piece.Type.ROOK));
        state[7][1] = new Field("b8", new Piece(Game.Color.BLACK, Piece.Type.KNIGHT));
        state[7][2] = new Field("c8", new Piece(Game.Color.BLACK, Piece.Type.BISHOP));
        state[7][3] = new Field("d8", new Piece(Game.Color.BLACK, Piece.Type.QUEEN));
        state[7][4] = new Field("e8", new Piece(Game.Color.BLACK, Piece.Type.KING));
        state[7][5] = new Field("f8", new Piece(Game.Color.BLACK, Piece.Type.BISHOP));
        state[7][6] = new Field("g8", new Piece(Game.Color.BLACK, Piece.Type.KNIGHT));
        state[7][7] = new Field("h8", new Piece(Game.Color.BLACK, Piece.Type.ROOK));
        
        
    }
    
    public boolean isMoveValid(Move move) {
        return false;
    }
    
    public List<Move> getValidMoves(Player player) {
        return null;
    }
    
    public void move(Move move) {
        
    }
    
    public void printBoard(){
        StringBuilder board = new StringBuilder();
        for(int i = 7 ; i >= 0 ; i--){
            board.append("\n" + (i + 1) + "|");
            for(int j = 7 ; j >= 0 ; j--){
                board.append(state[i][j].getPiece().getSymbol() + "|");
            } 
        }
        board.append("\n  a  b  c  d  e  f  g  h");
        System.out.println(board);
    }
    
    
}
