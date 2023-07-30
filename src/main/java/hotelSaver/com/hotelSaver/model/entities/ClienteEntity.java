package hotelSaver.com.hotelSaver.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "clientes")
public class ClienteEntity {
    @Id
    @Column(name = "documento_cliente")
    private Long documento;
    @Column(name = "tipo_documento_cliente")
    private String tipoDocumento;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "hotel_id_user", referencedColumnName = "hotel_id"),
            @JoinColumn(name = "documento_user", referencedColumnName = "documento"),
            @JoinColumn(name = "tipo_documento_user", referencedColumnName = "tipo_documento")
    })
    private ReservationEntity reservationEntity;
}
