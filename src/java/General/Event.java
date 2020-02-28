package General;

public class Event {
    
    private String date;
    private String name;
    private String description;
    private String price;
    
    public Event(String date, String name, String description, String price) {
        this.date = date;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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
