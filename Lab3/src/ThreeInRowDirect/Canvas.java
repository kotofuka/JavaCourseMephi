package ThreeInRowDirect;

import javax.swing.*;
import java.awt.*;

public class Canvas extends JPanel {
    Field field;

    public Canvas(Field field) {
        this.field = field;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        field.paint(g);
    }
}
