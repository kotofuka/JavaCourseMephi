package SnakeDirect;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class GameSnake {
    JFrame frame;
    Canvas canvas;
    JButton resetButton = new JButton("Reset");
    JLabel scoreLabel = new JLabel("Score: " + (Config.WINDOW_WIDTH));

    public void start(){
        frame = new JFrame(Config.TITLE_OF_WINDOW);
        frame.setSize(Config.WINDOW_WIDTH, Config.WINDOW_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(Config.START_LOCATION, Config.START_LOCATION);
//        frame.setResizable(false);
        frame.setBackground(Config.DEFAULT_COLOR);

        var containerMain = frame.getContentPane();

        var panelOther = new JPanel();

//        panelOther.setBackground(Color.DARK_GRAY);
        panelOther.setSize(Config.OPTION_FIELD_WIDTH, Config.OPTION_FIELD_HEIGHT);
//        panelOther.setLayout(new GridLayout(1, 2, 0, 2));

        resetButton.addActionListener(new ButtonEventListener());
        panelOther.add(resetButton, BorderLayout.NORTH);
        panelOther.add(scoreLabel, BorderLayout.NORTH);

        panelOther.setBorder(BorderFactory.createLineBorder(Color.gray, Config.CANVAS_DY));

        containerMain.add(panelOther, BorderLayout.NORTH);

        canvas = new Canvas();
        containerMain.add(canvas, BorderLayout.CENTER);

        frame.setContentPane(containerMain);

        frame.setVisible(true);
    }

    static class ButtonEventListener implements ActionListener{
        public void actionPerformed(ActionEvent e){

        }
    }
}
