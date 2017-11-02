package theCap;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

@SuppressWarnings("serial")
public class Game4 extends JPanel {

    //Henter ball fra theCap.Game4Ball, har i teorien bare ryttet op..
    Game4Ball ball = new Game4Ball(this);
    Game4Racket racket = new Game4Racket(this);


    //Keylistener til styring af racket
    public Game4(){
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                racket.keyReleased(e);
            }

            @Override
            public void keyPressed(KeyEvent e) {
                racket.keyPressed(e);
            }
        });
        setFocusable(true);

    }

    public void move(){
        ball.move();
        racket.move();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        ball.paint(g2d);
        racket.paint(g2d);

    }
    //Printer gameover, som bliver kørt i GAME4BALL
    public void gameOver() {
        JOptionPane.showMessageDialog(this, "Game Over "+ball.score, "Game Over", JOptionPane.YES_NO_OPTION);
        System.exit(ABORT);
    }

    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame("Mini Tennis");
        Game4 game = new Game4();
        frame.add(game);
        frame.setSize(300, 400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        while (true) {
            game.move();
            game.repaint();
            Thread.sleep(10);
        }

    }
}