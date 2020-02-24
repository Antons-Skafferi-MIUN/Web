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

/**
 *
 * @author joaki
 */
@Named(value = "printAdmin")
@Dependent
public class PrintAdmin {

    private ArrayList<Integer> weekList;

    public PrintAdmin() {
        this.weekList = new ArrayList<>();
        updateWeeks();
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
