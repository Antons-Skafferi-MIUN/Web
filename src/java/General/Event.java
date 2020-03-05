package General;

public class Event {

    private String eventDate;
    private String eventTime;
    private String eventName;
    private String eventDescription;
    private String eventPrice;

    boolean editable;

    public Event(String date, String time, String name, String description,
		 String price) {
	this.eventDate = date;
	this.eventTime = time;
	this.eventName = name;
	this.eventDescription = description;
	this.eventPrice = price;
    }
    
    public boolean isEditable() {
	return editable;
    }

    public void setEditable(boolean editable) {
	this.editable = editable;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventTime() {
        return eventTime;
    }

    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public String getEventPrice() {
        return eventPrice;
    }

    public void setEventPrice(String eventPrice) {
        this.eventPrice = eventPrice;
    }

    @Override
    public String toString() {
        return "Event{" + "eventDate=" + eventDate + ", eventTime=" + eventTime + ", eventName=" + eventName + ", eventDescription=" + eventDescription + ", eventPrice=" + eventPrice + ", editable=" + editable + '}';
    }
}