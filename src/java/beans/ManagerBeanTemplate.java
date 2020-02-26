//package beans;
//
//import java.util.List;
//import java.util.Map;
//import java.util.TreeMap;
//import javax.inject.Named;
//import javax.enterprise.context.Dependent;
//
//@Named(value = "managerBeanTemplate")
//@Dependent
//public class ManagerBeanTemplate {
//
//    private List<Lunch> lunches; // Returnerar en lista med lunchobjekt
//    private List<Dinner> dinnerMenu; // Same as lunch
//    private List<Events> events;
//    private List<Schedule> scheduleList;
//    private TreeMap<String, Employee> staffMap = new TreeMap<>();
//    private DBAccessBean dbAccessBean;
//
//    public ManagerBeanTemplate() {
//        for(Map.entry<String, Employee> item :  staffMap.entrySet()) {
//            item.getKey();
//            List<Shift> schedule = item.getValue().getSchedule().getShifts;
//
//            // Java code for html print
//            for (Shift shift : schedule) {
//                if(shift.getLunch()){
//                    //do something
//                } else {
//                    // Empty box
//                } 
//                if(shift.getDinner()) {
//                    
//                } else {
//                    // Empty box
//                }
//            }
//        }
//    }
//    
//    public List<Lunch> getLunches() {
//        return lunches;
//    }
//    
//    public List<Events> getEvents() {
//        return events;
//    }
//
//    public class Shift {
//
//        private Boolean lunch;
//        private Boolean dinner;
//        private String date;
//
//        public Shift() {
//        }
//        
//        public Boolean getLunch() {
//            return lunch;
//        }
//
//        public void setLunch(Boolean lunch) {
//            this.lunch = lunch;
//        }
//
//        public Boolean getDinner() {
//            return dinner;
//        }
//
//        public void setDinner(Boolean dinner) {
//            this.dinner = dinner;
//        }
//        
//    }
//    
//    public class Employee {
//
//        // <Week, Schedule>
//        private TreeMap<Integer, Schedule> schedule;
//        
//        private String name;
//        private String employeeId;
//        private String occupation;
////        private String phoneNumber;
////        private String email;
//
//        public Employee() {
//        }
//    }
//
//    public class Schedule {
//
//        private List<Shift> shifts;
//
//        public Schedule() {
//        }
//    }
//}
