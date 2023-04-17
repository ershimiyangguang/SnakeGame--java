package Object;

import java.awt.*;
import java.util.Random;

public class Food {
    private Location location;

    public void setLocation(Location location) {
        this.location = location;
    }
    public Location getLocation() {
        return location;
    }

    public Food() {
        location = new Location();
        this.init();
    }

    //在frame上画出food
    public void paint(Graphics g, int l, int x, int y) {
        g.setColor(Color.BLUE);
        g.fillRect(location.getX() * l + x, location.getY() * l + y, l, l);
    }
    //食物被吃后转换位置
    public void NextLocation(Snake snake) {
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
    //重置食物位置
    public void init() {
        location.setX(22);
        location.setY(10);
    }
    //检测蛇是否吃到食物
    public boolean checkEat(Snake snake) {
        if (location.equals(snake.getSnake_body()[0])) {
            return true;
        } else {
            return false;
        }
    }
}
