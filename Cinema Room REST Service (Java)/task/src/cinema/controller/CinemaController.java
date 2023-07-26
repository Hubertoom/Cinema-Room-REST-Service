package cinema.controller;

import cinema.model.CinemaRoom;
import cinema.service.CinemaService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class CinemaController {

    private CinemaService cinemaService;

    @GetMapping("/seats")
    public CinemaRoom getCinemaRoom() {
        return cinemaService.getCinemaRoom();
    }
}
