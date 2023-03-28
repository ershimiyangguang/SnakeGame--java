package Object;

import java.awt.*;
import java.util.Random;

public class Food {
    private Location location;

    public Food() {
        location = new Location(22, 10);
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(int x, int y) {
        location.setX(x);
        location.setY(y);
    }

    public void paint(Graphics g, int l, int x, int y) {
        g.setColor(Color.GREEN);
        g.fillRect(location.getX() * l + x, location.getY() * l + y, l, l);
    }

    public void NextLocation(Snake snake, Location[] snake_body) {
        while (true) {
            Random r = new Random();
            location.setX(r.nextInt(31));
            location.setY(r.nextInt(21));
            boolean b = true;
            for (int i = 0; i < snake.getLength(); i++) {
                if (snake_body[i].getX() == location.getX() &&
                        snake_body[i].getY() == location.getY()) {
                    b = false;
                }
            }
            if (b) break;
        }
    }
}
