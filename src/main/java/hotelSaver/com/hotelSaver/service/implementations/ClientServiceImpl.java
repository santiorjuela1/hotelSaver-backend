package hotelSaver.com.hotelSaver.service.implementations;

import hotelSaver.com.hotelSaver.configurations.mapper.ClientMapper;
import hotelSaver.com.hotelSaver.model.entities.ClienteEntity;
import hotelSaver.com.hotelSaver.model.entities.ReservationEntity;
import hotelSaver.com.hotelSaver.model.entities.ReservationID;
import hotelSaver.com.hotelSaver.model.entities.UserID;
import hotelSaver.com.hotelSaver.model.repositories.ClientRepository;
import hotelSaver.com.hotelSaver.model.repositories.ReservationRepository;
import hotelSaver.com.hotelSaver.service.interfaces.ClienteService;
import hotelSaver.com.hotelSaver.web.dto.ClientDtoRequest;
import hotelSaver.com.hotelSaver.web.dto.ClienteDTO;
import hotelSaver.com.hotelSaver.web.exceptions.types.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClienteService {

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    ClientMapper clientMapper;

    @Override
    public ClientDtoRequest createClient(ClientDtoRequest clienteDTO) {

        UserID userID = new UserID(clienteDTO.getDocumentoUser(), clienteDTO.getTipoDocumento());
        ReservationID reservationID = new ReservationID(userID, clienteDTO.getHotelID());

        ReservationEntity reservationEntity = reservationRepository.findById(reservationID)
                .orElseThrow(() -> new NotFoundException("Id not found!"));

        ClienteEntity clienteEntity = clientMapper.toClienteEntity(clienteDTO);
        clienteEntity.setReservationEntity(reservationEntity);

        clienteEntity = clientRepository.save(clienteEntity);

        return clientMapper.toClientDtoRequest(clienteEntity);
    }

    @Override
    public ClienteDTO getClient(Long documento) {
        return null;
    }

    @Override
    public HttpStatus deleteClient(Long documento) {
        return null;
    }

    @Override
    public ClienteDTO updateClient(ClienteDTO clienteDTO) {
        return null;
    }
}
