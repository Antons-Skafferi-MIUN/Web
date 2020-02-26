package beans;

import javax.inject.Named;
import javax.enterprise.context.Dependent;

@Named(value = "submitBean")
@Dependent
public class SubmitBean {

    private Integer week = 9;
    private String meal = "default";
    private String result;

    public void submit() {
        result = "Submitted values: " + meal + ", " + week;
        System.out.println(result);
    }

    public String getMeal() {
        return meal;
    }

    public void setMeal(String meal) {
        this.meal = meal;
    }

    public Integer getWeek() {
        return week;
    }

    public void setWeek(Integer week) {
        this.week = week;
    }

    public String getResult() {
        return result;
    }

    public void changeIn() {
        System.out.println("meal has been changed to " + meal);
    }

}
