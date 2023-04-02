package ButtonCollection;

import java.awt.event.*;

public class Replay extends Button implements ActionListener {
    public Replay() {
        super.setText("重新开始(空格)");
        super.setWidth(6);
        super.setHeight(2);
        super.setY(1);
        super.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        getFrame().toGame();
    }
}
