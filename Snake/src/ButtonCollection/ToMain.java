package ButtonCollection;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToMain extends Button implements ActionListener {
    public ToMain() {
        super.setText("返回主界面(M)");
        super.setWidth(6);
        super.setHeight(2);
        super.setY(-1);
        this.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        getFrame().toMain();
    }
}
