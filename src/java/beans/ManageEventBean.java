package beans;

import General.Event;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;
import javax.faces.bean.SessionScoped;

@Named(value = "manageEventBean")
@ManagedBean
@SessionScoped
public class ManageEventBean implements Serializable {

    private String date;
    private String time;
    private String name;
    private String description;
    private String price;
//    private List<Event> result = new ArrayList<>();


    public ManageEventBean() {
    }

    public void submitted() {
        System.out.println("Form was submitted!");
        System.out.println("Date is: " + date);
        System.out.println("Name is: " + name);
        System.out.println("Description is: " + description);
        System.out.println("Price is: " + price);
    }
    
//    public List<Event> getResult() {
//        return result;
//    }
//
//    public void setResult(ArrayList<Event> result) {
//        this.result = result;
//    }

//    public void resultSubmitted() {
//        System.out.println("Complete result: ");
//        for (Event event : result) {
//            System.out.println("Date: " + event.getDate());
//            System.out.println("Description: " + event.getDescription());
//            System.out.println("Name: " + event.getName());
//            System.out.println("Price: " + event.getPrice());
//        }
//    }

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
