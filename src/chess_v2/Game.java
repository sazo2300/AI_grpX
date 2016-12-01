package chess_v2;

/**
 *
 * @author atila29
 */
public class Game {
    public enum Color {WHITE, BLACK}
    private Player white, black;
    
    public Game() {
        
    }
    
    public static Game.Color oppositeColor(Game.Color color){
        if(color.equals(Game.Color.WHITE)){
            return Game.Color.BLACK;
        }
        else{
            return Game.Color.WHITE;
        }
        
    }
    
    
    
}
