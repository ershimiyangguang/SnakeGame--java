package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OptionFrame extends JFrame {
    //把setFrame删除了，好像没有什么用
    //为什么要在JFrame类里再创建一个JFrame对象
    //要在窗体里添加控件使用getContentpane就可以了

    //使用JButton而不使用Button，更好用

    JLabel lookLabel=new JLabel("外观");
    JButton snakeColorBtn=new JButton("蛇颜色");
    JButton enemyColorBtn=new JButton("敌人颜色");
    JButton overlapColorBtn=new JButton("食物与蛇重叠部分颜色");
    JButton gridColorBtn=new JButton("网格颜色");

    JLabel propertyLabel=new JLabel("属性");
    JLabel snakeLenLabel=new JLabel("蛇初始长度");
    JTextField snakeLenText=new JTextField();
    JLabel enemyNumLabel=new JLabel("敌人初始数量");
    JTextField enemyNumText=new JTextField();
    JLabel gameSpeedLabel=new JLabel("游戏运行速度");
    ButtonGroup speedChoose=new ButtonGroup();
    JRadioButton slow=new JRadioButton("慢",true);
    JRadioButton middle=new JRadioButton("中",false);
    JRadioButton fast=new JRadioButton("快",false);
    JLabel winTimeLabel=new JLabel("胜利所需的坚持时间");
    JTextField winTimeText=new JTextField();
    JLabel winFoodLabel=new JLabel("胜利所需搜集的食物数量");
    JTextField winFoodText=new JTextField();

    Color color;
    public static Color showColorChoose(){
        JFrame frame=new JFrame("Color Choose");
        Color selectedColor=JColorChooser.showDialog(frame,"Color Choose",Color.white);
        frame.dispose();
        return selectedColor;
    }

    public OptionFrame() {
        ActionListener listener=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                color=showColorChoose();
            }
        };
        setLayout(null);
        lookLabel.setBounds(20,20,60,30);
        getContentPane().add(lookLabel);
        snakeColorBtn.addActionListener(listener);
        snakeColorBtn.setBounds(100,50,100,60);
        getContentPane().add(snakeColorBtn);
        enemyColorBtn.addActionListener(listener);
        enemyColorBtn.setBounds(250,50,100,60);
        getContentPane().add(enemyColorBtn);
        overlapColorBtn.addActionListener(listener);
        overlapColorBtn.setBounds(80,120,180,60);
        getContentPane().add(overlapColorBtn);
        gridColorBtn.addActionListener(listener);
        gridColorBtn.setBounds(280,120,100,60);
        getContentPane().add(gridColorBtn);
        propertyLabel.setBounds(20,190,60,30);
        getContentPane().add(propertyLabel);
        snakeLenLabel.setBounds(100,220,100,70);
        getContentPane().add(snakeLenLabel);
        snakeLenText.setBounds(300,240,100,40);
        getContentPane().add(snakeLenText);
        enemyNumLabel.setBounds(100,290,100,70);
        getContentPane().add(enemyNumLabel);
        enemyNumText.setBounds(300,310,100,40);
        getContentPane().add(enemyNumText);
        gameSpeedLabel.setBounds(100,360,100,70);
        getContentPane().add(gameSpeedLabel);
        speedChoose.add(slow);
        speedChoose.add(middle);
        speedChoose.add(fast);
        slow.setBounds(220,380,40,40);
        middle.setBounds(300,380,40,40);
        fast.setBounds(380,380,40,40);
        getContentPane().add(slow);
        getContentPane().add(middle);
        getContentPane().add(fast);
        winTimeLabel.setBounds(100,430,150,70);
        getContentPane().add(winTimeLabel);
        winTimeText.setBounds(300,450,100,40);
        getContentPane().add(winTimeText);
        winFoodLabel.setBounds(100,500,150,70);
        getContentPane().add(winFoodLabel);
        winFoodText.setBounds(300,520,100,40);
        getContentPane().add(winFoodText);

        //删除init函数，把内容转移到构造函数里，因为构造函数的作用就是初始化
       /* lookBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LookFrame lookFrame=new LookFrame();
                lookFrame.init();
                //点击按钮之后隐藏原窗口
                OptionFrame.this.setVisible(false);
            }
        });
        runBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RunFrame runFrame=new RunFrame();
                runFrame.init();
                OptionFrame.this.setVisible(false);
            }
        });
        attribBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AttribFrame attribFrame=new AttribFrame();
                attribFrame.init();
                OptionFrame.this.setVisible(false);
            }
        });*/
        //使用setBounds函数对按钮的坐标，长宽进行设置
        /*lookBtn.setBounds(50,50,100,100);
        attribBtn.setBounds(50,250,100,100);
        runBtn.setBounds(50,450,100,100);
        //使用getContentPane的方式添加按钮
        getContentPane().add(lookBtn);
        getContentPane().add(runBtn);
        getContentPane().add(attribBtn);*/
        //设置界面布局为null，这样才能使用setBounds函数

        super.setTitle("设置");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setSize(500, 620);
    }
}
