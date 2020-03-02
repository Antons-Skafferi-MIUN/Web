package General;

public class Event {

    private String date;
    private String time;
    private String name;
    private String description;
    private String price;

    boolean editable;

    public Event(String date, String time, String name, String description,
		 String price) {
	this.date = date;
	this.time = time;
	this.name = name;
	this.description = description;
	this.price = price;
    }
    
    public boolean isEditable() {
	return editable;
    }

    public void setEditable(boolean editable) {
	this.editable = editable;
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

    @Override
    public String toString() {
	return "Event{" + "date=" + date + ", time=" + time + ", name=" + name + ", description=" + description + ", price=" + price + '}';
    }
}
