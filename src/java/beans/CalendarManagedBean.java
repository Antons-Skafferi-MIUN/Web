package beans;

import java.io.Serializable;

import java.util.Date;

import javax.enterprise.context.Dependent;
import javax.inject.Named;
import org.primefaces.event.SelectEvent;

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
        
        public void dateSelectedAction(SelectEvent e){
		Date date = (Date)e.getObject();
                setDate(date);
                temp = "Temptest";
		System.out.println("Date Selected Is :" + date + "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nHello");
                System.out.println(temp);
        }
        
        public String getTemp() {
            return temp;
        }
}