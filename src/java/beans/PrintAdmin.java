/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.ArrayList;
import java.util.Calendar;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author joaki
 */
@Named(value = "printAdmin")
@ManagedBean
@SessionScoped

public class PrintAdmin {

    private ArrayList<Integer> weekList;
    private Integer thisWeek;
    private Integer week;


    public PrintAdmin() {
        this.weekList = new ArrayList<>();
        updateWeeks();
    }
    
    public Integer getWeek() {
        return week;
    }

    public void setWeek(Integer week) {
        this.week = week;
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
    
    
}
