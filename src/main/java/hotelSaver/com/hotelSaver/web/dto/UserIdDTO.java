package hotelSaver.com.hotelSaver.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserIdDTO {
    private Long documento;
    private String tipoDocumento;
}
