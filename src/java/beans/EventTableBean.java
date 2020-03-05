package beans;

//import General.Event;
import General.Events;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

@Named(value = "eventTable")
@ManagedBean
@Dependent
public class EventTableBean implements Serializable{
    private List<Events> eventsList;
    private String date;
    private String time;
    private String name;
    private String description;
    private Integer price;
    private String image;
    
    
    @PersistenceContext(unitName = "AntonSkafferiWebPU")
    private EntityManager em;
    @Resource
    private javax.transaction.UserTransaction utx;
    
    public List<Events> getEventsList() {
//        System.out.println("getEventListCalled\n\n\n\n\n\n");
        TypedQuery<Events> query = em.createNamedQuery("Events.findAll", Events.class);
        eventsList = query.getResultList();
//        for(Events event : eventsList) {
//            System.out.println(event);
//        }
        return eventsList;
    }
    
    public EventTableBean() {
    }
    
    public void select(Events event) {
        System.out.println(event);
    }

//    private List<Event> eventsList = new ArrayList<>(
//	    Arrays.asList(
//	    new Event("20/07", "17:00", "Smalare än Thord1", "Lorem ipsum lo9rm ups lkslsldl lsle rl laealfaewfl rem Lorem ipsum lo9rm ups laealfaewfl rem Lorem ipsum lo9rm ups", "120"),
//	    new Event("20/07", "17:00", "Smalare än Thord2", "Lorem ipsum lo9rm ups lkslsldl lsle rl laealfaewfl rem Lorem ipsum lo9rm ups laealfaewfl rem Lorem ipsum lo9rm ups", "120"),
//	    new Event("20/07", "17:00", "Smalare än Thord3", "Lorem ipsum lo9rm ups lkslsldl lsle rl laealfaewfl rem Lorem ipsum lo9rm ups laealfaewfl rem Lorem ipsum lo9rm ups", "120"))
//    );
//    {};
//    public List<Event> getEventsList() {
//
//	return eventsList;
//
//    }
    
    public void submitted() {
        System.out.println("Form was submitted!");
        System.out.println(name + ", " + time + ", " + date + ", " + description + ", " + price + ", " + image);
        Events event = new Events(name, time, date, description, price, image);
        try {
            utx.begin();
            em.persist(event);
            utx.commit();
        } catch (Exception e) {
            System.err.println(e);
        }
//        System.out.println("Date is: " + date);
//        System.out.println("Time is: " + time);
//        System.out.println("Name is: " + name);
//        System.out.println("Description is: " + description);
//        System.out.println("Price is: " + price);
//	eventsList.add(new Event(date, time, name, description, price));
    }
    
    public String saveAction() {
	for (Events event : eventsList){
		event.setEditable(false);
	}
	return null;
    }
    
    public String editAction(Events event) {
	    
	event.setEditable(true); 
	return null;
}
    
    public String deleteAction(Events event) {
        
        try {
            utx.begin();
            em.joinTransaction();
            Query deleteById = em.createQuery("DELETE FROM Events e WHERE e.eventId = :id");
            deleteById.setParameter("id", event.getEventId()).executeUpdate();
            utx.commit();
        } catch (Exception e) {
            System.err.println(e);
        }
        
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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
    public void addPerson(){
        Events event = new Events();
        event.setEventDate(date);
        event.setEventTime(time);
        event.setEventName(name);
        event.setEventDescription(description);
        event.setEventPrice(price);
        event.setEventImage(image);
        event.setEventEditable(false);
        persist(event);
    }
    
    public void persist(Object object) {
        try {
            utx.begin();
            em.persist(object);
            utx.commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
        }
    }
}
