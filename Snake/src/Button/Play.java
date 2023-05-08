package Button;


import javax.swing.*;
import java.awt.event.*;


public class Play extends Button implements ActionListener {
    public Play() {
        super.setText("开始游戏(空格)");
        super.setWidth(6);
        super.setHeight(2);
        super.setY(1);
        super.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        getFrame().toGame();
    }

    private ImageIcon icon;
    public void reSize(int x, int y, int l) {
        super.reSize(x,y,l);
        icon = IconTool.createAutoAdjustIcon("Snake/Picture/start.png",false);
        super.setIcon(icon);
    }
}
