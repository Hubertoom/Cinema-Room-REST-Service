package cinema.configuration.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record StatisticsDTO(@JsonProperty("current_income") Integer currentIncome,
                            @JsonProperty("number_of_available_seats")Integer numberOfAvailableSeats,
                            @JsonProperty("number_of_purchased_tickets")Integer numberOfPurchasedTickets) {
}