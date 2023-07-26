package cinema.controller;

<<<<<<< HEAD
import cinema.model.dto.CinemaRoomDTO;
import cinema.model.dto.SeatDTO;
import cinema.model.dto.TicketDTO;
=======
import cinema.configuration.dto.CinemaRoomDTO;
import cinema.configuration.dto.SeatDTO;
import cinema.configuration.dto.TicketDTO;
>>>>>>> master
import cinema.service.CinemaService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@AllArgsConstructor
public class CinemaController {

    private CinemaService cinemaService;

    @GetMapping("/seats")
    public ResponseEntity<CinemaRoomDTO> getCinemaRoom() {
        return ResponseEntity
                .ok()
                .body(cinemaService.getCinemaRoomDTO());
    }

    @PostMapping("/purchase")
    public ResponseEntity<TicketDTO> bookASeat(@RequestBody SeatDTO seatDTO) {
        return ResponseEntity
                .ok()
                .body(cinemaService.bookASeat(seatDTO));
    }

    @PostMapping("/return")
    public ResponseEntity<Object> returnTicket(@RequestBody TicketDTO ticketDTO) {
        return ResponseEntity
                .ok()
                .body(Map.of("returned_ticket", cinemaService.returnTicket(ticketDTO).seat()));
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> master
