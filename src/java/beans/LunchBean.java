package beans;

import General.Lunches;
import java.util.Calendar;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Named(value = "lunchBean")
@Dependent
public final class LunchBean {

    @PersistenceContext(unitName = "AntonSkafferiWebPU")
    private String lunchName;
    private String lunchWeek;
    private String lunchDay;
    private EntityManager em;
    private List<Lunches> lunchList;  

    public LunchBean() {
    }

    public List<Lunches> getLunch() {
        TypedQuery<Lunches> query = em.createNamedQuery("Lunches.findByLunchWeek", Lunches.class);
        query.setParameter("lunchWeek",getWeek());
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

    public String getLunchName() {
        return lunchName;
    }

    public void setLunchName(String lunchName) {
        this.lunchName = lunchName;
    }

    public String getLunchWeek() {
        return lunchWeek;
    }

    public void setLunchWeek(String lunchWeek) {
        this.lunchWeek = lunchWeek;
    }

    public String getLunchDay() {
        return lunchDay;
    }

    public void setLunchDay(String lunchDay) {
        this.lunchDay = lunchDay;
    }

}
