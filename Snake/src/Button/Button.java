package Button;

import Main.*;

import javax.swing.*;
import java.awt.*;

public class Button extends JButton {
    private GameFrame frame;
    private int width;
    private int height;
    private int y;

    public Button() {
        super.setVisible(false);
        super.setFocusPainted(false);
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setFrame(GameFrame frame) {
        this.frame = frame;
    }

    public GameFrame getFrame() {
        return frame;
    }

    public void reSize(int x, int y, int l) {
        super.setBounds(x + (31 - width) / 2 * l, y + (21 - height) / 2 * l - this.y * l, width * l, height * l);
        super.setFont(new Font("宋体",0,l*3/5));
    }
}
