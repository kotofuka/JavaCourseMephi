package SnakeDirect;

import java.awt.*;
import java.util.Random;

public class Food extends Point{

    Random random = new Random();

    public Food() {
        super(-1, -1);
        this.color = Config.FOOD_COLOR;
    }

    void eat(){
        this.setPosition(-1, -1);
    }

    boolean isEaten(){
        return this.getX() == -1;
    }

    void next(){
        do {
//            int x = random.nextInt(Config.FIELD_WIDTH);
//            int y = random.nextInt(Config.FIELD_HEIGHT);
        } while (!Snake.IsInsideSnake(x, y));
            this.setPosition(x, y);
    }
}
