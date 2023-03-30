package Main;

import java.util.*;
import java.util.Timer;

import Button.Collection;
import Object.*;

//test 1

public class Main {
    public static void main(String[] args) {
        Food food = new Food();
        Snake snake = new Snake();
        Enemy[] enemy = new Enemy[5];
        for (int i = 0;i < 5;i++) {
            enemy[i]= new Enemy();
        }
        Button.Collection collection = new Collection();
        GameFrame frame = new GameFrame(snake, food, collection,enemy);


        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                if (frame.getGameScene() == GameFrame.GameScene.game) {
                    snake.move();
                    for (int i = 0;i < 5;i++) {
                        enemy[i].move();
                        enemy[i].attack(snake,frame);
                    }
                    snake.checkAlive(frame);
                    if (food.checkEat(snake)) {
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
