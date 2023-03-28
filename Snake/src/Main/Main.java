package Main;

import java.util.*;
import java.util.Timer;

import Object.*;


public class Main {
    public static void main(String[] args) {
        Food food = new Food();
        Snake snake = new Snake();
        Collection collection = new Collection();
        GameFrame frame = new GameFrame(snake, food, collection);


        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                if (frame.getGameScene() == GameFrame.GameScene.game) {
                    snake.move();
                    snake.checkAlive(frame);
                    if (snake.checkEat(food)) {
                        food.NextLocation(snake);
                        snake.grow();
                    }
                    snake.setTail();
                    frame.repaint();
                }
                if (frame.isResizable()) {
                    frame.reSize();
                }
            }
        };
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(task, 0, 200);

        frame.setVisible(true);
    }
}
