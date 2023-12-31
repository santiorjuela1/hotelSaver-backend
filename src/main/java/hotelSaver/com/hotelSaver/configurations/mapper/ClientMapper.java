package hotelSaver.com.hotelSaver.configurations.mapper;

import hotelSaver.com.hotelSaver.model.entities.ClienteEntity;
import hotelSaver.com.hotelSaver.web.dto.ClientDtoRequest;
import hotelSaver.com.hotelSaver.web.dto.ClienteDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public abstract class ClientMapper {
/*    @Mappings({
            @Mapping(source = "clienteEntity.documento", target = "documento"),
            @Mapping(source = "clienteEntity.tipoDocumento", target = "tipoDocumento")
          //  @Mapping(source = "clienteEntity.reservationEntity.reservationID.userID.documento", target = "")
    })
    public abstract ClienteDTO toClienteDTO(ClienteEntity clienteEntity);
    public abstract ClienteEntity toClienteEntity(ClienteDTO clienteDTO);*/

    @Mappings({
            @Mapping(source = "reservationEntity.reservationID.userID.documento", target = "documentoUser"),
            @Mapping(source = "reservationEntity.reservationID.userID.tipoDocumento", target = "tipoDocumentoUser"),
            @Mapping(source = "reservationEntity.reservationID.hotelID", target = "hotelID")
    })
    public abstract ClientDtoRequest toClientDtoRequest(ClienteEntity clienteEntity);
    public abstract ClienteEntity toClienteEntity(ClientDtoRequest clientDtoRequest);
}
