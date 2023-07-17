package hotelSaver.com.hotelSaver.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Transient;
import java.io.Serializable;
@Data
@AllArgsConstructor

@Embeddable
public class UserID implements Serializable {
    @Column(name = "documento")
    private Long documento;

    @Column(name = "tipo_documento")
    private String tipoDocumento;
}
