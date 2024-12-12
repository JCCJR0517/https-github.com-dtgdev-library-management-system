package com.example.library.controller;

import com.example.library.model.Reservation;
import com.example.library.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @PostMapping
    public String reserveBook(@RequestParam Long memberId, @RequestParam Long bookId) {
        return reservationService.reserveBook(memberId, bookId);
    }

    @GetMapping("/queue/{bookId}")
    public List<Reservation> getReservationQueue(@PathVariable Long bookId) {
        return reservationService.getReservationQueueForBook(bookId);
    }
}
