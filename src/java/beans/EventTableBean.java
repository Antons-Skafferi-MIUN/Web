package beans;

//import General.Event;
import General.Events;
import java.util.List;
import javax.annotation.Resource;
import javax.enterprise.context.Dependent;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Named(value = "eventTable")
//@ManagedBean
@Dependent
public class EventTableBean {
    private List<Events> eventsList;
    
    @PersistenceContext(unitName = "AntonSkafferiWebPU")
    private EntityManager em;
    @Resource
    private javax.transaction.UserTransaction utx;
    
    public List<Events> getEventsList() {
        System.out.println("getEventListCalled\n\n\n\n\n\n");
        TypedQuery<Events> query = em.createNamedQuery("Events.findAll", Events.class);
        eventsList = query.getResultList();
        for(Events event : eventsList) {
            System.out.println(event);
        }
        return eventsList;
    }
    
    public EventTableBean() {
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
//        System.out.println("Date is: " + date);
//        System.out.println("Time is: " + time);
//        System.out.println("Name is: " + name);
//        System.out.println("Description is: " + description);
//        System.out.println("Price is: " + price);
//	eventsList.add(new Event(date, time, name, description, price));
    }
    
//    public String saveAction() {
//	for (Events event : eventsList){
//		event.setEditable(false);
//	}
//	return null;
//    }
//    
//    public String editAction(Events event) {
//	    
//	event.setEditable(true); 
//	return null;
//}
    
    public String deleteAction(Events event) {
	System.out.println("Removed this entry: " + event);
	eventsList.remove(event);
	return null;
    }
}
