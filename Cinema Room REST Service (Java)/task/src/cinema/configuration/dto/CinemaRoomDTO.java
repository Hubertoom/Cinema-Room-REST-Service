package cinema.configuration.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class CinemaRoomDTO {
    @JsonProperty(value = "total_rows")
    private int totalRows;

    @JsonProperty(value = "total_columns")
    private int totalColumns;

    @JsonProperty(value = "available_seats")
    private List<SeatDTO> availableSeats;
}