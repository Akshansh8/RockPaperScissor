import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class App {
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// instantiate a rockpaperscissior gui obj
				
				RockPapperGUI rockPapperGUI = new RockPapperGUI();
				
				//display the gui
				rockPapperGUI.setVisible(true);
				
			}
		});
	}

}
