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
public class PrintMenu {

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

//        String response = urlReader.readJsonFromURL("http://antons-skafferi-api.herokuapp.com/lunches/week?="+getWeek());
//        if(!response){
//            response = urlReader.readJsonFromURL("http://antons-skafferi-api.herokuapp.com/lunches/week?="+getWeek()-1;
//        }
        String response = urlReader.readJsonFromURL("http://antons-skafferi-api.herokuapp.com/lunches");
        lunchList = jsonParser.parseJson(response, Lunch[].class);

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

//    public String getWeekClass(int i) {
//        if (i == getDay()) {
//            return "menu-container--current";
//        } else if (i < getDay()) {
//            return "menu-container--past";
//        } else {
//            return "menu-container--next";
//        }
//    }

}
