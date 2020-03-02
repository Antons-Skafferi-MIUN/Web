package beans;

import General.Events;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Named(value = "eventsBean")
@Dependent
public class EventsBean {

    @PersistenceContext(unitName = "AntonSkafferiWebPU")
    private EntityManager em;
    private List<Events> eventsList;

    public EventsBean() {
    }

    public List<Events> getEvents() {
        TypedQuery<Events> query = em.createNamedQuery("Events.findAll", Events.class);
        eventsList = query.getResultList();
        return eventsList;
    }
}
