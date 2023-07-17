package hotelSaver.com.hotelSaver.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
@Data
@AllArgsConstructor
public class UserID implements Serializable {
    private Long documento;
    private String tipoDocumento;
}
