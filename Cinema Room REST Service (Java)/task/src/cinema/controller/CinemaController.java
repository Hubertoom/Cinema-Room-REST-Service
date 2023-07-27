package cinema.controller;

import cinema.configuration.dto.CinemaRoomDTO;
import cinema.configuration.dto.ReturnedTicketDTO;
import cinema.configuration.dto.SeatDTO;
import cinema.configuration.dto.TicketDTO;
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
    public ResponseEntity<ReturnedTicketDTO> returnTicket(@RequestBody TicketDTO ticketDTO) {
        return ResponseEntity
                .ok()
                .body(cinemaService.returnTicket(ticketDTO));
    }
}
