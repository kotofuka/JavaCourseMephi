package SnakeDirect;

import javax.swing.*;
import java.awt.*;

public class Canvas extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int i = 0; i < Config.COUNT_CELL; i++){
            g.setColor(i % 2 == 0 ? Color.GREEN: Color.ORANGE);
            for (int j = 0; j < Config.COUNT_CELL; j++){
                g.setColor(g.getColor() == Color.orange ? Color.GREEN: Color.ORANGE);
                g.fillRect(j * Config.CELL_WIDTH, i * Config.CELL_HEIGHT, Config.CELL_WIDTH, Config.CELL_HEIGHT);
            }
        }

        g.setColor(Config.FOOD_COLOR);
        g.fillOval(Config.CELL_HEIGHT, Config.CELL_WIDTH, Config.POINT_RADIUS, Config.POINT_RADIUS);
    }


}
