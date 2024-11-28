package SimpleSnakeDirect;

import java.awt.*;

public class Food extends Cell{
    public Food(int x, int y, Color DEFAULT_COLOR) {
        super(x, y, DEFAULT_COLOR);
    }

    public boolean isEaten(SnakeElement head){
        return head.getRaw() == this.getRaw() && head.getColumn() == this.getColumn();
    }
}
