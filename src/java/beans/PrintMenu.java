/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import General.JsonParser;
import General.Lunch;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.TreeMap;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import networking.JsonURLReader;
import java.util.Date;

/**
 *
 * @author joaki
 */
@Named(value = "printMenu")
@Dependent
public final class PrintMenu {

    private ArrayList<Lunch> lunchList;
    private JsonURLReader urlReader;
    private JsonParser jsonParser;
    private String lunch_id;
    private String lunch_name;
    private String lunch_week;
    private String lunch_day;

    public PrintMenu() {
        urlReader = new JsonURLReader();
        lunchList = new ArrayList<>();
        jsonParser = new JsonParser();

        String response = urlReader.readJsonFromURL("http://antons-skafferi-api.herokuapp.com/lunches?week=" + getWeek());

        if(response.isEmpty()){
            response = urlReader.readJsonFromURL("http://antons-skafferi-api.herokuapp.com/lunches/week?="+(getWeek() -1));
        }
        lunchList = jsonParser.parseJson(response, Lunch[].class);
        //String response = urlReader.readJsonFromURL("http://antons-skafferi-api.herokuapp.com/lunches");
    }

    public ArrayList<Lunch> getLunch() {
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
