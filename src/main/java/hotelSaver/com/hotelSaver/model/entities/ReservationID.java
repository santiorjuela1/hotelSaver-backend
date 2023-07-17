package hotelSaver.com.hotelSaver.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationID implements Serializable {
    private UserID userID;
    private String hotelID;

}
