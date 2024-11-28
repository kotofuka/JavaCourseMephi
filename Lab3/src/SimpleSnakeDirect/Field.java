package SimpleSnakeDirect;

import java.awt.*;

public class Field {
    final Color FIELD_COLOR_SPACE_1 = Config.FIELD_COLOR_SPACE_1;
    final Color FIELD_COLOR_SPACE_2 = Config.FIELD_COLOR_SPACE_2;
    final Color FIELD_BORDER_COLOR = Config.FIELD_BORDER_COLOR;

    final int CELL_WIDTH = Config.CELL_WIDTH;
    final int CELL_HEIGHT = Config.CELL_HEIGHT;

    final int COUNT_CELL = Config.COUNT_CELL;

    Cell[][] field = new Cell[COUNT_CELL][COUNT_CELL];


    public Field() {
        for (int i = 0; i < COUNT_CELL; i++){
            for (int j = 0; j < COUNT_CELL; j++){
                Color tempColor = i == 0 || i == COUNT_CELL - 1 || j == 0 || j == COUNT_CELL - 1 ? FIELD_BORDER_COLOR :
                        (i + j) % 2 == 0 ? FIELD_COLOR_SPACE_1: FIELD_COLOR_SPACE_2;
                field[i][j] = new Cell(i, j, tempColor);
            }
        }
    }

    void paint(Graphics g){
        for (int i = 0; i < COUNT_CELL; i++){
            for (int j = 0; j < COUNT_CELL; j++){
                g.setColor(field[i][j].getTempColor());
                g.fillRect(j * CELL_WIDTH, i * CELL_HEIGHT, CELL_WIDTH, CELL_HEIGHT);
            }
        }
    }
}
