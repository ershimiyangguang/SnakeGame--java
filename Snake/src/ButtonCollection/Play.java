package ButtonCollection;


import java.awt.event.*;


public class Play extends Button implements ActionListener {
    public Play() {
        super.setText("开始游戏(空格)");
        super.setWidth(6);
        super.setHeight(2);
        super.setY(1);
        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        getFrame().toGame();
    }
}
