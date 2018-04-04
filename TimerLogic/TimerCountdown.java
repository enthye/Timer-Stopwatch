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

package TimerStopwatch.TimerLogic;

/**
 * Counts downwards towards 0 instead of upwards
 * 
 * @author enthye
 */
public class TimerCountdown extends TimerCountup {
    
    public TimerCountdown() {
        super();
        this.countTo = 0;
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
