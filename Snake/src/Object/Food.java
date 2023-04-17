package Object;

import java.awt.*;
import java.util.Random;
import java.awt.Point;

public class Food {
    private int counts=0;
    private Point []foods=new Point[5];
    private Location location;
    private Location foodsPoint;

    public Food() {
        location = new Location();
        this.init();
    }

    //在frame上画出food
    public void paint(Graphics g, int l, int x, int y) {
        g.setColor(Color.BLUE);
        if(counts==5)
        {
            for(int i=0;i<foods.length;i++) {
                g.fillRect(foods[i].x * l + x, foods[i].y * l + y, l, l);
            }
        }
        else {
            g.fillRect(location.getX() * l + x, location.getY() * l + y, l, l);
        }
    }
    //食物被吃后转换位置
    public void NextLocation(Snake snake) {
        counts++;
        if(counts==5)
        {
            Random r=new Random();
            foods[0]=new Point(r.nextInt(31),r.nextInt(21));
            foods[1]=new Point(foods[0].x+1,foods[0].y);
            foods[2]=new Point(foods[1].x+1,foods[1].y);
            foods[3]=new Point(foods[2].x+1,foods[2].y);
            foods[4]=new Point(foods[3].x+1,foods[3].y);
        }
        else {
            while (true) {
                Random r = new Random();
                Location[] body = snake.getSnake_body();
                location.setX(r.nextInt(31));
                location.setY(r.nextInt(21));
                boolean b = true;
                for (int i = 0; i < snake.getLength(); i++) {
                    if (body[i].equals(location)) {
                        b = false;
                    }
                }
                if (b) break;
            }
        }
    }
    //重置食物位置
    public void init() {
        location.setX(22);
        location.setY(10);
    }
    //检测蛇是否吃到食物
    public boolean checkEat(Snake snake) {
        if(counts==5)
        {
            Location[] body = snake.getSnake_body();
            boolean[] Eat=new boolean[foods.length];
            for(int i=0;i<Eat.length;i++)
            {
                Eat[i]=false;
            }
            for(int i=0;i<foods.length;i++)
            {
                foodsPoint=new Location();
                foodsPoint.setX(foods[i].x);
                foodsPoint.setY(foods[i].y);
                for(int j=0;j<snake.getLength();j++)
                {
                    if(body[j].equals(foodsPoint))
                    {
                        Eat[i]=true;
                        break;
                    }
                }
            }

            for(int i=0;i<Eat.length;i++)
            {
                if(Eat[i]==false)
                    return false;
            }
            counts=0;
            return true;
        }
        else {
            if (location.equals(snake.getSnake_body()[0])) {
                return true;
            } else {
                return false;
            }
        }
    }
}
