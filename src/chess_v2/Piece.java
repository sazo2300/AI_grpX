package chess_v2;

import java.util.List;

/**
 *
 * @author atila29
 */
public class Piece {
    public enum Type {PAWN, ROOK, KNIGHT, BISHOP, QUEEN, KING}
    private Game.Color color;
    private Type type;
    private int value;
    private List<Move> moves;

    public Piece(Game.Color color, Type type) {
        this.type = type;
        this.color = color;
        
        if(type == Type.PAWN) {
            this.value = 2;
        } else if(type == Type.BISHOP) {
            this.value = 5;
        } else if(type == Type.KNIGHT) {
            this.value = 7;
        } else if(type == Type.ROOK) {
            this.value = 4;
        } else if(type == Type.QUEEN) {
            this.value = 20;
        } else if(type == Type.KING) {
            this.value = Integer.MAX_VALUE;
        }
    }
    
    public Game.Color getColor() {
        return color;
    }

    public void setColor(Game.Color color) {
        this.color = color;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }
}
