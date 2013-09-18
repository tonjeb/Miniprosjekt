import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JFrame;

/**
 * 
 */

/**
 * @author Ola
 *
 */
public class Main extends JFrame {
	static ResourceBundle messages;
	public Main () {
		super("Hello World");
		setJMenuBar (new MenuBar());
		//add(new Test());
		pack(); // makes window fit all components
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Locale currentLocale;
		
		if (args.length==2) {
			currentLocale = new Locale (args[0], args[1]);	// Språk, land
		} else if (args.length==1) {
			currentLocale = new Locale (args[0]);	// språk
		} else
			currentLocale = Locale.getDefault();
			
		messages = ResourceBundle.getBundle ("I18N", currentLocale);
		
		new Main();
	}

}
