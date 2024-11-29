package SimpleSnakeDirect;

import java.awt.*;
import java.util.LinkedList;

public record Config() {
    static final String TITLE_OF_WINDOW = "The game Snake";
    static final int SHOW_DEALAY = 200;

    static final int LEFT = 37;
    static final int UP = 38;
    static final int RIGHT = 39;
    static final int DOWN = 40;
    static final int RESET = 82;


    static final int START_LOCATION = 200;

    static final int COUNT_CELL = 22;
    static final int CELL_WIDTH = 20;
    static final int CELL_HEIGHT = 20;

    static final Color FIELD_COLOR_SPACE_1 = Color.getHSBColor(0.2226f, 0.6232f, 0.8431f);
    static final Color FIELD_COLOR_SPACE_2 = Color.getHSBColor(0.2242f, 0.6507f, 0.8196f);
    static final Color FIELD_BORDER_COLOR = Color.DARK_GRAY;

    static final Color SNAKE_HEAD_COLOR = Color.orange;
    static final Color SNAKE_BODY_COLOR = Color.WHITE;
    static final Color FOOD_COLOR = Color.RED;

    static final Color ACTION_PANEL_BORDER_COLOR = Color.gray;
    static final int ACTION_PANEL_BORDER_THICKNESS = 2;
    static final Color ACTION_PANEL_COLOR = Color.getHSBColor(0.5333f, 0.54245f, 0.83137f);

    static final int WINDOW_WIDTH = CELL_WIDTH * COUNT_CELL + 6 * ACTION_PANEL_BORDER_THICKNESS;
    static final int WINDOW_HEIGHT = CELL_HEIGHT * (COUNT_CELL + 3) + 3 * ACTION_PANEL_BORDER_THICKNESS;
}
