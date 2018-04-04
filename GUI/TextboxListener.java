/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TimerStopwatch.GUI;

import javax.swing.JTextField;
import TimerStopwatch.TimerLogic.TimerCountup;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author Claude
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
