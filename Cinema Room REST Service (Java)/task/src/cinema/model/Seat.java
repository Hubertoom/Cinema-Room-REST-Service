package cinema.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public final class Seat {
    private final Integer row;
    private final Integer column;
    private final Integer price;
    private boolean isOccupied;

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }
}

