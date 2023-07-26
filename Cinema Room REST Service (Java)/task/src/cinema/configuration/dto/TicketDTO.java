<<<<<<< HEAD:Cinema Room REST Service (Java)/task/src/cinema/model/dto/TicketDTO.java
package cinema.model.dto;
=======
package cinema.configuration.dto;
>>>>>>> master:Cinema Room REST Service (Java)/task/src/cinema/configuration/dto/TicketDTO.java

import com.fasterxml.jackson.annotation.JsonProperty;

public record TicketDTO(String token, @JsonProperty(value = "ticket") SeatDTO seat) {
}
