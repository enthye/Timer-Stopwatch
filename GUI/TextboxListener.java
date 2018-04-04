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
open the template in the editor.
 */
package TimerStopwatch.GUI;

import javax.swing.JTextField;
import TimerStopwatch.TimerLogic.TimerCountup;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *  Reads the user input in the textbox for the timer
 * @author enthye
 */
public class TextboxListener {
    
    private JTextField jtf;
    private TimerCountup tcu;
    private JPanel jpe;

    public TextboxListener(JTextField jtf, TimerCountup tcu, JPanel jpe) {
        this.jtf = jtf;
        this.tcu = tcu;
        this.jpe = jpe;
    }
    
    public void load() {
            // for timercountdowns
            JPanel inputPanel = new JPanel();
            jtf.setVisible(true);
            jtf.setPreferredSize(new Dimension(25, 25));
            
            // updated to DocumentListener from ActionListener
            jtf.getDocument().addDocumentListener(new DocumentListener() {
                @Override
                public void insertUpdate(DocumentEvent de) {
                    update(); 
                }

                @Override
                public void removeUpdate(DocumentEvent de) {
                    update();
                }

                @Override
                public void changedUpdate(DocumentEvent de) {
                    update();
                }
                
                public void update() { 
                    try {
                        if (jtf.getText() != null && jtf.getText().length() < 6) {
                            tcu.setCountToTime(Integer.parseInt(jtf.getText()));
                        }  
                    } catch (Exception e) {

                    }
                }
            } );
            
            inputPanel.add(jtf);
            jpe.add(inputPanel);
    }
    
}
