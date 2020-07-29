package ru.kalashnikov.example.auction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.kalashnikov.example.auction.entity.Guest;
import ru.kalashnikov.example.auction.entity.Role;
import ru.kalashnikov.example.auction.repository.GuestRepository;

import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {
    @Autowired
    private GuestRepository guestRepository;

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addGuest(Guest guest, Map<String, Object> model) {
        Guest guestFromDb = guestRepository.findByGuestname(guest.getGuestname());
        if (guestFromDb != null) {
            model.put("message", "Guest exists ");
            return "registration";
        }
        guest.setGuestname(guest.getGuestname());
        guest.setActive(true);
        guest.setRoles(Collections.singleton(Role.GUEST));
        guestRepository.save(guest);
        return "redirect:/login";
    }

}
