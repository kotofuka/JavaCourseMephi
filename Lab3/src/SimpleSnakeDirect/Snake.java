package SimpleSnakeDirect;

import java.awt.*;
import java.util.LinkedList;

public class Snake {
    final Color HEAD_COLOR = Config.SNAKE_HEAD_COLOR;
    final Color BODY_COLOR = Config.SNAKE_BODY_COLOR;

    final int COUNT_CELL = Config.COUNT_CELL;

    final int LEFT = Config.LEFT;
    final int UP = Config.UP;
    final int RIGHT = Config.RIGHT;
    final int DOWN = Config.DOWN;

    int direction = UP;
    int prevDirection = UP;

    int prevX = 11;
    int prevY = 11;

    LinkedList<SnakeElement> snake = new LinkedList<>();


    public Snake() {
        this.snake.addFirst(new SnakeElement(prevX, prevY, HEAD_COLOR));
    }

    public void move(){
        switch (direction){
            case LEFT:
                shiftSnake(getHead().getColumn() - 1, getHead().getRaw());
                break;

            case UP:
                shiftSnake(getHead().getColumn(), getHead().getRaw() - 1);
                break;

            case RIGHT:
                shiftSnake(getHead().getColumn() + 1, getHead().getRaw());
                break;

            case DOWN:
                shiftSnake(getHead().getColumn(), getHead().getRaw() + 1);
                break;

        }
    }

    public void setDirection(int direction){
        this.prevDirection = this.direction;
        this.direction = direction;
    }

    public boolean isFoodInside(int x, int y){
        for(var element: snake){
            if (element.getRaw() == y && element.getColumn() == x) return true;
        }
        return false;
    }

    public void shiftSnake(int x, int y){

        var prevElement = snake.getFirst();
        prevX = prevElement.getColumn();
        prevY = prevElement.getRaw();
        prevElement.setPosition(x, y);
        for(var element: snake){
            if (element == snake.getFirst()){
                continue;
            }
            int tempX = element.getColumn(), tempY = element.getRaw();
            element.setPosition(prevX, prevY);
            prevX = tempX;
            prevY = tempY;
        }
    }

    public void addElement(){
        this.snake.addLast(new SnakeElement(prevX, prevY, BODY_COLOR));
    }

    public void paint(Graphics g){
        for(var element: snake){
            g.setColor(element.getTempColor());
            element.paint(g);
        }
    }

    public SnakeElement getHead(){
        return snake.getFirst();
    }

    public LinkedList<SnakeElement> getSnake(){
        return snake;
    }

    public void reset(){
        removeSnakeBodyElements();
        prevX = COUNT_CELL / 2;
        prevY = COUNT_CELL / 2;
        this.snake.getFirst().setPosition(prevX, prevY);
        setDirection(UP);
        setDirection(UP);
        //System.out.println(this.getHead().getColumn() + " " + this.getHead().getRaw() + " " + this.getHead().getTempColor());
    }

    private void removeSnakeBodyElements(){
        while (this.snake.size() != 1){
            this.snake.removeLast();
        }
    }
}
