package hotelSaver.com.hotelSaver.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDtoRequest {
    private Long documento;
    private String tipoDocumento;
    private String hotelID;
    private Long documentoUser;
    private String tipoDocumentoUser;
}
