package Main;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


import Object.*;
import Button.*;

public class GameFrame extends JFrame implements KeyListener {

    public enum GameScene {main, game, pause, end}

    private int l = 30, x = 5, y = 30;
    private Image image = null;
    private Food food;
    private Snake snake;
    private GameScene game_scene;
    private Collection collection;

    private Enemy[] enemy = new Enemy[1000];

    public GameFrame(Snake snake, Food food, Collection collection,Enemy[] enemy) {
        super.setTitle("贪吃蛇");

        super.setSize(941, 664);
        super.setLayout(null);
        super.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        super.setFocusable(true);
        super.setLocationRelativeTo(null);
        super.addKeyListener(this);


        this.food = food;
        this.snake = snake;
        for (int i = 0;i < 5;i++) {
            this.enemy[i]= enemy[i];
        }
        this.collection = collection;
        collection.setFrame(this);
        this.toMain();
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int x = e.getKeyCode();
        if (getGameScene() == GameFrame.GameScene.game) {
            snake.setDirection(x);
            if (x==80) game_scene = GameScene.pause;
        } else if (getGameScene() == GameFrame.GameScene.main) {
            if (x == 32) toGame();
            if (x==27) System.exit(0);
        } else if (getGameScene() == GameFrame.GameScene.end) {
            if (x == 32) toGame();
            if (x==77) toMain();
        } else if (getGameScene() == GameFrame.GameScene.pause) {
            if (x==80) game_scene = GameScene.game;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }


    @Override
    public void paint(Graphics g) {
        image = this.createImage(getWidth(), getHeight());
        Graphics g_image = image.getGraphics();
        if (game_scene == GameScene.game) {
            g_image.clearRect(0, 0, getWidth(), getHeight());
            snake.paint(g_image, l, x, y);
            food.paint(g_image, l, x, y);
            g_image.setColor(Color.BLACK);
            for (int i = 0; i <= 31; i++) {
                g_image.setColor(Color.BLACK);
                if (i == 0 || i == 31)
                    g_image.setColor(Color.RED);
                g_image.drawLine(i * l + x, y, i * l + x, 21 * l + y);
            }
            for (int i = 0; i <= 21; i++) {
                g_image.setColor(Color.BLACK);
                if (i == 0 || i == 21)
                    g_image.setColor(Color.RED);
                g_image.drawLine( x, i * l + y, 31 * l + x, i * l + y);
            }
            g.drawImage(image, 0, 0, null);
        }
    }


    public GameScene getGameScene() {
        return game_scene;
    }

    public void setGameScene(GameScene game_scene) {
        this.game_scene = game_scene;
    }

    public void reSize() {
        l = Math.min((getHeight() - 34) / 21, (getWidth() - 11) / 31);
        x = (getWidth() - 11 - l * 31) / 2 + 5;
        y = (getHeight() - 34 - l * 21) / 2 + 30;
        collection.reSize(x, y, l);
    }


    public void toMain() {
        collection.toMain();
        game_scene = GameScene.main;
    }

    public void toGame() {
        collection.toGame();
        food.init();
        snake.init();
        game_scene = GameScene.game;
    }

    public void toEnd() {
        repaint();
        collection.toEnd();
        game_scene = GameScene.end;
    }
}

