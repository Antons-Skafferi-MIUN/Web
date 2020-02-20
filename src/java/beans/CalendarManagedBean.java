package beans;

import java.io.Serializable;

import java.util.Date;

import javax.faces.bean.SessionScoped;
import javax.inject.Named;
import org.primefaces.event.SelectEvent;

@Named(value = "calendarManagedBean")
@SessionScoped
public class CalendarManagedBean implements Serializable{
	private Date date = new Date();
        private String temp = "test";
        
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
        
        public void dateSelectedAction(SelectEvent e){
		Date date = (Date)e.getObject();
                temp = date.toString();
//		System.out.println("<p>Date Selected Is ::" + date + "</p>");
	}
        
        public String getTemp() {
            return temp;
        }
}