package TimerStopwatch.Start;

import TimerStopwatch.GUI.UserInterface;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 *
 * @author enthye
 */
public class Main {
    public static void main(String[] args) throws Exception {  
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        SwingUtilities.invokeLater(new UserInterface());
    }
}
