package SimpleSnakeDirect;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class SimpleSnakeGame {
    JFrame frame;
    Canvas canvas;
    int score = 0;
    JButton resetButton = new JButton("Reset");
    JLabel scoreLabel = new JLabel("Score: " + score);
    boolean isGameOver = false;

    Field field = new Field();
    Snake snake = new Snake();
    Food food = new Food(-1, -1, Config.FOOD_COLOR);

    Random random = new Random();

    public void start(){
        frame = new JFrame(Config.TITLE_OF_WINDOW);
        frame.setSize(Config.WINDOW_WIDTH, Config.WINDOW_HEIGHT);
        frame.setMinimumSize(new Dimension(Config.WINDOW_WIDTH, Config.WINDOW_HEIGHT));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(Config.START_LOCATION, Config.START_LOCATION);
        frame.setResizable(false);

        var mainContainer = frame.getContentPane();

        var actionPanel = new JPanel();
        actionPanel.setBorder(BorderFactory.createLineBorder(Config.ACTION_PANEL_BORDER_COLOR, Config.ACTION_PANEL_BORDER_THICKNESS));

        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // need to fix
                score = 0;
                scoreLabel.setText("Score: " + score);

                isGameOver = false;
                snake.reset();



            }
        });

        actionPanel.add(resetButton, BorderLayout.NORTH);
        actionPanel.add(scoreLabel, BorderLayout.NORTH);

        actionPanel.setSize(Config.CELL_WIDTH, Config.CELL_HEIGHT);
        actionPanel.setBackground(Config.ACTION_PANEL_COLOR);

        mainContainer.add(actionPanel, BorderLayout.NORTH);

        canvas = new Canvas(field, snake, food);
        mainContainer.add(canvas, BorderLayout.CENTER);

        frame.setContentPane(mainContainer);

        frame.setVisible(true);
        frame.setFocusable(true);

        frame.addKeyListener(new KeyAdapter() {

            public void keyPressed(KeyEvent e) {
                snake.setDirection(e.getKeyCode());
            }

        });

        frame.pack();

        go();

    }

    private void go(){
        score = 0;
        snake.reset();
        isGameOver = false;
        respawnFood();
        while (!isGameOver){
            canvas.repaint();
            snake.move();
            System.out.println("cycle");
            if (food.isEaten(snake.getHead())) {
                levelUp();
            } else if (checkLose() || Math.abs(snake.prevDirection - snake.direction) == 2) {
                isGameOver = true;
                scoreLabel.setText("Game over");
            }

            try {
                Thread.sleep(Config.SHOW_DEALAY);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }

    private void levelUp(){
        snake.addElement();
        respawnFood();
        incrementScore();
    }

    private boolean checkLose(){
        var bodySnake = snake.getSnake();
        var headSnake = snake.getHead();

        if (headSnake.getRaw() == 0 || headSnake.getRaw() == Config.COUNT_CELL - 1 ||
            headSnake.getColumn() == 0 || headSnake.getColumn() == Config.COUNT_CELL - 1){
            return true;
        }

        for (var element: bodySnake){
            if (element == headSnake) {
                continue;
            } else if (element.getRaw() == headSnake.getRaw() && element.getColumn() == headSnake.getColumn()){
                return true;
            }
        }
        return false;
    }

    void respawnFood(){
        int x = random.nextInt(1, Config.COUNT_CELL - 1), y = random.nextInt(1, Config.COUNT_CELL - 1);
        while(snake.isFoodInside(x, y)){
            x = random.nextInt(1, Config.COUNT_CELL - 1);
            y = random.nextInt(1, Config.COUNT_CELL - 1);
        }
        food.setPosition(x, y);
    }

    void incrementScore(){
        scoreLabel.setText("Score: " + String.valueOf(++score));
    }
}
