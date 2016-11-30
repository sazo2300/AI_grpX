/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    
}
