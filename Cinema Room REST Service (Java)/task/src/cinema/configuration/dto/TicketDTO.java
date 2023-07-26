package cinema.configuration.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record TicketDTO(String token, @JsonProperty(value = "ticket") SeatDTO seat) {
}
