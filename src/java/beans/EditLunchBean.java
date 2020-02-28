package beans;

//import General.Lunch;
import General.Lunches;
import java.util.ArrayList;
import java.util.Calendar;
import javax.annotation.Resource;
import javax.inject.Named;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Named(value = "editLunchBean")
@ManagedBean
@SessionScoped

public class EditLunchBean {

    @PersistenceContext(unitName = "AntonSkafferiWebPU")
    private EntityManager em;
    @Resource
    private javax.transaction.UserTransaction utx;
    private ArrayList<Lunches> lunchList;

    private Integer day;

    private Integer week;
    private ArrayList<Integer> weekList;
    private Integer thisWeek;

    private String meal;
    private ArrayList<Lunches> loadLunches;

    public EditLunchBean() {
        this.lunchList = new ArrayList<>();
        this.loadLunches = new ArrayList<>();
        this.weekList = new ArrayList<>();
        updateWeeks();
        generateLunches();
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public void submit() {
        // Call entity bean.

        for (Lunches meals : loadLunches) {
            if (!meals.getLunchName().equals("Maträtt")) {
                lunchList.add(meals);
//                System.out.println(meals.getLunchName() + ", " + meals.getLunchDay() + ", " + meals.getLunchWeek());
            }
        }

        //lunchList to DB.
        for (Lunches meal : lunchList) {

            System.out.println(meal.getLunchName() + ", " + meal.getLunchDay() + ", " + meal.getLunchWeek());
            persist(meal);
        }

    }

    public String getMeal() {
        return meal;
    }

    public void setMeal(String meal) {
        this.meal = meal;

    }

    public void setMealTest(Integer i) {
        System.out.println(i);
    }

    public Integer getWeek() {
        return week;
    }

    public void setWeek(Integer week) {
        this.week = week;
        updateWeeksInList();
    }

    public Integer getThisWeek() {
        Calendar cal = Calendar.getInstance();
        return week = cal.get(Calendar.WEEK_OF_YEAR);
    }

    public void setThisWeek(Integer week) {
        this.week = week;
    }

    public ArrayList<Integer> getWeeks() {
        return weekList;
    }

    private void updateWeeks() {

        ArrayList<Integer> tempList = new ArrayList<>();

        Calendar cal = Calendar.getInstance();
        setWeek(cal.get(Calendar.WEEK_OF_YEAR));
        for (int i = 0; i < 3; i++) {
            tempList.add(cal.get(Calendar.WEEK_OF_YEAR) + i);
        }
        this.weekList = tempList;
    }

    public ArrayList<Lunches> getLoadLunches() {
        return loadLunches;
    }

    public void setLoadLunches(ArrayList<Lunches> loadLunches) {
        this.loadLunches = loadLunches;
    }

    private void generateLunches() {
        ArrayList<Lunches> tempLunchList = new ArrayList<>();
        for (int i = 1; i < 6; i++) {
            for (int j = 0; j < 3; j++) {
                Lunches lunch = new Lunches();
                lunch.setLunchDay(i);
                lunch.setLunchName("Maträtt");
                lunch.setLunchWeek(week);
                tempLunchList.add(lunch);
            }
        }
        this.loadLunches = tempLunchList;
    }

    private void updateWeeksInList() {
        for (Lunches lunches : loadLunches) {
            lunches.setLunchWeek(week);
        }
    }

    public void persist(Lunches meal) {
        try {
            utx.begin();
            em.persist(meal);
            utx.commit();
        } catch (Exception e) {
            System.err.println(e);
            throw new RuntimeException(e);
        }
    }

}
