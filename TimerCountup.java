package TimerStopwatch.TimerLogic;

/**
 * Counts upwards towards a set time.  Makes use of System.nanoTime for more
 * precision.  Uses a thread to keep track of the time.  GNU GPL v3.0
 * It time output defaults to seconds.  Provides methods to start, stop and reset
 * the timer.
 * 
 * @author enthye
 */
public class TimerCountup extends Thread {

    private boolean running;
    private double startTime;
    private double stopTime;
    private double totalTime;
    protected double countTo;

    public TimerCountup() {
        this.running = false;
        this.totalTime = 0;
        this.countTo = Double.POSITIVE_INFINITY;
    }
    
    // see System.currentTimeMillis() vs System.nanoTime()
    public void startTimer() {
        Thread t = new Thread();
        this.running = true;
        this.startTime = System.nanoTime(); 
        t.start(); // run the thread that keeps the time
    }

    public void stopTimer() {
        this.totalTime += getCurrentTimeElapsed() - this.stopTime;
        this.stopTime = getCurrentTimeElapsed();
        this.running = false;
        this.startTime = System.nanoTime();
    }

    public void reset() {
        this.startTime = System.nanoTime();
        this.stopTime = 0;
        this.totalTime = 0;
    }
    
    // all time is outputted in seconds
    public double getCurrentTimeElapsed() {
        return (System.nanoTime() - this.startTime) / 1000000000.0 + this.stopTime;
    }

    public double getTotalTimeElapsed() {
        return this.totalTime;
    }

    public double getStopTime() {
        return this.stopTime;
    }
    
    public double getTimerValue() {
         if (!this.running) {
             return getTotalTimeElapsed();
         } else {
             return getCurrentTimeElapsed();
         }
    }
    
    public void setCountToTime(int seconds) {
        this.countTo = seconds;
    }
    
    public double getCountToTime() {
        return this.countTo;
    }
    
    public boolean isRunning() {
        return this.running;
    }    
}