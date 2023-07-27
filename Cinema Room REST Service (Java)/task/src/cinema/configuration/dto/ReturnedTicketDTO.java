package cinema.configuration.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ReturnedTicketDTO(@JsonProperty("returned_ticket") SeatDTO seatDTO) {
}
