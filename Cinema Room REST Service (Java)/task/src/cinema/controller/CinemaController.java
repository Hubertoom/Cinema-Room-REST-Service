package cinema.controller;

import cinema.configuration.dto.*;
import cinema.service.CinemaService;
import cinema.service.StatisticsService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class CinemaController {

    private CinemaService cinemaService;
    private StatisticsService statisticsService;

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

    @GetMapping("/stats")
    public ResponseEntity<StatisticsDTO> getStatistics(
            @RequestParam(value = "password", required = false) String password
    ) {
        return ResponseEntity
                .ok()
                .body(statisticsService.getStatistics(password));
    }
}
