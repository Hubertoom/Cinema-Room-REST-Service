package cinema.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.util.List;

@AllArgsConstructor
@Getter
public class CinemaRoom {
    private int totalRows;
    private int totalColumns;
    private List<Seat> availableSeats;
    private List<Ticket> ticketsList;
}
