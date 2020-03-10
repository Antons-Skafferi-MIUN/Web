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
        TypedQuery<Events> query = em.createNamedQuery("Events.findTwoFutureEvents", Events.class);
        eventsList = query.setMaxResults(2).getResultList();
        return eventsList;
    }
}
