package SnakeDirect;

import java.util.ArrayList;

public class Snake {
    static ArrayList<Point> snake = new ArrayList<>();
    static int direction = Config.START_DIRECTION;


    static boolean IsInsideSnake(int x, int y){
        for (Point point: snake){
            if ((point.getX() == x) && (point.getY() == y)){
                return true;
            }
        }
        return false;
    }

    void setDirection(int direction){

    }
}
