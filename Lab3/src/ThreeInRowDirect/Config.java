package ThreeInRowDirect;

import java.awt.*;

public record Config() {
    static final int COUNT_CELLS = 8;
    static final int SCORE_VALUE_FOR_CELL = 1;

    static final int INITIAL_POSITION_X = 350;
    static final int INITIAL_POSITION_Y = 200;

    static final int BUTTON_BORDER_THICKNESS = 5;
    static final Color BUTTON_BORDER_COLOR = Color.gray;
    static final int BUTTON_SIZE = 60;

    static final int CELL_BOUNDARY = 5;
    static final Color FIELD_BACKGROUND_COLOR = Color.darkGray;

    static Color[] LIST_CELL_COLOURS = new Color[] {Color.getHSBColor(1, 0.71f, 0.80f),
                                                    Color.getHSBColor(0.1455f, 0.71f, 0.8f),
                                                    Color.getHSBColor(0.281f, 0.71f, 0.8f),
                                                    Color.getHSBColor(0.281f, 0.71f, 0.52f),
                                                    Color.getHSBColor(0.453f, 0.71f, 0.96f),
                                                    Color.getHSBColor(0.5916f, 0.71f, 0.96f),
                                                    Color.getHSBColor(0.683f, 0.90f, 0.79f),
                                                    Color.getHSBColor(0.833f, 0.9f, 0.79f)};

    static String[] STATUS_LISTS_OF_CELL = new String[] {"DEFAULT", "IS_CHOSEN", "IS_DELETED"};

    static final int CELL_SIZE = 60;
    static final Color CELL_BORDER_COLOR = Color.WHITE;

    static final int WINDOW_WIDTH = (CELL_SIZE + CELL_BOUNDARY) * COUNT_CELLS + 4 * CELL_BOUNDARY; // 525
    static final int WINDOW_HEIGHT = BUTTON_BORDER_THICKNESS * 2 + BUTTON_SIZE + (CELL_SIZE + CELL_BOUNDARY) * COUNT_CELLS + 4 * CELL_BOUNDARY; // 585

}
