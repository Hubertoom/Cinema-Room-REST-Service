package cinema.service;

import cinema.configuration.dto.Mapper;
import cinema.configuration.dto.StatisticsDTO;
import cinema.exceptions.WrongPasswordException;
import cinema.model.CinemaRoom;
import cinema.model.Statistics;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class StatisticsService {

    @Value(value = "${cinema.password}")
    private String secretPassword;

    private final CinemaRoom cinemaRoom;

    public StatisticsService(CinemaRoom cinemaRoom) {
        this.cinemaRoom = cinemaRoom;
    }

    public StatisticsDTO getStatistics(String password) {

        if (Objects.isNull(password) || !Objects.equals(password, secretPassword)) {
            throw new WrongPasswordException("The password is wrong!");
        }

        return Mapper.convertStatisticToStatisticDTO(
                new Statistics(
                        getCurrentIncome(),
                        getNumberOfAvailableSeats(),
                        getNumberOfPurchasedTickets()
                )
        );
    }

    public Integer getCurrentIncome() {
        return cinemaRoom.getTicketsList().stream()
                .mapToInt(ticket -> ticket.seat().getPrice())
                .sum();
    }

    public Integer getNumberOfAvailableSeats() {
        return (int) cinemaRoom.getAvailableSeats().stream()
                .filter(seat -> !seat.isOccupied())
                .count();
    }

    public Integer getNumberOfPurchasedTickets() {
        return cinemaRoom.getTicketsList().size();
    }
}
