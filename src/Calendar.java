import java.util.ArrayList;

public class Calendar {

    private ArrayList<Event> events = new ArrayList<Event>();
    private ArrayList<Deadline> deadlines = new ArrayList<>();

    public Calendar(){
        System.out.println("init calendar");
    }
    public void addEvent(Event e){
        System.out.println("adding Event");
        events.add(e);
    }
    public void addDeadline(Deadline d){
        System.out.println("adding deadline");
        events.add(d);
    }
}
