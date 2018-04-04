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

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import TimerStopwatch.TimerLogic.TimerCountup;
import javax.swing.JTextField;

/**
 *
 * @author enthye
 */
public class TimerButtons extends JPanel {

    private JButton start;
    private JButton stop;
    private JButton reset;
    private TimerCountup tcu;
    private JTextField jtf;
    
    public TimerButtons(TimerCountup tcu, JTextField jtf) {
        super(new GridLayout(1, 3));
        this.tcu = tcu;
        this.jtf = jtf;
        createComponents();
    }
    
    private void createComponents() {
        // start, stop/pause, reset
        start = new JButton("Start");
        stop = new JButton("Stop/Pause");
        reset = new JButton("Reset");
        
        ClickListener cl = new ClickListener(tcu, jtf, start, stop, reset);
        start.addActionListener(cl);
        stop.addActionListener(cl);
        reset.addActionListener(cl);
        
        stop.setVisible(false);
        
        add(start);
        add(stop);
        add(reset);  
    }
    
    public void setReset() {
        tcu.stopTimer();
        tcu.reset();
        jtf.setVisible(true);
        stop.setVisible(false);
        start.setVisible(true);
        reset.setVisible(true);   
    }
    
}
