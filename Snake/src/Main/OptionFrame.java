package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OptionFrame extends JFrame {
    JFrame setFrame=new JFrame();

    Button lookBtn=new Button("外观");
    Button runBtn=new Button("操作");
    Button attribBtn=new Button("属性");
    Panel p1=new Panel();

    public void init() {

        lookBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lookFrame lookFrame=new lookFrame();
                lookFrame.init();

            }
        });
        runBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                runFrame runFrame=new runFrame();
                runFrame.init();
            }
        });
        attribBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                attribFrame attribFrame=new attribFrame();
                attribFrame.init();
            }
        });
        p1.add(lookBtn);
        p1.add(runBtn);
        p1.add(attribBtn);
        setFrame.add(p1);



        super.setTitle("设置");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setSize(941, 664);
    }
}
