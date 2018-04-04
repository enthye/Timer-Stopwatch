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

import TimerStopwatch.TimerLogic.TimerCountdown;
import TimerStopwatch.TimerLogic.TimerCountup;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.WindowConstants;

/**
 * Entry point of UI from main
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