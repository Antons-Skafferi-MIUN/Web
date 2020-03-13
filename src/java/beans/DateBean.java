package beans;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author mahl1400
 */
@Named(value = "dateBean")
@Dependent
public class DateBean {
    
    private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    private Date todaysDate = new Date();

    public String getTodaysDate() {
	return formatter.format(todaysDate);
    }

    public void setTodaysDate(Date todaysDate) {
	this.todaysDate = todaysDate;
    }

    
}
