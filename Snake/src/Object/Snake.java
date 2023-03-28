package Object;

import java.awt.*;

import Main.*;

public class Snake {
    public enum Direction {up, down, left, right}

    private Location[] snake_body = new Location[1000];
    private Location head;
    private Location tail;
    private int length;
    private Direction direction;

    public Snake() {
        init();
    }

    public void paint(Graphics g, int l, int a, int b) {
        int x, y;
        g.setColor(Color.RED);
        for (int i = 0; i < length; i++) {
            x = snake_body[i].getX();
            y = snake_body[i].getY();
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

    public void setDirection(int x) {
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

    public void move() {
        for (int i = length - 1; i > 0; i--) {
            snake_body[i].setX(snake_body[i - 1].getX());
            snake_body[i].setY(snake_body[i - 1].getY());
        }
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

    public void checkAlive(GameFrame frame) {
        boolean b = true;
        if (head.getX() < 0 || head.getX() > 30 ||
                head.getY() < 0 || head.getY() > 20) {
            b = false;
        }
        for (int i = 1; i < length; i++) {
            if (snake_body[i].getX() == head.getX() &&
                    snake_body[i].getY() == head.getY()) {
                b = false;
            }
        }
        if (!b) {
            frame.setGameScene(GameFrame.GameScene.end);
            frame.toEnd();
        }
    }

    public boolean checkEat(Food food) {
        if (food.getLocation().getX() == head.getX() &&
                food.getLocation().getY() == head.getY()) {
            return true;
        } else {
            return false;
        }
    }

    public void grow() {
        snake_body[length] = new Location(tail.getX(), tail.getY());
        length = length + 1;
    }

    public void setTail() {
        tail.setX(snake_body[length - 1].getX());
        tail.setY(snake_body[length - 1].getY());
    }

    public Location[] getSnake_body() {
        return snake_body;
    }

    public int getLength() {
        return length;
    }

    public void init() {
        length = 2;
        snake_body[0] = new Location(8, 10);
        snake_body[1] = new Location(7, 10);
        head = snake_body[0];
        tail = new Location(snake_body[length - 1]);
        direction = Direction.right;
    }

}
