package beans;

import General.Event;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "eventTable")
@SessionScoped
public class EventTableBean implements Serializable {
    
    private String date;
    private String time;
    private String name;
    private String description;
    private String price;

    private List<Event> eventList = new ArrayList<>(
	    Arrays.asList(
	    new Event("20/07", "17:00", "Smalare än Thord1", "Lorem ipsum lo9rm ups lkslsldl lsle rl laealfaewfl rem Lorem ipsum lo9rm ups laealfaewfl rem Lorem ipsum lo9rm ups", "120"),
	    new Event("20/07", "17:00", "Smalare än Thord2", "Lorem ipsum lo9rm ups lkslsldl lsle rl laealfaewfl rem Lorem ipsum lo9rm ups laealfaewfl rem Lorem ipsum lo9rm ups", "120"),
	    new Event("20/07", "17:00", "Smalare än Thord3", "Lorem ipsum lo9rm ups lkslsldl lsle rl laealfaewfl rem Lorem ipsum lo9rm ups laealfaewfl rem Lorem ipsum lo9rm ups", "120"))
    );
    {};

    public List<Event> getEventList() {

	return eventList;

    }
    
    public void submitted() {
        System.out.println("Form was submitted!");
        System.out.println("Date is: " + date);
        System.out.println("Time is: " + time);
        System.out.println("Name is: " + name);
        System.out.println("Description is: " + description);
        System.out.println("Price is: " + price);
	eventList.add(new Event(date, time, name, description, price));
    }
    
    public String saveAction() {
	for (Event event : eventList){
		event.setEditable(false);
	}
	return null;
    }
    
    public String editAction(Event event) {
	    
	event.setEditable(true);
	return null;
}
    
    public String deleteAction(Event event) {
	System.out.println("Removed this entry: " + event);
	eventList.remove(event);
	return null;
    }
    
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
	return time;
    }

    public void setTime(String time) {
	this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
