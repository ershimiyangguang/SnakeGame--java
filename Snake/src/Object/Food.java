package Object;

import java.awt.*;
import java.util.Random;

public class Food {
    private Location location;

    public Food() {
        location = new Location();
        this.init();
    }

    public Location getLocation() {
        return location;
    }

    public void paint(Graphics g, int l, int x, int y) {
        g.setColor(Color.GREEN);
        g.fillRect(location.getX() * l + x, location.getY() * l + y, l, l);
    }

    public void NextLocation(Snake snake) {
        while (true) {
            Random r = new Random();
            Location[] body = snake.getSnake_body();
            location.setX(r.nextInt(31));
            location.setY(r.nextInt(21));
            boolean b = true;
            for (int i = 0; i < snake.getLength(); i++) {
                if (body[i].getX() == location.getX() &&
                        body[i].getY() == location.getY()) {
                    b = false;
                }
            }
            if (b) break;
        }
    }

    public void init() {
        location.setX(22);
        location.setY(10);
    }
}
