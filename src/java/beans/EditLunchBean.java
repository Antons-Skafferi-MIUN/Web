package beans;

import General.Lunch;
import java.util.ArrayList;
import java.util.Calendar;
import javax.inject.Named;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@Named(value = "editLunchBean")
@ManagedBean
@SessionScoped

public class EditLunchBean {

    private Integer day;

    private Integer week;
    private ArrayList<Integer> weekList;
    private Integer thisWeek;

    private String meal;
    private ArrayList<Lunch> lunchList;
    private ArrayList<Lunch> loadLunches;

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

        for (Lunch meals : loadLunches) {
            if (!meals.getLunch_name().isEmpty()) {
                lunchList.add(meals);
            }
        }

        
        //lunchList to DB.

        
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
        for (int i = 0; i < 3; i++) {
            tempList.add(cal.get(Calendar.WEEK_OF_YEAR) + i);
        }
        this.weekList = tempList;
    }

    public ArrayList<Lunch> getLoadLunches() {
        return loadLunches;
    }

    public void setLoadLunches(ArrayList<Lunch> loadLunches) {
        this.loadLunches = loadLunches;
    }

    private void generateLunches() {
        ArrayList<Lunch> tempLunchList = new ArrayList<>();
        for (int i = 1; i < 6; i++) {
            for (int j = 0; j < 3; j++) {
                Lunch lunch = new Lunch();
                lunch.setLunch_day(i);
                lunch.setLunch_name(null);
                lunch.setLunch_week(week);
                tempLunchList.add(lunch);
            }
        }
        this.loadLunches = tempLunchList;
    }

    private void updateWeeksInList() {
        for (Lunch lunches : loadLunches) {
            lunches.setLunch_week(week);
        }
    }

}
