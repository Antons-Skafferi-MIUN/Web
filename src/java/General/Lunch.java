package General;

public class Lunch {
    private String lunch_id;
    private String lunch_name;
    private Integer lunch_week;
    private Integer lunch_day;

    public Integer getLunch_week() {
        return lunch_week;
    }

    public void setLunch_week(Integer lunch_week) {
        this.lunch_week = lunch_week;
    }

    public Integer getLunch_day() {
        return lunch_day;
    }

    public void setLunch_day(Integer lunch_day) {
        this.lunch_day = lunch_day;
    }

    public String getLunch_id() {
        return lunch_id;
    }

    public void setLunch_id(String lunch_id) {
        this.lunch_id = lunch_id;
    }

    public String getLunch_name() {
        return lunch_name;
    }

    public void setLunch_name(String lunch_name) {
        this.lunch_name = lunch_name;
    }

}
