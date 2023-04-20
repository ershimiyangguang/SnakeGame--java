package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LookFrame extends JFrame{
    //为什么要在LookFrame类里再创建一个LookFrame对象
    //要在窗体里添加控件使用getContentpane就可以了
    JFrame lookFrame=new JFrame();
    Box box0=Box.createVerticalBox();
    Box box1=Box.createHorizontalBox();
    Box box2=Box.createHorizontalBox();
    Box box3=Box.createHorizontalBox();
    Box box4=Box.createHorizontalBox();
    JButton snakeBtn=new JButton("蛇的颜色");
    JButton foodBtn=new JButton("食物颜色");
    JButton enemyBtn=new JButton("敌人颜色");
    JButton overlapBtn=new JButton("重叠颜色");
    JButton borderBtn=new JButton("边界颜色");
    JButton gridBtn=new JButton("网格颜色");
    Label tipLabel=new Label("是否有网格");
    CheckboxGroup isgrid=new CheckboxGroup();
    Checkbox yes=new Checkbox("是",isgrid,true);
    Checkbox no=new Checkbox("否",isgrid,false);
    Color snakeColor;
    Color foodColor;
    Color enemyColor;
    Color overlapColor;
    Color borderColor;
    Color gridColor;
    //存储在颜色选择器中选择的颜色
    Color color;
    public static Color showColorChoose(){
        JFrame frame=new JFrame("颜色选择");
        Color selectedColor=JColorChooser.showDialog(frame,"选择颜色",Color.white);
        frame.dispose();
        return selectedColor;
    }
    public void init(){


        ActionListener listener=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                color=showColorChoose();
            }
        };
        snakeBtn.addActionListener(listener);
        foodBtn.addActionListener(listener);
        enemyBtn.addActionListener(listener);
        overlapBtn.addActionListener(listener);
        borderBtn.addActionListener(listener);
        gridBtn.addActionListener(listener);
        box1.add(snakeBtn);
        box1.add(foodBtn);
        box2.add(enemyBtn);
        box2.add(overlapBtn);
        box3.add(tipLabel);
        box3.add(yes);
        box3.add(no);
        box4.add(borderBtn);
        box4.add(gridBtn);
        box0.add(box1);
        box0.add(box2);
        box0.add(box3);
        box0.add(box4);
        lookFrame.add(box0);
        lookFrame.pack();
        lookFrame.setSize(941, 664);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        lookFrame.setVisible(true);
    }
}
