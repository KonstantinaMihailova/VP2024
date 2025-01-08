package mk.finki.ukim.mk.labzadaca.web;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/eventBooking")
public class EventBookingController {

    @PostMapping
    public String getEventBookingPage(@RequestParam Integer numTickets,
                                      @RequestParam String name,
                                      HttpServletRequest request,
                                      Model model){
        String hostAddress=request.getRemoteAddr();
        model.addAttribute("hostAddress",hostAddress);
        model.addAttribute("event",name);
        model.addAttribute("numTickets",numTickets);

        return "bookingConfirmation";
    }


}
