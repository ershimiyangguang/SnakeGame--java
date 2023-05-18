package Object;

import Main.GameFrame;

import java.awt.*;
import java.util.Random;
import java.awt.Rectangle;

public class Enemy {
    private Location location=new Location();//位置
    public enum Enemystate{attack,escape,wait}   //敌人的状态
    public Enemystate enemystate;
    boolean  attack_direction; //攻击的方向
    int escape_direction;  //逃跑的方向
    Location attack_range []= new Location[5];

    private int damage;
    //伤害
    //函数

    public Enemy() {
        init();
    }
    //重置敌人位置与伤害
    public void init() {
        Random r =new Random();
        location.setX(r.nextInt(31));
        location.setY(r.nextInt(21));   //随机生成敌人的位置
        this.damage=2;
        this.enemystate=Enemystate.attack;


    }
    //攻击蛇
    public void attack(Snake snake, GameFrame frame) {
        if(enemystate==Enemystate.attack) {    //当敌人状态为攻击时，判断敌人是否攻击到蛇//
            for (int i = 0; i < snake.getLength(); i++) {
                if (detection(location,snake)) {
                    snake.setLength(snake.getLength() - 1);//如果攻击到蛇，则蛇的长度-1，并且敌人的状态改为逃跑
                    enemystate =Enemystate. escape;
                    break;

                }
            }

        }
        else if(enemystate==Enemystate.escape){

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
        else if(enemystate==Enemystate.escape){    //如果敌人状态逃跑
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
        else{
            Location location2[] = new Location[100];
            location2 = snake.getSnake_body();
            Rectangle r = new Rectangle((location.getX()-4)*30,(location.getY()-4),30,30);
            if(r.contains(location2[0].getX(),location2[0].getY())){
                enemystate=Enemystate.attack;
            }
        }

    }
    public boolean detection (Location enemy,Snake snake) {
        Location location2[]= new Location[1000];
        location2=snake.getSnake_body();
        if (enemystate == Enemystate.attack) {
            for(int i=0;i<5;i++){
                attack_range[i]=new Location();
            }
            for (int i = 0; i < 5; i++) {
                attack_range[i].setX(enemy.getX() );
                attack_range[i].setY(enemy.getY() );

            }
            attack_range[1].setY(enemy.getY()-1);
            attack_range[2].setY(enemy.getY()+1);
            attack_range[3].setX(enemy.getX()-1);
            attack_range[4].setX(enemy.getX()+1);
            for (int i = 1; i < 5; i++) {
                for (int j = 0; j < snake.getLength(); j++)
                    if (attack_range[i].equals(location2[j])) {
                        return true;
                    }
            }


        }
        else if(enemystate==Enemystate.escape){
            for(int i=0;i<snake.getLength();i++){
                if(location2[i].equals(enemy))
                    return true;
            }

        }
        return false;

    }

    public void paint(Graphics gImage, int x, int y, int l, Snake snake) {
        if (location.getX() >= 0 && location.getX() <= 31 && location.getY() >= 0 && location.getY() <= 21) {
            gImage.setColor(Color.BLACK);
            gImage.fillRect((location.getX() * l) + x, (location.getY() * l + y), l, l);
        }

        if (enemystate == Enemystate.attack) {
            for (int i = 1; i <=4; i++) {
                gImage.setColor(Color.yellow);
                gImage.fillRect((attack_range[i].getX()*l)+x,(attack_range[i].getY()*l)+y,l,l);
            }


        }

    }
}


