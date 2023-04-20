package Main;

import javax.swing.*;
import java.awt.*;

public class AttribFrame extends JFrame {
    JFrame attribFrame=new JFrame();
    Box box0=Box.createVerticalBox();
    Box box1=Box.createHorizontalBox();
    Box box2=Box.createHorizontalBox();
    Box box3=Box.createHorizontalBox();
    Box box4=Box.createHorizontalBox();
    Box box5=Box.createHorizontalBox();
    Label snakeSet=new Label("蛇初始长度");
    Label enemySet=new Label("敌人初始数量");
    Label speedSet=new Label("游戏运行速度");
    Label attackSet=new Label("敌人攻击欲望");
    Label isNewEnemy=new Label("是否会生成敌人");
    TextField snakeText=new TextField();
    TextField enemyText=new TextField();
    CheckboxGroup speedChoose=new CheckboxGroup();
    Checkbox slow=new Checkbox("slow",speedChoose,true);
    Checkbox middle=new Checkbox("middle",speedChoose,false);
    Checkbox fast=new Checkbox("fast",speedChoose,false);
    CheckboxGroup attackChoose=new CheckboxGroup();
    Checkbox weak=new Checkbox("weak",attackChoose,true);
    Checkbox middle2=new Checkbox("middle",attackChoose,false);
    Checkbox strong=new Checkbox("strong",attackChoose,false);
    CheckboxGroup isNew=new CheckboxGroup();
    Checkbox yes=new Checkbox("yes",isNew,false);
    Checkbox no=new Checkbox("no",isNew,true);



    public void init(){

        box1.add(snakeSet);
        box1.add(snakeText);
        box2.add(enemySet);
        box2.add(enemyText);
        box3.add(speedSet);
        box3.add(slow);
        box3.add(middle);
        box3.add(fast);
        box4.add(attackSet);
        box4.add(weak);
        box4.add(middle2);
        box4.add(strong);
        box5.add(isNewEnemy);
        box5.add(yes);
        box5.add(no);
        box0.add(box1);
        box0.add(box2);
        box0.add(box3);
        box0.add(box4);
        box0.add(box5);
        attribFrame.add(box0);
        attribFrame.pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        attribFrame.setSize(941, 664);
        attribFrame.setVisible(true);
    }
}
