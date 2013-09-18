import java.awt.BorderLayout;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JFrame;
import javax.swing.JLabel;
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
		ToolBar tb = new ToolBar();
		setJMenuBar (tb.menuBar);
		add (tb.toolBar, BorderLayout.NORTH);
		//add(new Test());
		add (new Table());
		JLabel status = new JLabel ("Status");
		add(status, BorderLayout.SOUTH);
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
