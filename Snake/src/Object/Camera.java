package Object;

import java.awt.*;

public class Camera {
    Location location;

    public Camera() {
        this.location = new Location();
    }

    public void move(Snake snake) {
        Location head = snake.getSnake_body()[0];
        location.setX(head.getX()-15);
        location.setY(head.getY()-10);
    }

    public void paint(Graphics g,int l,int x,int y) {

    }

    public Location getLocation() {
        return location;
    }
}
