
package chess_v2;

import java.util.List;


public class AI {
    
    private int max_depth = 10;
    private int dynamic_depth = 1;
    
    //Evaluerings funktion. Simpel evaluering af boardet KUN ved benyttelse af brikkers standard værdier
    //Det ville være optimalt at implementere mere dybdegående evalueringer som fx at tage højde
    //for brikkers placeringer, samt brikkers muligheder for at blive slået og slå andre brikker.
    public int evalState(Board state){
        int stateValue = 0;
        int whiteValue = 0;
        int blackValue = 0;
        for(int i = 0 ; i < 8 ; i++){
            for(int j = 0 ; j < 8 ; i++){
                if(state.getField(i, j).getPiece().getType() != Piece.Type.BLANK){
                    if(state.getField(i, j).getPiece().getColor().equals(Game.Color.WHITE)){
                        whiteValue += state.getField(i, j).getPiece().getValue();
                    } else{
                        blackValue += state.getField(i, j).getPiece().getValue();
                    }
                    
                }
            }
        }
        
        return stateValue = whiteValue - blackValue;
    }
    
    //Minimax algoritmen med alpha beta pruning.
    public int alphaBeta(Board state, Game.Color color, int alpha, int beta, int depth){
        List<Move> possibleMoves = state.getValidMoves(color);
        //Hvis ingen mulige træk, returnerer blot 0.
        if(possibleMoves.isEmpty()){
            return 0;
        }
        //Discontinued score, hvilket hvil sige at AIet vil tage højde for
        //om statet indeholder et win for en af playersne. Dette win er 50
        //point værd, men dybden hvorpå win conditionet er fundet
        //bliver trukket fra disse point for at sikre at AI foretrækker
        //et win på mindste dybde som muligt (Sikre også at AI
        //benytter sig af exhaustion, som gør at den foretrækker et loss
        //på højste dybde som muligt).
        if(state.checkWin() != null){
            if(state.checkWin().getColor().equals(Game.Color.WHITE)){
                return 50 - depth;
            }
            else{
                return -50 - depth;
            }
        }
        //Returnerer evalueringen af statet hvis max dybde er nået.
        if(depth == max_depth || depth == dynamic_depth){
            return evalState(state);
        }
        int v;
        //Selvle minimax med alpha beta pruning
        if(color== Game.Color.WHITE){
            v = Integer.MIN_VALUE;
            for(Move m : possibleMoves){
                v = Math.max(v, alphaBeta(state.simulateMove(color, m), Game.oppositeColor(color), alpha, beta, depth+1));
                alpha = Math.max(alpha, v);
                if(alpha >= beta){
                    break;
                }
            }
        } else {
            v = Integer.MAX_VALUE;
            for(Move m : possibleMoves){
                v = Math.max(v, alphaBeta(state.simulateMove(color, m), Game.oppositeColor(color), alpha, beta, depth+1));
                beta = Math.min(beta, v);
                if(beta <= alpha){
                    break;
                }
            }            
        }
        
        return v;
    }
    //returnerer det bedste træk ved benyttelse af minimax alpha beta pruning.
    public Move getBestMove(Board state, Game.Color color) throws Exception{
        List<Move> allMoves = state.getValidMoves(color);
        int bestScore = Integer.MIN_VALUE;
        Move bestMove = null;
        for(Move m : allMoves){
            int tempScore = alphaBeta(state.simulateMove(color, m), Game.oppositeColor(color), Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
            if(tempScore > bestScore){
                bestMove = m;
                bestScore = tempScore;
            }
        }
        //hvis bestmove == null så throw exception
        if(bestMove == null){
            throw new Exception("Woopsie");
        }
        return bestMove;
    }
    
    //Tager en deadline ind som er en tidsbegrænsning. Denne deadline benyttes til at
    //give algoritmen en tidsfrist hvorpå den SKAL være færdig. På den tid 
    //starter algoritmen med at søge i depth 1. Hvis den stadig har tid når den er færdig, 
    //søger den på dybde 1 og 2. Herefter 1, 2 og 3 osv. indtil den er nået sin deadline
    //eller den totale accepterede depth.
    public Move getBestMove(Board state, Game.Color color, long deadline) throws Exception{
        long start = System.currentTimeMillis();
        long end = start + deadline*1000;
        dynamic_depth = 1;
        Move bestMove = null;
        while(System.currentTimeMillis() < end){
            bestMove = getBestMove(state, color);
            if(dynamic_depth > max_depth){
                dynamic_depth++;
            }
            else{
                break;
            }
        }
        if(bestMove == null){
            throw new Exception("Hvor skal du hen du?");
        }
        return bestMove;
    }
    
}
