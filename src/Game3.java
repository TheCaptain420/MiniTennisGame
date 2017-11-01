
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Game3 extends JPanel {
    //Giver pos til ball
    int x = 0;
    int y = 0;

    //Får bolden til at rykke sig en hen og en ned
    private void moveBall() {
        x = x + 1;
        y = y + 1;
    }


    @Override
    public void paint(Graphics g) {
        //Sletter den tidligere boldt, når den nye laves med repaint. Hvis den ikke var her ville det bare være en lang linje.
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        //gør den "smooth" når den glider rundt, kunne godt have undværet
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        //tegner ball
        g2d.fillOval(x, y, 30, 30);
    }

    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame("Mini Tennis");
        Game3 game = new Game3();
        frame.add(game);
        frame.setSize(300, 400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Infinite loop
        while (true) {
            //Method fra tidligere
            game.moveBall();
            //AWT methode, der repainter ball, når den har rykket sig. Kalder methode paint() hele tiden.
            game.repaint();
            //"fps"
            Thread.sleep(10);
        }
    }
}
