/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factoryexample;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author bys99
 */
public class DateManipulator {
    Calendar calendar = new GregorianCalendar(2020, Calendar.APRIL, 1);
    Calendar today = new GregorianCalendar();
    
    public void nextDay() {
        calendar.add(Calendar.DAY_OF_MONTH, 1);
    }
    
    public Date getNextMonth() {
        Calendar newcalendar = new GregorianCalendar(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH));
        newcalendar.add(Calendar.MONTH, 1);
        return newcalendar.getTime();
    }
    
    public Date getDate() {
        return calendar.getTime();
    }
    
    public Date todayDate() {
        return today.getTime();
    }
    
    public boolean DateIsOver() {
        return calendar.after(today);
    }
}
