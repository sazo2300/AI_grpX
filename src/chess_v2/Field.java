package chess_v2;

import java.util.Vector;


public class Field {
    private Piece piece = null;
    private Position position;
    private String boardIndex;
    
    
    public Field(String f, Piece piece){
        this(f);
        this.piece = piece;
    }
    
    public Field(int x, int y, Piece piece) {
        this(x, y);
        this.piece = piece;
    }
    
    
    public Field(String f) {
        this.boardIndex = f;
        int indexY;
        int indexX;
        if(f.charAt(0) == 'a'){
            indexY = 0;
            String temp = f.replaceAll("\\D+","");
            indexX = Integer.valueOf(temp) - 1;
            position = new Position(indexX, indexY);
        }
        else if(f.charAt(0) == 'b'){
            indexY = 1;
            String temp = f.replaceAll("\\D+","");
            indexX = Integer.valueOf(temp) - 1;
            position = new Position(indexX, indexY);
        }
        else if(f.charAt(0) == 'c'){
            indexY = 2;
            String temp = f.replaceAll("\\D+","");
            indexX = Integer.valueOf(temp) - 1;
            position = new Position(indexX, indexY);
        }
        else if(f.charAt(0) == 'd'){
            indexY = 3;
            String temp = f.replaceAll("\\D+","");
            indexX = Integer.valueOf(temp) - 1;
            position = new Position(indexX, indexY);
        }
        else if(f.charAt(0) == 'e'){
            indexY = 4;
            String temp = f.replaceAll("\\D+","");
            indexX = Integer.valueOf(temp) - 1;
            position = new Position(indexX, indexY);
        }
        else if(f.charAt(0) == 'f'){
            indexY = 5;
            String temp = f.replaceAll("\\D+","");
            indexX = Integer.valueOf(temp) - 1;
            position = new Position(indexX, indexY);
        }
        else if(f.charAt(0) == 'g'){
            indexY = 6;
            String temp = f.replaceAll("\\D+","");
            indexX = Integer.valueOf(temp) - 1;
            position = new Position(indexX, indexY);
        }
        else if(f.charAt(0) == 'h'){
            indexY = 7;
            String temp = f.replaceAll("\\D+","");
            indexX = Integer.valueOf(temp) - 1;
            position = new Position(indexX, indexY);
        }
    }
    
    public Field(int x, int y){
        String indexY;
        String indexX;
        if(y == 0){
            indexY = "a";
            indexX = String.valueOf(x);
            boardIndex = indexY+indexX;
            position = new Position(x, y);
        }
        else if(y == 1){
            indexY = "b";
            indexX = String.valueOf(x);
            boardIndex = indexY+indexX;
            position = new Position(x, y);
        }
        else if(y == 2){
            indexY = "c";
            indexX = String.valueOf(x);
            boardIndex = indexY+indexX;
            position = new Position(x, y);
        }
        else if(y == 3){
            indexY = "d";
            indexX = String.valueOf(x);
            boardIndex = indexY+indexX;
            position = new Position(x, y);
        }
        else if(y == 4){
            indexY = "e";
            indexX = String.valueOf(x);
            boardIndex = indexY+indexX;
            position = new Position(x, y);
        }
        else if(y == 5){
            indexY = "f";
            indexX = String.valueOf(x);
            boardIndex = indexY+indexX;
            position = new Position(x, y);
        }
        else if(y == 6){
            indexY = "g";
            indexX = String.valueOf(x);
            boardIndex = indexY+indexX;
            position = new Position(x, y);
        }
        else if(y == 7){
            indexY = "h";
            indexX = String.valueOf(x);
            boardIndex = indexY+indexX;
            position = new Position(x, y);
        }

        
    }
    
    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public String getBoardIndex() {
        return boardIndex;
    }

    public void setBoardIndex(String boardIndex) {
        this.boardIndex = boardIndex;
    }
    
    public class Position {        
        private int x;
        private int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
        
    }
}
