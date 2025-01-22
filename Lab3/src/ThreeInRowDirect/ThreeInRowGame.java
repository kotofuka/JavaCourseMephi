package ThreeInRowDirect;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;

public class ThreeInRowGame {

    JFrame frame;
    Canvas canvas;

    int score;
    final int SCORE_FOR_CELL = Config.SCORE_VALUE_FOR_CELL;

    JLabel scoreLabel = new JLabel("Score: " +  score);
    JButton buttonReset = new JButton("Reset");

    Field field = new Field();

    final int WINDOW_WIDTH = Config.WINDOW_WIDTH;
    final int WINDOW_HEIGHT = Config.WINDOW_HEIGHT;

    Point prevCellIndex = null;

    public void start(){
        frame = new JFrame("Three-In-Row");
        frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        frame.setMinimumSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(Config.INITIAL_POSITION_X, Config.INITIAL_POSITION_Y);
        frame.setResizable(false);

        var frameContainer = frame.getContentPane();

        var actionPanel = new JPanel();
        actionPanel.setBorder(BorderFactory.createLineBorder(Config.BUTTON_BORDER_COLOR, Config.BUTTON_BORDER_THICKNESS));

        buttonReset.addActionListener(_ -> resetButtonAction());
        buttonReset.setEnabled(true);



        actionPanel.add(buttonReset, BorderLayout.NORTH);
        actionPanel.add(scoreLabel, BorderLayout.NORTH);

        frameContainer.add(actionPanel, BorderLayout.NORTH);

        canvas = new Canvas(field);

        canvas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                playerAction(e.getPoint());
            }
        });

        frameContainer.add(canvas, BorderLayout.CENTER);

        frame.setContentPane(frameContainer);

        frame.setVisible(true);
        frame.setFocusable(true);

        frame.pack();

        resetButtonAction();
    }


    void playerAction(Point location){
        Point tempCellIndex = field.defineCellIndex(location.x, location.y);
        System.out.println("tempCellIndex: " + tempCellIndex + " | " + field.cells[tempCellIndex.x][tempCellIndex.y].getColor());
        if (field.isNeighbors(prevCellIndex, tempCellIndex)){
            field.changeTwoCellsByIndex(tempCellIndex, prevCellIndex);
            field.changeCellStatus(prevCellIndex.x, prevCellIndex.y);
            prevCellIndex = null;

            System.out.println("| " + Arrays.toString(field.findSolution()));

            while (simplifyField());

        } else if (prevCellIndex == null && tempCellIndex != null) {
            prevCellIndex = tempCellIndex;
            field.changeCellStatus(prevCellIndex.x, prevCellIndex.y);
        }
        canvas.repaint();
    }

    boolean simplifyField(){
        int[] info = field.findSolution();

        if (info == null) return false;

        field.deleteSolution(info);

        score += SCORE_FOR_CELL * info[2];
        updateScoreLabel();

        field.shiftCells(info);

        field.resetCellsStatusByInfo(info);

//        System.out.println("Color: " + field.cells[info[0]][info[1]].getColor());

        return true;
    }

    void updateScoreLabel(){
        scoreLabel.setText("Score: " + score);
    }

    void resetButtonAction(){
        do {
            field.changeAllCells();
        } while (field.findSolution() != null);
        score = 0;
        if (prevCellIndex != null){
            field.resetCellStatus(prevCellIndex.x, prevCellIndex.y);
            prevCellIndex = null;
        }
        System.out.println(Arrays.toString(field.findSolution()));

        updateScoreLabel();

        canvas.repaint();
    }
}
