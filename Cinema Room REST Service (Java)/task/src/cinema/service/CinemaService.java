package cinema.service;

import cinema.model.CinemaRoom;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CinemaService {

    private CinemaRoom cinemaRoom;

    public CinemaRoom getCinemaRoom() {
        return cinemaRoom;
    }
}
