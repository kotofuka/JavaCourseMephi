package SimpleSnakeDirect;

import javax.swing.*;
import java.awt.*;

public class Canvas extends JPanel {
    Field field;
    Snake snake;
    Food food;

    public Canvas(Field field, Snake snake, Food food) {
        this.field = field;
        this.snake = snake;
        this.food = food;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        field.paint(g);
        snake.paint(g);
        food.paint(g);
    }
}
