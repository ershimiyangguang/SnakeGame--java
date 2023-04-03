package Main;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.TimerTask;
import java.util.Timer;


import Object.*;
import ButtonCollection.*;


public class GameFrame extends JFrame implements KeyListener {
    //定义区，定义蛇，食物等对象
    public enum GameScene {main, game, pause, end}

    private int l = 30, x = 5, y = 30;
    private Image image = null;
    private Food food = new Food();
    private Snake snake = new Snake();;
    private GameScene game_scene;
    private ButtonCollection collection = new ButtonCollection();;
    private Enemy[] enemy;
    //定时区，定义timertask对象设置定时任务，再定义timer对象定时执行该任务
    private TimerTask task = new TimerTask() {
        //执行任务内容
        @Override
        public void run() {
            //游戏场景是否为“游戏中”
            if (getGameScene() == GameFrame.GameScene.game) {
                //蛇移动
                snake.move();
                for (int i = 0;i < 5;i++) {
                    //敌人移动
                    enemy[i].move(snake);
                    //敌人攻击
                    enemy[i].attack(snake,GameFrame.this);
                }
                //检测蛇是否撞到墙壁或者自己
                snake.checkAlive(GameFrame.this);
                //是否吃到食物
                if (food.checkEat(snake)) {
                    //食物转移到下一个位置
                    food.NextLocation(snake);
                    //蛇增长
                    snake.grow();
                }
                //定位蛇尾部的位置（用于蛇增长时确定新关节的位置，在判断完蛇是否吃到食物后重定向）
                snake.setTail();
                //重新画图
                repaint();
            }
            //窗体大小是否变化
            if (isResizable()&&collection!=null) {
                //各部分同步变化
                reSize();
            }
        }
    };
    private Timer timer = new Timer();



    //构造函数区，初始化各对象，属性
    public GameFrame() {
        super.setTitle("贪吃蛇");
        super.setSize(941, 664);
        super.setLayout(null);
        super.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        super.setFocusable(true);
        super.setLocationRelativeTo(null);
        super.addKeyListener(this);


        //为timer分配任务task，在0毫秒后开始，每200毫秒执行一次
        timer.scheduleAtFixedRate(task,0,200);


        enemy = new Enemy[5];
        for (int i = 0;i < 5;i++) {
            enemy[i]= new Enemy();
        }
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

    //绘画区
    @Override
    public void paint(Graphics g) {
        //定义一张图片
        image = this.createImage(getWidth(), getHeight());
        //定义此图片的画笔g_image
        Graphics g_image = image.getGraphics();
        if (game_scene == GameScene.game) {
            //使用画笔g清除画面
            g_image.clearRect(0, 0, getWidth(), getHeight());
            //使用画笔g画出蛇
            snake.paint(g_image, l, x, y);
            //使用画笔g画出食物
            food.paint(g_image, l, x, y);
            for (int i = 0;i < 5;i++) {
                //使用画笔g画出敌人
                enemy[i].paint(g_image,l,x,y);
            }
            //使用画笔g画陈网格
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
            //把图片画到frame上
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

