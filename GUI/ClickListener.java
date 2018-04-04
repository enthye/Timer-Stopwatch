package TimerStopwatch.GUI;

import TimerStopwatch.TimerLogic.TimerCountup;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;

/**
 *
 * @author Claude
 */
public class ClickListener implements ActionListener {

    private final TimerCountup tcu;
    private final JButton start;
    private final JButton stop;
    private final JButton reset;
    private final JTextField jtf;
    
    public ClickListener(TimerCountup tcu, JTextField jtf, JButton start, JButton stop, JButton reset) {
        this.tcu = tcu;
        this.jtf = jtf;
        this.start = start;
        this.stop = stop;
        this.reset = reset;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == start) {
            start.setVisible(false);
            stop.setVisible(true);
            reset.setVisible(false);
            if (jtf.isVisible()) {
                jtf.setVisible(false);
            }
            tcu.startTimer();

        } else if (ae.getSource() == stop) {
            start.setVisible(true);
            stop.setVisible(false);
            reset.setVisible(true);
            tcu.stopTimer();

        } else if (ae.getSource() == reset) {
            start.setVisible(true);
            if (!jtf.isVisible()) {
                jtf.setVisible(true);
            }
            tcu.reset();
        }
    }   
}
