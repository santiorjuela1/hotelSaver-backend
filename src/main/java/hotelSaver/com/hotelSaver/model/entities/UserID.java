package hotelSaver.com.hotelSaver.model.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Transient;
import java.io.Serializable;
@Getter
@Setter
@Data
@Embeddable
@NoArgsConstructor

public class UserID implements Serializable {
    @Column(name = "documento")
    private Long documento;

    @Column(name = "tipo_documento")
    private String tipoDocumento;

    public UserID(Long documento, String tipoDocumento)
    {
        this.documento = documento;
        this.tipoDocumento = tipoDocumento;
    }
}
