import javax.swing.JFrame;

public class Game {
	public static void main(String[] args) {
		//Title of screen
		JFrame frame = new JFrame("Mini Tennis");
		//Size
		frame.setSize(300, 300);
		//Kan den ses?
		frame.setVisible(true);
		//operator for x i højre hjørne
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}