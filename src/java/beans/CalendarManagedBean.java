package beans;

import java.io.Serializable;

import java.util.Date;

import javax.enterprise.context.Dependent;
import javax.inject.Named;

@Named(value = "calendarManagedBean")
@Dependent
public class CalendarManagedBean implements Serializable{
	private Date date = new Date();
        private String temp = "test";
        
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
        
        public String getTemp() {
            return temp;
        }
}