package theCap;

import java.awt.*;
import java.awt.event.KeyEvent;
public class Game4Racket{
    private static final int Y = 330;
    private static final int WIDTH = 60;
    private static final int HEIGHT = 10;
    int x = 0;//Pos
    int xa = 0;//"Hastighed", hvis man stopper med at trykke på piltasterne, stopper ball og xa = 0;
    private Game4 game;

    public Game4Racket(Game4 game){
        this.game=game;
    }

    //Gør at sprite racket ikke kan gå kan gå ud af frame
    public void move() {
        if (x + xa > 0 && x + xa < game.getWidth()-60)
            x = x + xa;
    }

    //Farver/tegner racket
    public void paint(Graphics2D g){
        g.fillRect(x,Y,WIDTH,HEIGHT);
    }

    //altså VKLEFT er pil venstre og gør xa = -1,"Så hastighed"
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT)
            xa = -1;
        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
            xa = 1;
    }

    //Når man så releaser venstre pil eller højre pil, gør den hastighed til 0.
    public void keyReleased(KeyEvent e) {
        xa = 0;
    }

    //Sender "bounds" af rect til andre
    public Rectangle getBounds(){
        return new Rectangle(x,Y,WIDTH,HEIGHT);
    }

    //
    public int getTopY(){
        return Y;
    }


}
