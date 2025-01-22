package ThreeInRowDirect;

import java.awt.*;
import java.util.Arrays;
import java.util.Random;

public class Field {

    Cell[][] cells;
    final int border = Config.CELL_BOUNDARY;
    final Color fieldColor = Config.FIELD_BACKGROUND_COLOR;
    Color[] cellColorList = Config.LIST_CELL_COLOURS;
    final int CELL_COLOR_LIST_LENGTH = cellColorList.length;
    final int COUNT_CELLS = Config.COUNT_CELLS;
    final int FIELD_WIDTH = Config.WINDOW_WIDTH;
    final int FIELD_HEIGHT = Config.WINDOW_HEIGHT;
    Random rd = new Random();

    final int cellSize = Config.CELL_SIZE;

    public Field() {
        cells = new Cell[COUNT_CELLS][COUNT_CELLS];
        for (int i = 0; i < COUNT_CELLS; i++){
            for (int j = 0; j < COUNT_CELLS; j++) {
                cells[i][j] = new Cell(randomizeCellColor(), i * (cellSize + border) + border, j * (cellSize + border) + border);
            }
        }
    }

    Color randomizeCellColor(){
        return cellColorList[rd.nextInt(CELL_COLOR_LIST_LENGTH)];
    }

    Point defineCellIndex(int x, int y){
        for (int i = 0; i < COUNT_CELLS; i++){
            for (int j = 0; j < COUNT_CELLS; j++){
                if (cells[i][j].isInsideCell(x, y)) {
                    return new Point(i, j);
                }
            }
        }
        return null;
    }

    int[] findSolution(){
        int count_cells;
        Color tempColor;

//        for(int i = 0; i < COUNT_CELLS - 2; i++){
//            for(int j = 0; j < COUNT_CELLS - 2; j++){
//                tempColor = cells[i][j].getColor();
//                count_cells = 1;
//                // defined on row
//                for(int k = j + 1; k < COUNT_CELLS; k++){
//                    if (cells[i][k].getColor() != tempColor) break;
//                    count_cells++;
//                }
//                if (count_cells > 2) return new int[] {i, j, count_cells, 1}; // last "1" == "DOWN" direction
//                // define on column
//                count_cells = 1;
//                for(int k = i + 1; k < COUNT_CELLS; k++){
//                    if (cells[k][j].getColor() != tempColor) break;
//                    count_cells++;
//                }
//                if (count_cells > 2) return new int[] {i, j, count_cells, 2}; // last "2" == "RIGHT" direction
//            }
//        }

        for(int i = 0; i < COUNT_CELLS; i++){
            for(int j = 0; j < COUNT_CELLS; j++){
                tempColor = cells[i][j].getColor();
                if(COUNT_CELLS - j > 0){
                    count_cells = 1;
                    // defined on row
                    for(int k = j + 1; k < COUNT_CELLS; k++){
                        if (cells[i][k].getColor() != tempColor) break;
                        count_cells++;
                    }
                    if (count_cells > 2) return new int[] {i, j, count_cells, 1}; // last "1" == "DOWN" direction
                }
                if (COUNT_CELLS - i > 0){
                    // define on column
                    count_cells = 1;
                    for(int k = i + 1; k < COUNT_CELLS; k++){
                        if (cells[k][j].getColor() != tempColor) break;
                        count_cells++;
                    }
                    if (count_cells > 2) return new int[] {i, j, count_cells, 2}; // last "2" == "RIGHT" direction
                }
            }
        }

        return null;
    }

    void deleteSolution(int[] info){

        if (info == null) return;

        int i = info[0], j = info[1], count = info[2], direction = info[3];

        for (;count > 0; count--){
            cells[i][j].setIsDeletedStatus();
            switch (direction){
                case 1: // "Down"
                    j++;
                    break;

                case 2: // "Right"
                    i++;
                    break;
            }
        }
    }

    void shiftCells(int[] info){

        //int i = info[0], j = info[1], count_cells = info[2], direction = info[3];
        System.out.println("Shift" + Arrays.toString(info) + " " + cells[info[0]][info[1]].getColor());

        switch (info[3]){
            case 1: // direction = "DOWN"
//                int prev = info[0] - 1, temp = prev + info[2];
//
//                while (prev >= 0){
//                    cells[temp][info[1]].setColor(cells[prev][info[1]].getColor());
//                    cells[temp][info[1]].resetCellStatus();
//                    prev--;
//                    temp--;
//                }
//
//                while (temp >= 0){
//                    cells[temp][info[1]].setColor(randomizeCellColor());
//                    cells[temp][info[1]].resetCellStatus();
//                    temp--;
//                }

                int prev = info[1] - 1, temp = prev + info[2];

                while (prev >= 0){
                    cells[info[0]][temp].setColor(cells[info[0]][prev].getColor());
                    prev--;
                    temp--;
                }

                while (temp >= 0){
                    cells[info[0]][temp].setColor(randomizeCellColor());
                    temp--;
                }

                break;

            case 2: // direction = "RIGHT"
//                for(int i = info[0]; i > 0; i--){
//                    for(int j = info[1]; j < info[1] + info[2]; j++){
//                        cells[i][j].setColor(cells[i - 1][j].getColor());
//                        cells[i][j].resetCellStatus();
//                    }
//                }
//
//                for(int j = info[1]; j < info[1] + info[2]; j++){
//                    cells[0][j].setColor(randomizeCellColor());
//                    cells[0][j].resetCellStatus();
//                }

                for (int j = info[1]; j > 0; j--){
                    for(int i = info[0]; i < info[0] + info[2]; i++){
                        cells[i][j].setColor(cells[i][j - 1].getColor());
                    }
                }

                for(int i = info[0]; i < info[0] + info[2]; i++){
                    cells[i][0].setColor(randomizeCellColor());
                }

                break;
        }
    }

    void resetCellsStatusByInfo(int[] info){
        if (info == null) return;

        int i = info[0], j = info[1], direction = info[3];

        for(int count_cells = info[2]; count_cells > 0; count_cells--){
            cells[i][j].resetCellStatus();
            switch (direction){
                case 1: // down
                    j++;
                    break;

                case 2: // right
                    i++;
                    break;
            }
        }
    }

    void changeTwoCellsByIndex(Point cell1Index, Point cell2Index){
        Color prevColor1 = cells[cell1Index.x][cell1Index.y].getColor();
        cells[cell1Index.x][cell1Index.y].setColor(cells[cell2Index.x][cell2Index.y].getColor());
        cells[cell2Index.x][cell2Index.y].setColor(prevColor1);
    }

    boolean isNeighbors(Point cell1Index, Point cell2Index){

        if (cell1Index == null || cell2Index == null) return false;

        return (Math.abs(cell1Index.x - cell2Index.x) == 1 && (cell1Index.y == cell2Index.y)) ||
                ((cell1Index.x == cell2Index.x) && Math.abs(cell1Index.y - cell2Index.y) == 1);
    }

    void changeAllCells(){
        for (int i = 0; i < COUNT_CELLS; i++){
            for(int j = 0; j < COUNT_CELLS; j++){
                cells[i][j].setColor(randomizeCellColor());
                cells[i][j].resetCellStatus();
            }
        }
    }

    void resetCellStatus(int i, int j){
        cells[i][j].resetCellStatus();
    }

    void changeCellStatus(int i, int j){
        cells[i][j].changeCellStatus();
    }

    void paint(Graphics g){
        g.setColor(fieldColor);
        g.fillRect(0, 0, FIELD_WIDTH, FIELD_HEIGHT);

        for(var cellList: cells) {
            for(var cell : cellList){
                cell.paint(g);
            }
        }
    }
}
