package Main;

import java.util.*;
import java.util.Timer;

import Button.Collection;
import Object.*;

//test1

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




        frame.setVisible(true);
    }
}
