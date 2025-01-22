package ThreeInRowDirect;

import java.awt.*;
import java.util.Objects;

public class Cell {

    private Color  color;
    private final int CELL_SIZE = Config.CELL_SIZE;
    final private int x, y;

    private final int CELL_BOUNDARY = Config.CELL_BOUNDARY;

    private final Color CELL_BORDER_COLOR = Config.CELL_BORDER_COLOR;
    private final Color CELL_DELETED_COLOR = Config.FIELD_BACKGROUND_COLOR;

    private final String DEFAULT_STATUS_CELL = Config.STATUS_LISTS_OF_CELL[0]; // is default status of cells in config list
    private final String IS_CHOSEN_STATUS_CELL = Config.STATUS_LISTS_OF_CELL[1]; // symbolic "is chosen" status of cells in config list
    private final String IS_DELETED_STATUS_CELL = Config.STATUS_LISTS_OF_CELL[2]; // symbolic "is deleted" default status of cells in config list


    private String status = DEFAULT_STATUS_CELL; //

    public Cell(Color color, int x, int y) {
        this.color = color;
        this.x = x;
        this.y = y;
    }

    public Color getColor(){return color;}

    public void setColor(Color color) {
        this.color = color;
    }

    public void setIsDeletedStatus(){status = IS_DELETED_STATUS_CELL;}

    public void resetCellStatus(){
        status = DEFAULT_STATUS_CELL;
    }

    public void changeCellStatus(){
        status = Objects.equals(status, IS_CHOSEN_STATUS_CELL) ? DEFAULT_STATUS_CELL: IS_CHOSEN_STATUS_CELL;
    }


    public boolean isInsideCell(int x, int y){
        return (this.x <= x) && (x <= this.x + CELL_SIZE) && (this.y <= y) && (y <= this.y + CELL_SIZE);
    }


    public void paint(Graphics g){

        if (Objects.equals(status, IS_CHOSEN_STATUS_CELL)){
            g.setColor(CELL_BORDER_COLOR);
            g.fillRect(x - CELL_BOUNDARY, y - CELL_BOUNDARY, CELL_SIZE + 2 * CELL_BOUNDARY, CELL_SIZE + 2 * CELL_BOUNDARY);
        } else if (Objects.equals(status, IS_DELETED_STATUS_CELL)) {
            g.setColor(CELL_DELETED_COLOR);
            g.fillRect(x - CELL_BOUNDARY, y - CELL_BOUNDARY, CELL_SIZE + 2 * CELL_BOUNDARY, CELL_SIZE + 2 * CELL_BOUNDARY);
            return;
        }
        g.setColor(color);
        g.fillRect(x, y, CELL_SIZE, CELL_SIZE);
    }
}
