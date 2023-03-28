package Button;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Option extends Button implements ActionListener {
    public Option() {
        super.setText("设置(O)");
        super.setWidth(6);
        super.setHeight(2);
        super.setY(-1);
        this.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
