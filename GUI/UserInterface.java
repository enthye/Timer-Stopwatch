package TimerStopwatch.GUI;

import TimerStopwatch.TimerLogic.TimerCountdown;
import TimerStopwatch.TimerLogic.TimerCountup;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.WindowConstants;

/**
 *
 * @author enthye
 */
public class UserInterface implements Runnable {
    
    @Override
    public void run() {
        JFrame frame = new JFrame("Stopwatch and Timer");
        frame.setPreferredSize(new Dimension(300, 300));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        
        createComponents(frame.getContentPane());
        
        frame.pack();
        frame.setVisible(true);
    }
    
    private void createComponents(Container c) {
        JTabbedPane tabs = new JTabbedPane();

        tabs.add(new TimerUI("Stopwatch", new TimerCountup(), TimerConstants.STOPWATCH), "Stopwatch");
        tabs.add(new TimerUI("Timer", new TimerCountdown(), TimerConstants.TIMER), "Timer");
             
        c.add(tabs); // add all tabs to frame
    } 
    
}