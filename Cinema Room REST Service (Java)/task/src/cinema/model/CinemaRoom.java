package cinema.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class CinemaRoom {

    @JsonProperty(value = "total_rows")
    private int totalRows;

    @JsonProperty(value = "total_columns")
    private int totalColumns;

    @JsonProperty(value = "available_seats")
    private List<Seat> availableSeats;
}
