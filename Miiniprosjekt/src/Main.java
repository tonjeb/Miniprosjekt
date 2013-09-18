import javax.swing.JFrame;

/**
 * 
 */

/**
 * @author Ola
 *
 */
public class Main extends JFrame {

	public Main () {
		super("Hello World");
		//add(new Test());
		pack(); // makes window fit all components
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}

}
