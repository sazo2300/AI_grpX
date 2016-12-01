
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
        Piece currentPiece = move.getOrigin().getPiece();
        int dx = move.getDestination().getPosition().getX() - move.getOrigin().getPosition().getX();
        int dy = move.getDestination().getPosition().getY() - move.getOrigin().getPosition().getY();
        
        if(currentPiece.getType().equals(Piece.Type.BLANK)){
            return false;
        } else if(currentPiece.getType().equals(Piece.Type.PAWN)){
            if(dx == 0 && move.getDestination().getPiece().getType() == Piece.Type.BLANK){
                if(dy == 1)
                    return true;
                if(dy == 2)
                    if(currentPiece.isFirstMove())
                        return true;
                    else
                        return false;
            }
            if(move.getDestination().getPiece().getType() != Piece.Type.BLANK 
                    && move.getOrigin().getPiece().getColor() != move.getDestination().getPiece().getColor()){
                if(Math.abs(dx)== 1
                        && dy == 1){
                    return true;
                }
            }
        } else if(currentPiece.getType().equals(Piece.Type.ROOK)){
            return freeStraightLine(move);
        } else if(currentPiece.getType().equals(Piece.Type.KNIGHT)){
            return (dx != 0 && dy != 0 && Math.abs(dx) + Math.abs(dy) == 3);
        } else if(currentPiece.getType().equals(Piece.Type.BISHOP)){
            return freeDiagonalLine(move);
        } else if(currentPiece.getType().equals(Piece.Type.QUEEN)){
            if(freeStraightLine(move) ^ freeDiagonalLine(move)){
                return true;
            }
        } else if(currentPiece.getType().equals(Piece.Type.KING)){
            if(move.getDestination().getPiece().getColor().equals(move.getOrigin().getPiece().getColor())){
                return false;
            } 
            if(Math.abs(dx) < 2 && Math.abs(dy) < 2){
                return true;
            }
            //Hvis tid, implementer rokade
        } 
        return false;
    }
    
    public List<Move> getValidMoves(Player player) {
        return null;
    }
    
    public void move(Move move) {
        
        
        move.getOrigin().getPiece().setFirstMove(false);
    }
    
    public boolean freeDiagonalLine(Move move){
        int x = move.getOrigin().getPosition().getX();
        int y = move.getOrigin().getPosition().getY();
        int _x = move.getDestination().getPosition().getX();
        int _y = move.getDestination().getPosition().getY();
        int dx = _x - x;
        int dy = _y - y;
        
        if(dx == 0 || dy == 0){
            return false;
        }
        int vx = (dx>0) ? -1 : 1;
        int vy = (dy>0) ? -1 : 1;
        
        if(Math.abs(dx) != Math.abs(dy)){
            return false;
        }
        
        for(int i = _x + vx, j = _y+vy ; i != x ; i+=vx, j+=vy){
            if(state[i][j].getPiece().getType() != Piece.Type.BLANK){
                return false;
            }
            return true;
        }
        
        return false;
    }
    
    public boolean freeStraightLine(Move move){
        int x = move.getOrigin().getPosition().getX();
        int y = move.getOrigin().getPosition().getY();
        int _x = move.getDestination().getPosition().getX();
        int _y = move.getDestination().getPosition().getY();
        int dx = _x - x;
        int dy = _y - y;
        
        
        if(dx != 0 && dy != 0){
            return false;
        } else if(dx == 0 ^ dy == 0){
            if(!move.getDestination().getPiece().getType().equals(Piece.Type.BLANK) && 
                    move.getOrigin().getPiece().getColor().equals(move.getDestination().getPiece().getColor())){
                return false;
            }
            if(dx>0){
                //OPAF
                for(int i = x+1 ; i < _x ; i++){
                    if(!state[i][y].getPiece().getType().equals(Piece.Type.BLANK)){
                        return false;
                    }
                }
            } else if(dx<0){
                //NEDAAAA
                for(int i = x-1 ; i > _x ; i--){
                    if(!state[i][y].getPiece().getType().equals(Piece.Type.BLANK)){
                        return false;
                    }
                }
            } else if(dy>0){
                //højre
                for(int i = y+1 ; i < _y ; i++){
                    if(!state[x][i].getPiece().getType().equals(Piece.Type.BLANK)){
                        return false;
                    }
                }
            } else if (dy<0){
                //venstre
                for(int i = y-1 ; i > _y ; i--){
                    if(!state[x][i].getPiece().getType().equals(Piece.Type.BLANK)){
                        return false;
                    }
                }
            }
            return true;
            
        }
        
        return false;
    }
    
    public void printBoard(){
        StringBuilder board = new StringBuilder();
        for(int i = 7 ; i >= 0 ; i--){
            board.append("\n" + (i + 1) + "|");
            for(int j = 7 ; j >= 0 ; j--){
                board.append(state[i][j].getPiece().getSymbol() + "|");
            } 
        }
        board.append("\n  a  b c  d  e f  g  h");
        System.out.println(board);
    }
    
    
}
