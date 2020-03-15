/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author mahl1400
 */
@Named(value = "dayOfWeekBean")
@Dependent
public class DayOfWeekBean {
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    private Calendar cal = Calendar.getInstance();
    private String monday;
    private String tuesday;
    private String wednesday;
    private String thursday;
    private String friday;
    private String saturday;

    public DayOfWeekBean() {
	cal.set(Calendar.WEEK_OF_YEAR, 11);
    }

    public String getMonday() {
	cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
	System.out.println("Dates: " + sdf.format(cal.getTime()));
	return sdf.format(cal.getTime());
    }

    public void setMonday(String monday) {
	this.monday = monday;
    }

    public String getTuesday() {
	cal.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
	System.out.println("Dates: " + sdf.format(cal.getTime()));
	return sdf.format(cal.getTime());
    }

    public void setTuesday(String tuesday) {
	this.tuesday = tuesday;
    }

    public String getWednesday() {
	cal.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
	System.out.println("Dates: " + sdf.format(cal.getTime()));
	return sdf.format(cal.getTime());
    }

    public void setWednesday(String wednesday) {
	this.wednesday = wednesday;
    }

    public String getThursday() {
	cal.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
	System.out.println("Dates: " + sdf.format(cal.getTime()));
	return sdf.format(cal.getTime());
    }

    public void setThursday(String thursday) {
	this.thursday = thursday;
    }

    public String getFriday() {
	cal.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
	System.out.println("Dates: " + sdf.format(cal.getTime()));
	return sdf.format(cal.getTime());
    }

    public void setFriday(String friday) {
	this.friday = friday;
    }

    public String getSaturday() {
	cal.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
	System.out.println("Dates: " + sdf.format(cal.getTime()));
	return sdf.format(cal.getTime());
    }

    public void setSaturday(String saturday) {
	this.saturday = saturday;
    }
    
}
