package chess_v2;

/**
 *
 * @author atila29
 */
public class Player {
    private Game.Color color;
    
    public Player(Game.Color color) {
        this.color = color;
    }

    public Game.Color getColor() {
        return color;
    }

    public void setColor(Game.Color color) {
        this.color = color;
    }
    
}
