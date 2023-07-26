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

        for (int row = 1; row < 10; row++) {
            for (int col = 1; col < 10; col++) {
                int price = row <= 4 ? 10 : 8;
                seats.add(new Seat(row, col, price));
            }
        }
        return seats;
    }
}
