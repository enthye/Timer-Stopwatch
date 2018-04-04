/*
Timer-Stopwatch
Copyright (C) 2018 enthye

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/

package TimerStopwatch.GUI;

import TimerStopwatch.TimerLogic.TimerCountup;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;

/**
 * Buttons click action listener for both stopwatch and timer (reset, start, stop)
 * @author enthye
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
