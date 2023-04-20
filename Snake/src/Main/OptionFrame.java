package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OptionFrame extends JFrame {
    //把setFrame删除了，好像没有什么用
    //使用JButton而不使用Button，更好用
    JButton lookBtn=new JButton("外观");
    JButton runBtn=new JButton("操作");
    JButton attribBtn=new JButton("属性");
    //删除Jpanel p1，使用另一种方式添加按钮


    public OptionFrame() {
        //删除init函数，把内容转移到构造函数里，因为构造函数的作用就是初始化
        lookBtn.addActionListener(new ActionListener() {
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
        });
        //使用setBounds函数对按钮的坐标，长宽进行设置
        lookBtn.setBounds(50,50,100,100);
        attribBtn.setBounds(50,250,100,100);
        runBtn.setBounds(50,450,100,100);
        //使用getContentPane的方式添加按钮
        getContentPane().add(lookBtn);
        getContentPane().add(runBtn);
        getContentPane().add(attribBtn);
        //设置界面布局为null，这样才能使用setBounds函数
        setLayout(null);
        super.setTitle("设置");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setSize(900, 600);
    }
}
