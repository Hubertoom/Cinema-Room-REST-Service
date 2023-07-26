package cinema.configuration;

import cinema.model.CinemaRoom;
import cinema.model.Seat;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class CinemaConfiguration {

    @Bean
    public CinemaRoom cinemaRoom() {
        return new CinemaRoom(9, 9, getSeats());
    }

    private List<Seat> getSeats() {
        List<Seat> seats = new ArrayList<>();

        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                seats.add(new Seat(i, j));
            }
        }
        return seats;
    }
}
