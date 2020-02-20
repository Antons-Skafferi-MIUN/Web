package beans;

import java.io.Serializable;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;

@Named(value = "calendarManagedBean")
@SessionScoped
public class CalendarManagedBean implements Serializable{
	private Date date = new Date();
        
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}