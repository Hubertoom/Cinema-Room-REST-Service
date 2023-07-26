package cinema.configuration.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record SeatDTO(Integer row, Integer column, Integer price) {
}
