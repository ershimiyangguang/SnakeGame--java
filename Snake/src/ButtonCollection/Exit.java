package ButtonCollection;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Exit extends Button implements ActionListener {
    public Exit() {
        super.setText("退出(esc)");
        super.setWidth(6);
        super.setHeight(2);
        super.setY(-3);
        this.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
}
