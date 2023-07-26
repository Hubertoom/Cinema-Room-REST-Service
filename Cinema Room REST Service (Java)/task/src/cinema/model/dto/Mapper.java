package cinema.model.dto;

import cinema.model.CinemaRoom;
import cinema.model.Seat;

import java.util.List;

public class Mapper {

    public static SeatDTO convertSeatToSeatDTO(Seat seat) {
        return new SeatDTO(seat.getRow(),
                seat.getColumn(),
                seat.getPrice());
    }

    public static CinemaRoomDTO convertCinemaRoomToCinemaRoomDTO(CinemaRoom cinemaRoom) {
        List<SeatDTO> seatsDTO = cinemaRoom.getAvailableSeats().stream()
                .map(Mapper::convertSeatToSeatDTO)
                .toList();

        return new CinemaRoomDTO(cinemaRoom.getTotalRows(),
                cinemaRoom.getTotalColumns(),
                seatsDTO
        );
    }
}
