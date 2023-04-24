package Object;

import java.awt.*;

import Main.*;
//蛇类
public class Snake {
    public enum Direction {up, down, left, right}
    //蛇身体每一个位置的坐标
    private Location[] snake_body = new Location[1000];
    //头部位置
    private Location head;
    //尾部位置
    private Location tail;
    //长度
    private int length;
    //蛇头朝向
    private Direction direction;
    //构造函数
    public Snake() {
        //初始化蛇的各属性
        init();
    }
    //初始化函数
    public void init() {
        //长度改为2
        length = 2;
        //设置第一节关节坐标
        snake_body[0] = new Location(8, 10);
        //设置第二节关节坐标
        snake_body[1] = new Location(7, 10);
        //设置头部坐标
        head = snake_body[0];
        //设置尾部坐标
        tail = new Location(snake_body[length - 1]);
        //设置蛇头朝向
        direction = Direction.right;
    }

    public void paint(Graphics g, int l, int a, int b) {
        int x, y;
        //设置画笔颜色为红色
        g.setColor(Color.RED);
        //依据每节关节的坐标画图
        for (int i = 0; i < length; i++) {
            x = snake_body[i].getX();
            y = snake_body[i].getY();
            //在（x，y）处画一个长为l，宽为l的长方形（a,b为偏移值分别在x，y后面加上就可以）
            //下面也是用同样的方法画图
            g.fillRect(x * l + a, y * l + b, l, l);
        }
       g.setColor(Color.white);
        x = snake_body[0].getX();
        y = snake_body[0].getY();
        g.fillRect(x * l + a + l / 4 + 1, y * l + b + l / 4 + 1, l / 2, l / 2);
        g.setColor(Color.black);
        x = snake_body[0].getX();
         y = snake_body[0].getY();
        g.fillRect(x * l + a + l / 3 + 1, y * l + b + l / 3 + 1, l / 4, l / 4);
    }
    //定向函数
    public void setDirection(int x) {
        //根据按键值x设置蛇的方向
        if (x == 65 && snake_body[0].getX() != snake_body[1].getX() + 1) {//a
            direction = Snake.Direction.left;
        } else if (x == 68 && snake_body[0].getX() != snake_body[1].getX() - 1) {//d
            direction = Snake.Direction.right;
        } else if (x == 83 && snake_body[0].getY() != snake_body[1].getY() - 1) {//s
            direction = Snake.Direction.down;
        } else if (x == 87 && snake_body[0].getY() != snake_body[1].getY() + 1) {//w
            direction = Snake.Direction.up;
        }
    }
    //移动函数
    public void move() {
        //从第二节到最后一节关节，每一节都把坐标改为上一节的坐标，使身体前进
        for (int i = length - 1; i > 0; i--) {
            snake_body[i].setX(snake_body[i - 1].getX());
            snake_body[i].setY(snake_body[i - 1].getY());
        }
        //根据方向移动蛇头
        switch (direction) {
            case up:
                snake_body[0].setY(snake_body[0].getY() - 1);
                break;
            case left:
                snake_body[0].setX(snake_body[0].getX() - 1);
                break;
            case down:
                snake_body[0].setY(snake_body[0].getY() + 1);
                break;
            case right:
                snake_body[0].setX(snake_body[0].getX() + 1);
        }
    }
    //判断是否撞到墙壁或自己的函数
    public void checkAlive(GameFrame frame) {
        boolean b = true;
        //head在墙外认定为撞墙
        if (head.getX() < 0 || head.getX() > 30 ||
                head.getY() < 0 || head.getY() > 20) {
            b = false;
        }
        //head与身体重合认定为撞到自己
        for (int i = 1; i < length; i++) {
            if (snake_body[i].equals(head)) {
                b = false;
            }
        }
        //撞到就直接死亡
        if (!b) {
            frame.toEnd();
        }
    }
    //增长函数
    public void grow() {
        //在尾部增长一节新关节
        snake_body[length] = new Location(tail.getX(), tail.getY());
        //长度+1
        length = length + 1;
    }
    //设置尾部坐标
    public void setTail() {
        tail.setX(snake_body[length - 1].getX());
        tail.setY(snake_body[length - 1].getY());
    }
    public void setLength(int length){
        this.length=length;
    }
    //获得蛇关节的坐标数组
    public Location[] getSnake_body() {
        return snake_body;
    }
    //获得蛇的长度
    public int getLength() {
        return length;
    }


}
