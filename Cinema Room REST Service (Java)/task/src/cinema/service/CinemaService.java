package cinema.service;

import cinema.exceptions.RowOrColumOutOfBoundException;
import cinema.exceptions.TicketSoldException;
import cinema.model.CinemaRoom;
import cinema.model.Seat;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@AllArgsConstructor
public class CinemaService {

    private CinemaRoom cinemaRoom;

    public CinemaRoom getCinemaRoom() {
        return cinemaRoom;
    }

    public Seat bookASeat(Seat seat) {
        if (seat.column() > cinemaRoom.getTotalColumns()
                || seat.row() > cinemaRoom.getTotalRows()
                || seat.row() < 1
                || seat.column() < 1
        ) {
            throw new RowOrColumOutOfBoundException("The number of a row or a column is out of bounds!");
        }

        for (int i = 0; i < cinemaRoom.getAvailableSeats().size(); i++) {
            Seat tempSeat = getCinemaRoom().getAvailableSeats().get(i);
            if (Objects.equals(tempSeat.row(), seat.row()) && Objects.equals(tempSeat.column(), seat.column())) {
                getCinemaRoom().getAvailableSeats().remove(i);

                return tempSeat;
            }
        }
        throw new TicketSoldException("The ticket has been already purchased!");
    }
}
