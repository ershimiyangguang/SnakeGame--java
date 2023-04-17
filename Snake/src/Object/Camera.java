package Object;

import javax.swing.*;
import java.awt.*;

public class Camera extends JFrame {

    private Snake snake1;
    private Food food1;
    private Location food_location;
    private Location[] snake_body = new Location[1000];
    //头部位置
    private Location head;
    //尾部位置
    private Location tail;
    //长度
    private int length;
    //蛇头朝向
    private Snake.Direction direction;



    public Snake getSnake1() {
        return snake1;
    }

    public void setSnake1(Snake snake1) {
        this.snake1 = snake1;
    }

    public Location[] getSnake_body() {
        return snake_body;
    }

    public void setSnake_body(Location[] snake_body) {
        this.snake_body = snake_body;
    }

    public Location getHead() {
        return head;
    }

    public void setHead(Location head) {
        this.head = head;
    }

    public void setTail(Location tail) {
        this.tail = tail;
    }

    public void setHead() {
        this.head.setX(this.snake_body[0].getX());
        this.head.setY(this.snake_body[0].getY());
    }

    public Location getTail() {
        return tail;
    }

    //设置尾部坐标
    public void setTail() {
        if(length>0){
            this.tail.setX(this.snake_body[length - 1].getX());
            this.tail.setY(this.snake_body[length - 1].getY());
        }
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public Snake.Direction getDirection() {
        return direction;
    }

    public void setDirection(Snake.Direction direction) {
        this.direction = direction;
    }


    public Location getFood_location() {
        return food_location;
    }

    public void setFood_location(Location food_location) {
        this.food_location = food_location;
    }

    public void move(Snake snake, Food food) {
        this.snake1 = snake;
        this.food1=food;
        setFood_location(food.getLocation());
        setDirection(snake.getDirection());
        setSnake_body(snake.getSnake_body());
        setHead(snake.head);
        setTail(snake.tail);
        setLength(snake.length);
            //根据方向移动蛇头
            switch (snake1.direction) {
                case up:
                    changeY(+1);
                    food.setLocation(new Location(food.getLocation().getX(),food.getLocation().getY()+1));
                    break;
                case left:
                    changeX(+1);
                    food.setLocation(new Location(food.getLocation().getX()+1,food.getLocation().getY()));
                    break;
                case down:
                    changeY(-1);
                    food.setLocation(new Location(food.getLocation().getX(),food.getLocation().getY()-1));
                    break;
                case right:
                    changeX(-1);
                    food.setLocation(new Location(food.getLocation().getX()-1,food.getLocation().getY()));
            }
        setTail();
        setHead();
    }
    public void changeX(int a){
        for (int i = snake1.getLength() - 1; i >= 0; i--) {
            this.snake_body[i].setX(snake_body[i].getX()+a);
        }
    }
    public void changeY(int a){
        for (int i = snake1.getLength() - 1; i >= 0; i--) {
            this.snake_body[i].setY(snake_body[i].getY()+a);
        }
    }
    public void paint(Graphics g, int l, int a, int b) {
        int x, y;
        //设置画笔颜色为红色
        g.setColor(Color.RED);
        //依据每节关节的坐标画图
        for (int i = 0; i < snake1.length; i++) {
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
}
