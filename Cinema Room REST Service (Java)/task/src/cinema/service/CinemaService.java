package cinema.service;

import cinema.exceptions.RowOrColumOutOfBoundException;
import cinema.exceptions.TicketSoldException;
import cinema.exceptions.WrongTokenError;
import cinema.model.CinemaRoom;
import cinema.model.Seat;
import cinema.model.Ticket;
import cinema.model.dto.CinemaRoomDTO;
import cinema.model.dto.Mapper;
import cinema.model.dto.SeatDTO;
import cinema.model.dto.TicketDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CinemaService {

    private CinemaRoom cinemaRoom;

    public CinemaRoomDTO getCinemaRoomDTO() {
        return Mapper.convertCinemaRoomToCinemaRoomDTO(cinemaRoom);
    }

    public TicketDTO bookASeat(SeatDTO seatDTO) {
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

        Seat seat = optionalSeat.get();
        seat.setOccupied(true);
        Ticket ticket = new Ticket(UUID.randomUUID().toString(), seat);
        cinemaRoom.getTicketsList().add(ticket);

        return Mapper.convertTicketToTicketDTO(ticket);
    }

    public TicketDTO returnTicket(TicketDTO ticketDTO) {
        Ticket ticket = cinemaRoom.getTicketsList().stream()
                .filter(t -> t.token().equals(ticketDTO.token()))
                .findAny()
                .orElseThrow(() -> new WrongTokenError("Wrong token!"));

        ticket.seat().setOccupied(false);
        cinemaRoom.getTicketsList().remove(ticket);

        return Mapper.convertTicketToTicketDTO(ticket);
    }
}
