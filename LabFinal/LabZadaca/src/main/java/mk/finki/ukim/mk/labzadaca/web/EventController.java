package mk.finki.ukim.mk.labzadaca.web;


import mk.finki.ukim.mk.labzadaca.model.Event;
import mk.finki.ukim.mk.labzadaca.model.Location;
import mk.finki.ukim.mk.labzadaca.model.exceptions.InvalidCasting;
import mk.finki.ukim.mk.labzadaca.service.EventService;
import mk.finki.ukim.mk.labzadaca.service.LocationService;
import mk.finki.ukim.mk.labzadaca.service.impl.LocationServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/events")
public class EventController {

    private final EventService eventService;
    private final LocationServiceImpl locationService;

    public EventController(EventService eventService, LocationServiceImpl locationService) {
        this.eventService = eventService;
        this.locationService = locationService;
    }

    @GetMapping
    public String getEventsPage(@RequestParam(required=false) String error,
                                @RequestParam(required = false) String nameSearch,
                                @RequestParam(required = false) String rating,
                                Model model){
        if(error!=null && !error.isEmpty()){
            model.addAttribute("hasError", true);
            model.addAttribute("error",error);
        }

        List<Event> events;
        List<Location> locations = locationService.findAll();
        if (locations == null) {
            locations = List.of();
        }
        model.addAttribute("locations",locations);


        try {
            if(nameSearch!=null && rating!=null ){
                events=eventService.searchEvents(nameSearch,Double.parseDouble(rating));
            }
            else{
                events=eventService.listAll();
            }
        }catch (InvalidCasting e){
            model.addAttribute("hasError", true);
            model.addAttribute("error", "Invalid rating value. Please enter a valid number.");
            events=eventService.listAll();
        }

        model.addAttribute("events",events);
        return "listEvents";
    }

    @GetMapping("/filterByLocation")
    public String getEventsByLocation(@RequestParam Location location,Model model){
        List<Event> events=eventService.searchEventsByLocation(location);
        model.addAttribute("events",events);

        List<Location> locations = locationService.findAll();
        if (locations == null) {
            locations = List.of();
        }
        model.addAttribute("locations",locations);

        return "listEvents";
    }

    @GetMapping("/delete/{id}")
    public String addEventPage(@PathVariable Long id){
        eventService.deleteById(id);
        return "redirect:/events";
    }


    @GetMapping("/add-Form")
    public String addEventPage(Model model){
        model.addAttribute("event",new Event());
        List<Location> locations = locationService.findAll();
        if (locations == null) {
            locations = List.of();
        }
        model.addAttribute("locations",locations);
        return "addEvent";
    }

    @GetMapping("/edit-form/{id}")
    public String editEventPage(Model model, @PathVariable Long id){
        Event event = eventService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid event ID: " + id));
        List<Location> locations = locationService.findAll();
        if (locations == null) {
            locations = List.of();
        }
        model.addAttribute("locations",locations);
        model.addAttribute("event",event);
        return "editEvent";
    }

    @PostMapping("/save")
    public String save(@RequestParam(required = false) Long id,
                       @RequestParam String name,
                       @RequestParam String description,
                       @RequestParam Double rating,
                       @RequestParam Long location){

        if(id!=null){
            eventService.update(id, name, description, rating,location);
        }else{
            eventService.save(name,description,rating,location);
        }
        return "redirect:/events";
    }

    @GetMapping("/increase/{id}")
    public String increaseRating(@PathVariable Long id) {
        eventService.increaseRating(id);
        return "redirect:/events";
    }

    @GetMapping("/decrease/{id}")
    public String decreaseRating(@PathVariable Long id) {
        eventService.decreaseRating(id);
        return "redirect:/events";
    }


}
