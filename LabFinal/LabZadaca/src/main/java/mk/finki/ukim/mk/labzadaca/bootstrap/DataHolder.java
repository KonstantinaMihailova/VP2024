package mk.finki.ukim.mk.labzadaca.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.finki.ukim.mk.labzadaca.model.Event;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {

    public static List<Event> events=new ArrayList<>();


    @PostConstruct
    public static void init(){

//        events.add(new Event("Marathon","Marathon best event!",4.1));
//        events.add(new Event("IT Competition","IT Competition best event!",7.6));
//        events.add(new Event("Quiz","Quiz best event!",2.3));
    }

}
