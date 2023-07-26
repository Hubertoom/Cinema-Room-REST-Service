package cinema.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record SeatDTO(Integer row, Integer column, Integer price) {
}
