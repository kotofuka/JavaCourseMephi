package SnakeDirect;

import java.awt.*;

public class Point {
    int x;
    int y;
    Color color = Config.DEFAULT_COLOR;

    public Point(int x, int y){
        this.setPosition(x, y);
    }

    void setPosition(int x, int y){
        this.x = x;
        this.y = y;
    }

    void paint(Graphics graphics){
        graphics.setColor(color);
        graphics.drawOval(x * Config.POINT_RADIUS, y * Config.POINT_RADIUS, Config.POINT_RADIUS, Config.POINT_RADIUS);
    }

    int getX(){
        return x;
    }

    int getY(){
        return y;
    }
}
