package Object;

import Main.GameFrame;

import java.awt.*;
import java.util.Random;
import java.awt.Rectangle;

public class Enemy {
    private Location location=new Location();//位置
    public enum Enemystate{attack,escape}   //敌人的状态
    public Enemystate enemystate;
    boolean  attack_direction; //攻击的方向
    int escape_direction;  //逃跑的方向
    private int damage;//伤害
    //函数

    public Enemy() {
        init();
    }
    //重置敌人位置与伤害
    private void init() {
        Random r =new Random();
        location.setX(r.nextInt(31));
        location.setY(r.nextInt(21));   //随机生成敌人的位置
        this.damage=2;
        this.enemystate=Enemystate.attack;


    }
    //攻击蛇
    public void attack(Snake snake, GameFrame frame,int x,int y,int l) {
        if(enemystate==Enemystate.attack) {    //当敌人状态为攻击时，判断敌人是否攻击到蛇
            Rectangle r = new Rectangle(location.getX() * l + x, location.getY() * l + y, 30, 30);
            Location location1[] = new Location[1000];
            location1 = snake.getSnake_body();
            for (int i = 0; i < snake.getLength(); i++) {
                if (r.contains(location1[i].getX() * l + x, location1[i].getY() * l + y, l, l)) {
                    snake.setLength(snake.getLength() - 1);//如果攻击到蛇，则蛇的长度-1，并且敌人的状态改为逃跑
                    enemystate =Enemystate. escape;
                    break;

                }
            }

        }

    }
    //移动
    public void move(Snake snake) {  //敌人移动
        Location location1[] = new Location[1000];
        Location head = new Location();
        location1 = snake.getSnake_body();
        attack_direction = new Random().nextBoolean();
        if (enemystate ==Enemystate. attack) {//如果敌人状态为攻击，则敌人根据蛇的位置自动改变自己的位置
            if (location1[0].getX() > location.getX() && location1[0].getY() > location.getY()) {
                if (attack_direction)
                {
                    location.setX(location.getX() + 1);
                    escape_direction=1;
                }
                else
                {
                    location.setY(location.getY() + 1);
                    escape_direction=2;
                }
            } else if (location1[0].getX() < location.getX() && location1[0].getY() > location.getY()) {
                if (attack_direction)
                {
                    location.setX(location.getX() - 1);
                    escape_direction=-1;
                }
                else
                {
                    location.setY(location.getY() + 1);
                    escape_direction=2;
                }
            } else if (location1[0].getX() < location.getX() && location1[0].getY() < location.getY()) {
                if (attack_direction)
                {
                    location.setX(location.getX() - 1);
                    escape_direction=-1;
                }
                else
                { location.setY(location.getY() - 1);
                escape_direction=-2;
                }
            } else {
                if (attack_direction)
                {
                    location.setX(location.getX() + 1);
                    escape_direction=1;
                }
                else
                {
                    location.setY(location.getY() - 1);
                    escape_direction=-2;
                }
            }

        }
        else{    //如果敌人状态逃跑
            if(escape_direction==1)
            {
                location.setX(location.getX()-1);

            }
            else if(escape_direction==-1){
                location.setX(location.getX()+1);
            }
            else if(escape_direction==2)
            {
                location.setY(location.getY()-1);
            }
            else{
                location.setY(location.getY()+1);

            }
        }
    }

    public void paint(Graphics gImage, int l, int x, int y) {
        if(location.getX()>=0&&location.getY()>=0)
        gImage.setColor(Color.BLACK);
        gImage.fillRect((location.getX()*l)+x,(location.getY()*l+y),l,l);

    }
}
