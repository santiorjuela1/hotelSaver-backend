package hotelSaver.com.hotelSaver.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationIdDTO {
    private UserIdDTO userID;
    private String hotelID;
}
