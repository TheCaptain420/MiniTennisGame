
import java.awt.Graphics2D;

public class Game4Ball {
    int x = 0;
    int y = 0;
    //Speed variable, der justere hastighed på ball
    // If xa=1, the ball moves to the right, one pixel every round of the Game Loop, if xa=-1, the ball moves to the left. Same with ya.
    int xa = 1;
    int ya = 1;

    private Game4 game;

    public Game4Ball(Game4 game) {
        this.game= game;
    }

    public void move() {
        //Hvis ball position er mindre end canvas bredde, går bolden til højre.
        if (x + xa < 0)
            xa = 1;
        //Hvis ball position er større end canvas bredde, går bolden til venste istedet for højre.
        if (x + xa > game.getWidth() - 30)
            xa = -1;
        //Samme her bare med op og ned
        if (y + ya < 0)
            ya = 1;
        if (y + ya > game.getHeight() - 30)
            ya = -1;
        //Ball pos bliver så ændret med xa og ya
        x = x + xa;
        y = y + ya;
    }
    //Har bare smidt værdierne herind istedet for i Game4 paint();
    public void paint(Graphics2D g) {
        g.fillOval(x, y, 30, 30);
    }
}