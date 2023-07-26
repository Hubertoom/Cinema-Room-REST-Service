package cinema.controller;

import cinema.model.CinemaRoom;
import cinema.model.Seat;
import cinema.service.CinemaService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class CinemaController {

    private CinemaService cinemaService;

    @GetMapping("/seats")
    public CinemaRoom getCinemaRoom() {
        return cinemaService.getCinemaRoom();
    }

    @PostMapping("/purchase")
    public Seat bookASeat(@RequestBody Seat seat) {
        return cinemaService.bookASeat(seat);
    }
}
