package theCap;

import java.awt.*;

public class Game4Ball {
    private static final int DIAMETER = 30;//På ball
    int x = 0;
    int y = 0;
    //Speed variable, der justere hastighed på ball
    // If xa=1, the ball moves to the right, one pixel every round of the theCap.Game Loop, if xa=-1, the ball moves to the left. Same with ya.
    int xa = 1;
    int ya = 1;
    int score = 0;
    private Game4 game;

    public Game4Ball(Game4 game) {
        this.game= game;
    }

    public void move() {
        //Hvis ball position er mindre end canvas bredde, går bolden til højre.
        if (x + xa < 0)
            xa = 1;
        //Hvis ball position er større end canvas bredde, går bolden til venste istedet for højre.
        if (x + xa > game.getWidth() - DIAMETER)
            xa = -1;
        //Samme her bare med op og ned
        if (y + ya < 0)
            ya = 1;
        if (y + ya > game.getHeight() - DIAMETER)
            game.gameOver();
        if (collision())
            ya = -1;
            //y= game.racket.getTopY() - DIAMETER;

        //Ball pos bliver så ændret med xa og ya
        y = y + ya;
        x = x + xa;

    }
    //Collision tester om bounds af racket og ball er det samme
    private boolean collision(){
        return game.racket.getBounds().intersects(getBounds());

    }
    //Tegner cirklen/ball om til en firkant, så bounds er lettere at hente
    public Rectangle getBounds() {
        return new Rectangle(x, y, DIAMETER, DIAMETER);
    }

    //Har bare smidt værdierne herind istedet for i theCap.Game4 paint();
    public void paint(Graphics2D g) {
        g.fillOval(x, y, 30, 30);
    }

}