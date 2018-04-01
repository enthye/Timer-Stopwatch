package TimerStopwatch.TimerLogic;

/**
 * Counts downwards towards 0 instead of upwards GNU GPL v3.0
 * 
 * @author enthye
 */
public class TimerCountdown extends TimerCountup {
    
    public TimerCountdown() {
        super();
        this.countTo = 0; // countdown to 0
    }

    @Override
    public double getTimerValue() {
        if (super.countTo - super.getCurrentTimeElapsed() > 0 && isRunning()) {
            return super.countTo - super.getCurrentTimeElapsed();
        } else if (super.countTo - super.getTotalTimeElapsed() > 0 && !isRunning()) { // possible bug change current -> total (confirmed)
            return super.countTo - super.getTotalTimeElapsed();
        } 
        
        return 0;
    }
}
