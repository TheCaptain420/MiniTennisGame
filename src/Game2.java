//Imports til JFRAME
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Game2 extends JPanel {
	//Methode paint(), der "maler" ting på canvas
	@Override
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		//Her maler den alle ting røde
		g2d.setColor(Color.RED);
		//Tegner figurer, fill= fyldt med farve, draw= kun omskitset
		g2d.fillOval(0, 0, 30, 30);
		g2d.drawOval(0, 50, 30, 30);		
		g2d.fillRect(50, 0, 30, 30);
		g2d.drawRect(50, 50, 30, 30);

		g2d.draw(new Ellipse2D.Double(0, 100, 30, 30));
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Mini Tennis");
		//adder klassen med figurerne
		frame.add(new Game2());
		frame.setSize(300, 300);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}