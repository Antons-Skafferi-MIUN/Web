package beans;

import General.Lunches;
import java.util.Calendar;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Named(value = "printMenu")
@Dependent
public final class PrintMenu {

    @PersistenceContext(unitName = "AntonSkafferiWebPU")
    private EntityManager em;
    private List<Lunches> lunchList;  

    public PrintMenu() {
    }

    public List<Lunches> getLunch() {
        TypedQuery<Lunches> query = em.createNamedQuery("Lunches.findAll", Lunches.class);
        lunchList = query.getResultList();
        return lunchList;
    }

    public int getDay() {
        Calendar cal = Calendar.getInstance();
        return cal.get(Calendar.DAY_OF_WEEK);
    }

    public int getWeek() {
        Calendar cal = Calendar.getInstance();
        return cal.get(Calendar.WEEK_OF_YEAR);
    }

    public String getDayClass(int i) {
        System.out.println(i);
        System.out.println(getDay());
        if (i == getDay()) {
            return "menu-item--current";
        } else if (i < getDay()) {
            return "menu-item--past";
        } else {
            return "menu-item--next";
        }
    }

}
