package Main;

import Button.*;

public class Collection {
    private Play play = new Play();
    private Replay replay = new Replay();
    private Exit exit = new Exit();
    private ToMain to_main = new ToMain();
    private Option option = new Option();

    public void setFrame(GameFrame frame) {
        play.setFrame(frame);
        frame.getContentPane().add(play);
        replay.setFrame(frame);
        frame.getContentPane().add(replay);
        frame.getContentPane().add(exit);
        to_main.setFrame(frame);
        frame.getContentPane().add(to_main);
        option.setFrame(frame);
        frame.getContentPane().add(option);
    }

    public void reSize(int x, int y, int l) {
        play.reSize(x, y, l);
        replay.reSize(x, y, l);
        exit.reSize(x,y,l);
        to_main.reSize(x,y,l);
        option.reSize(x,y,l);
    }

    public void toStart() {
        play.setVisible(true);
        exit.setVisible(true);
        replay.setVisible(false);
        to_main.setVisible(false);
        option.setVisible(true);
    }

    public void toGame() {
        play.setVisible(false);
        exit.setVisible(false);
        replay.setVisible(false);
        option.setVisible(false);
    }

    public void toEnd() {
        to_main.setVisible(true);
        replay.setVisible(true);
        exit.setVisible(true);
    }
}
