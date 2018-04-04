/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TimerStopwatch.GUI;

import TimerStopwatch.TimerLogic.TimerCountup;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;

/**
 *
 * @author enthye
 */
public class TimerUI extends JPanel {

    private String name;
    protected TimerCountup tcu;
    private TimerConstants timerConstant;
    private JLabel timeDisplay;
    protected TimerButtons tbu;
    
    public TimerUI(String name, TimerCountup tcu, TimerConstants timerConstant) {
        super(new GridLayout(5, 1));
        this.name = name;
        this.tcu = tcu;
        this.timerConstant = timerConstant;
        createComponents();
    }
    
    private void createComponents() {
        // title
        add(new JLabel(name, SwingConstants.CENTER));
        add(new JLabel());
        
        // set up main counter interface
        timeDisplay = new JLabel("", SwingConstants.CENTER);
        timeDisplay.setFont(new Font(null, Font.BOLD, 20));
        add(name, timeDisplay);  
        
        // JTextField jtf = null;
        JTextField jtf = new JTextField();
        jtf.setVisible(false);
        
        if (timerConstant == TimerConstants.TIMER) {
            // puts the text field into jpanel and updates the timer with user input
            TextboxListener tbl = new TextboxListener(jtf, tcu, this);
            tbl.load();
        } else {
            add(new JPanel()); // empty Jpanel
        }
        
         // set up start/stop/reset buttons
        tbu = new TimerButtons(tcu, jtf);
        add(tbu, BorderLayout.SOUTH);

        // action listener logic for the swing timer
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if ((int)tcu.getTimerValue() / 60 == 1) {
                    timeDisplay.setText("1 Minute"); 
                } else if ((int)tcu.getTimerValue() < 60) {
                    if ((int)tcu.getTimerValue() != 1){
                    timeDisplay.setText(String.valueOf(
                            (int)tcu.getTimerValue()) + " Seconds");
                    } else {
                        timeDisplay.setText("1 Second");
                    }               
                } else {
                    timeDisplay.setText(String.valueOf(
                            (int)tcu.getTimerValue() / 60) + " Minutes");
                }
                
                // popup warning if reached time limit
                if (((int)tcu.getTimerValue() >= tcu.getCountToTime() && timerConstant == TimerConstants.STOPWATCH) || 
                        (timerConstant == TimerConstants.TIMER && (int)tcu.getTimerValue() == 0) &&
                            tcu.isRunning()) {
                        popup();
                        resetButtons();
                    }
            }
        };
        
        // swing timer to put this all together
        Timer timer = new Timer(300, al);
        timer.start();
    }
    
    protected void popup() {
        JOptionPane.showMessageDialog(null, new JLabel("Finished!"), "An Annoying Pop-Up", JOptionPane.QUESTION_MESSAGE);
    }
    
    protected void resetButtons() {
        tbu.setReset();
    }
}