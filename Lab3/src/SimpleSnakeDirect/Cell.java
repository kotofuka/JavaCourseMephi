package SimpleSnakeDirect;

import java.awt.*;

public class Cell {
    private final Color DEFAULT_COLOR;
    private Color tempColor;
    private final int WIDTH = Config.CELL_WIDTH;
    private final int HEIGHT = Config.CELL_WIDTH;
    private int raw, column;

    public Cell(int x, int y, Color DEFAULT_COLOR) {
        this.setPosition(x, y);
        this.DEFAULT_COLOR = DEFAULT_COLOR;
        this.tempColor = DEFAULT_COLOR;
    }

    public void resetColor(){
        this.tempColor = this.DEFAULT_COLOR;
    }

    public void setTempColor(Color color){
        this.tempColor = color;
    }

    public void setPosition(int x, int y){
        this.column = x;
        this.raw = y;
    }

    public int getRaw(){
        return raw;
    }

    public int getColumn(){
        return column;
    }

    public Color getTempColor(){
        return tempColor;
    }

    public void paint(Graphics g){
        g.setColor(tempColor);
        g.fillRect(column * WIDTH, raw * HEIGHT, WIDTH, HEIGHT);
    }
}
