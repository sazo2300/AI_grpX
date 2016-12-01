package chess_v2;

import java.util.List;

/**
 *
 * @author atila29
 */
public class Piece {
    public enum Type {BLANK, PAWN, ROOK, KNIGHT, BISHOP, QUEEN, KING}
    private Game.Color color;
    private Type type;
    private int value;
    private List<Move> moves;
    private String symbol;

    public Piece(Game.Color color, Type type) {
        this.type = type;
        this.color = color;
        
        if(type == Type.PAWN) {
            this.value = 2;
            if(color.equals(Game.Color.WHITE))
                symbol = new String(Character.toChars(9817));
             else 
                symbol = new String(Character.toChars(9823));
        } else if(type == Type.BISHOP) {
            this.value = 5;
            if(color.equals(Game.Color.WHITE))
                symbol = new String(Character.toChars(9815));
             else 
                symbol = new String(Character.toChars(9821));
        } else if(type == Type.KNIGHT) {
            this.value = 7;
            if(color.equals(Game.Color.WHITE))
                symbol = new String(Character.toChars(9816));
             else 
                symbol = new String(Character.toChars(9822));
        } else if(type == Type.ROOK) {
            this.value = 4;
            if(color.equals(Game.Color.WHITE))
                symbol = new String(Character.toChars(9814));
             else 
                symbol = new String(Character.toChars(9820));
        } else if(type == Type.QUEEN) {
            this.value = 20;
            if(color.equals(Game.Color.WHITE))
                symbol = new String(Character.toChars(9813));
             else 
                symbol = new String(Character.toChars(9819));
        } else if(type == Type.KING) {
            this.value = Integer.MAX_VALUE;
            if(color.equals(Game.Color.WHITE))
                symbol = new String(Character.toChars(9812));
             else 
                symbol = new String(Character.toChars(9818));
        } else if(type == Type.BLANK) {
            this.value = 0;
            if(color.equals(Game.Color.WHITE))
                symbol = new String(Character.toChars(8195));
            else{ 
                symbol = new String(Character.toChars(9607));
            }
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
    
    public String getSymbol(){
        return symbol;
    }
}
