package cinema.service;

import cinema.exceptions.RowOrColumOutOfBoundException;
import cinema.exceptions.TicketSoldException;
import cinema.model.CinemaRoom;
import cinema.model.Seat;
import cinema.model.dto.CinemaRoomDTO;
import cinema.model.dto.Mapper;
import cinema.model.dto.SeatDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CinemaService {

    private CinemaRoom cinemaRoom;

    public CinemaRoomDTO getCinemaRoomDTO() {
        return Mapper.convertCinemaRoomToCinemaRoomDTO(cinemaRoom);
    }

    public SeatDTO bookASeat(SeatDTO seatDTO) {
        Optional<Seat> optionalSeat = cinemaRoom.getAvailableSeats().stream()
                .filter(seat -> Objects.equals(seat.getRow(), seatDTO.row()) &&
                        Objects.equals(seat.getColumn(), seatDTO.column()))
                .findAny();

        if (optionalSeat.isEmpty()) {
            throw new RowOrColumOutOfBoundException("The number of a row or a column is out of bounds!");
        }

        if (optionalSeat.get().isOccupied()) {
            throw new TicketSoldException("The ticket has been already purchased!");
        }

        optionalSeat.get().setOccupied(true);

        return Mapper.convertSeatToSeatDTO(optionalSeat.get());
    }
}
