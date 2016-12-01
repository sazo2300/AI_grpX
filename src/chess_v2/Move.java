package chess_v2;

import chess_v2.Field.Position;

/**
 *
 * @author atila29
 */
public class Move {
    
    public Field origin;
    public Field destination;
    public Board board = null;
    
    public boolean ENPASSE, QCASTLE, KCASTLE, PROMOTION, CHECKMATE;

    public Move(Field origin, Field destination, Board state){
        this.origin = origin;
        this.destination = destination;
        this.board = state;
        
    }
    
    public Field getOrigin() {
        return origin;
    }

    public void setOrigin(Field origin) {
        this.origin = origin;
    }

    public Field getDestination() {
        return destination;
    }

    public void setDestination(Field destination) {
        this.destination = destination;
    }

    public boolean isENPASSE() {
        return ENPASSE;
    }

    public void setENPASSE(boolean ENPASSE) {
        this.ENPASSE = ENPASSE;
    }

    public boolean isQCASTLE() {
        return QCASTLE;
    }

    public void setQCASTLE(boolean QCASTLE) {
        this.QCASTLE = QCASTLE;
    }

    public boolean isKCASTLE() {
        return KCASTLE;
    }

    public void setKCASTLE(boolean KCASTLE) {
        this.KCASTLE = KCASTLE;
    }

    public boolean isPROMOTION() {
        return PROMOTION;
    }

    public void setPROMOTION(boolean PROMOTION) {
        this.PROMOTION = PROMOTION;
    }

    public boolean isCHECKMATE() {
        return CHECKMATE;
    }

    public void setCHECKMATE(boolean CHECKMATE) {
        this.CHECKMATE = CHECKMATE;
    }
    
    
    
    
    
    public boolean isSpecial(){
		return (ENPASSE || QCASTLE || KCASTLE || PROMOTION || CHECKMATE);
    }
}
