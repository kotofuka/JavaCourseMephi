package SnakeDirect;

import java.awt.*;

public record Config() {
    static final String TITLE_OF_WINDOW = "The game Snake";

    static final int START_LOCATION = 200;
    static final int SHOW_DELAY = 150;

    static final int CANVAS_DX = 5;
    static final int CANVAS_DY = 5;
    static final int POINT_RADIUS = 8;
    static final int CELL_WIDTH = 36;
    static final int CELL_HEIGHT = 36;
    static final int COUNT_CELL = 20;

    static final int OPTION_FIELD_WIDTH = 2 * CANVAS_DX + CELL_WIDTH * COUNT_CELL; //in point
    static final int OPTION_FIELD_HEIGHT = 36; // in point

    static final int WINDOW_WIDTH = OPTION_FIELD_WIDTH;
    static final int WINDOW_HEIGHT = OPTION_FIELD_HEIGHT + 3 * CANVAS_DY + CELL_HEIGHT * COUNT_CELL;

    static final int UP = 38;
    static final int RIGHT = 39;
    static final int DOWN = 40;
    static final int LEFT = 37;

    static final int START_DIRECTION = UP;

    static final Color DEFAULT_COLOR = Color.LIGHT_GRAY;
    static final Color FOOD_COLOR = Color.red;
}
